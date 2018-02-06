package com.example.sara.mysimplemath.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sara.mysimplemath.R;
import com.example.sara.mysimplemath.other.AvailablePlayers;
import com.example.sara.mysimplemath.other.AvailablePlayersAdapter;
import com.example.sara.mysimplemath.other.DividerItemDecoration;
import com.example.sara.mysimplemath.other.RecyclerTouchListenerAvailablePlayers;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AvailablePlayersActivity extends AppCompatActivity{

    private DatabaseReference mDatabase;
    private DatabaseReference mReference;

    private String usernameKey;

    public List<AvailablePlayers> availableplayersList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AvailablePlayersAdapter availableplayersAdapter;
    RecyclerTouchListenerAvailablePlayers recyclerTouchListenerAvailablePlayers;
    private EditText search;
    private Toolbar toolbar;
    private boolean isNewActiviy = false;
    private boolean thisPlayerSelectedTeammate = false;
    TextView textViewPleaseWaitOrAnswer;
    private String firstChild;
    private PopupWindow popupWindow;
    boolean communictionChildExists = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_players);
        toolbar =(Toolbar) findViewById(R.id.toolbar_available_players);
        toolbar.setTitle("Choose teammate");
        setSupportActionBar(toolbar);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        //this child is for list of players usernames
        mDatabase.child("players").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                AvailablePlayers current_username = dataSnapshot.getValue(AvailablePlayers.class);
                for(int i = 0; i<availableplayersList.size(); i++){
                    if(availableplayersList.get(i).getUsername().equals(current_username.getUsername())){
                        removeItem(i);
                        break;
                    }
                }
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //this child is used for communication
        mDatabase.child("communication").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                communictionChildExists = true;
                final DataSnapshot child = dataSnapshot;
                final String ChildsName = dataSnapshot.getKey();
                Iterable<DataSnapshot> newChild = dataSnapshot.getChildren();
                //ako je igrac odabrao nekog
                if(thisPlayerSelectedTeammate){
                    for(DataSnapshot el : newChild){
                        if(el.getValue().equals(usernameKey)){
                            mDatabase.child("communication").child(ChildsName).addChildEventListener(new ChildEventListener() {
                                @Override
                                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                                    if(dataSnapshot.getKey().equals("ZeliIgrati")) {
                                        if (dataSnapshot.getValue().toString().equals("da")) {
                                            thisPlayerSelectedTeammate = false;
                                            mReference.child(usernameKey).removeValue();
                                            isNewActiviy = true;
                                            Intent intent = new Intent(AvailablePlayersActivity.this, GameActivity.class);
                                            intent.putExtra("teammates_username", ChildsName);
                                            intent.putExtra("username", usernameKey);
                                            intent.putExtra("child", ChildsName);
                                            startActivity(intent);
                                            finish();
                                        } else {
                                            //enables recycler view items for clicking
                                            textViewPleaseWaitOrAnswer.setVisibility(View.GONE);
                                            toastMessage("Sorry the player that you chose doesn't want to play. Choose someone else.");
                                            firstChild = null;
                                            recyclerTouchListenerAvailablePlayers.touch = false;
                                            mDatabase.child("communication").child(ChildsName).removeValue();
                                            thisPlayerSelectedTeammate = false;
                                        }
                                    }
                                    if(dataSnapshot.getKey().equals("odustao")){
                                        if(!dataSnapshot.getValue().toString().equals(usernameKey)){
                                            textViewPleaseWaitOrAnswer.setVisibility(View.GONE);
                                            toastMessage("Player is no longer singed in.");
                                            recyclerTouchListenerAvailablePlayers.touch = false;
                                            mDatabase.child("communication").child(ChildsName).removeValue();
                                            thisPlayerSelectedTeammate = false;
                                            firstChild = null;
                                        }
                                    }
                                }


                                @Override
                                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                                }

                                @Override
                                public void onChildRemoved(DataSnapshot dataSnapshot) {

                                }

                                @Override
                                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });
                        }
                    }
                }
                //ako je netko tog igraca odabrao
                else if(ChildsName.equals(usernameKey)){
                    View view = search;
                    String teammate = "no teammate";
                    Iterable<DataSnapshot> all = child.getChildren();
                    for(DataSnapshot el : all){
                        if(el.getKey().equals("usernameKey")){
                            teammate=el.getValue().toString();
                        }
                    }
                    showPopUpDoYouWantToPlay(view, teammate ,ChildsName);

                    final String finalTeammate = teammate;
                    mDatabase.child("communication").child(ChildsName).addChildEventListener(new ChildEventListener() {
                                @Override
                                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                                    if(dataSnapshot.getKey().equals("ZeliIgrati")) {
                                        if (dataSnapshot.getValue().toString().equals("da")) {
                                            mReference.child(usernameKey).removeValue();
                                            isNewActiviy = true;
                                            Intent intent = new Intent(AvailablePlayersActivity.this, GameActivity.class);
                                            intent.putExtra("teammates_username", finalTeammate);
                                            intent.putExtra("child", usernameKey);
                                            intent.putExtra("username", usernameKey);
                                            startActivity(intent);
                                            finish();

                                        } else {
                                            //enables recycler view items for clicking
                                            recyclerTouchListenerAvailablePlayers.touch = false;
                                            mDatabase.child("communication").child(ChildsName).removeValue();
                                            firstChild = null;
                                        }
                                    }
                                    if(dataSnapshot.getKey().equals("odustao")){
                                        if(!dataSnapshot.getValue().toString().equals(usernameKey)){
                                            recyclerTouchListenerAvailablePlayers.touch = false;
                                            checkIfPopUpIsOpen();
                                            mDatabase.child("communication").child(ChildsName).removeValue();
                                            toastMessage("Player is no longer singed in.");
                                            firstChild = null;

                                        }
                                    }
                                }

                                @Override
                                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                                }

                                @Override
                                public void onChildRemoved(DataSnapshot dataSnapshot) {

                                }

                                @Override
                                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                    });

                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        // Get post key from intent
        usernameKey= getIntent().getStringExtra("username");

        // Initialize Database
        mReference = FirebaseDatabase.getInstance().getReference("players");


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        search = (EditText) findViewById(R.id.inputSearch);

        availableplayersAdapter = new AvailablePlayersAdapter(availableplayersList);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(availableplayersAdapter);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        textViewPleaseWaitOrAnswer=(TextView) findViewById(R.id.textViewPleaseWaitPlayer);

        //this is called when one of items in recyclerview is selected
        recyclerView.addOnItemTouchListener(recyclerTouchListenerAvailablePlayers=
                new RecyclerTouchListenerAvailablePlayers(getApplicationContext(), new RecyclerTouchListenerAvailablePlayers.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        AvailablePlayers availablePlayers = availableplayersList.get(position);
                        String userName = availablePlayers.getUsername();
                        firstChild = userName;
                        thisPlayerSelectedTeammate = true;
                        mDatabase.child("communication").child(userName).child("usernameKey").setValue(usernameKey);

                        textViewPleaseWaitOrAnswer.setVisibility(View.VISIBLE);
                        //disables recycler view items for clicking
                        recyclerTouchListenerAvailablePlayers.touch = true;
                    }
                })
        );

        // for searching available players
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                s = s.toString().toLowerCase();
                final List<AvailablePlayers> filterdList = new ArrayList<>();

                for(int i =0; i<availableplayersList.size(); i++){
                    final String text = availableplayersList.get(i).getUsername().toLowerCase();
                    if(text.contains(s)){
                        filterdList.add(availableplayersList.get(i));
                    }
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(AvailablePlayersActivity.this));
                availableplayersAdapter = new AvailablePlayersAdapter(filterdList);
                recyclerView.setAdapter(availableplayersAdapter);
                availableplayersAdapter.notifyDataSetChanged();
            }
        });
        addData();
    }

    /**
     * Method that adds usernames of other players to recyclerview
     */
    private void addData() {
        mDatabase.child("players").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<String> players = new ArrayList<String>();
                List<String> availableP = new ArrayList<>();
                for(int i=0; i<availableplayersList.size(); i++){
                    String player = availableplayersList.get(i).getUsername();
                    players.add(player);
                }
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    AvailablePlayers player = userSnapshot.getValue(AvailablePlayers.class);
                    String existingUsername = player.getUsername();
                    if (!existingUsername.equals(usernameKey)) {
                        if (!players.contains(existingUsername)) {
                            availableplayersList.add(player);
                            availableP.add(player.getUsername());
                        }
                    }
                }
                availableplayersAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });
    }

    public void removeItem(int position){
        availableplayersList.remove(position);
        availableplayersAdapter.notifyItemRemoved(position);
        availableplayersAdapter.notifyDataSetChanged();
    }

    /**
     * Method that shows QUIT button in action bar
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_quit_game, menu);
        return true;
    }


    /**
     * Method that removes players name from firebase database after player presses QUIT button
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_quit:
                mReference.child(usernameKey).removeValue();
                if(firstChild != null){
                    mDatabase.child("communication").child(firstChild).child("odustao").setValue(usernameKey);
                }

                finish();
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
        return true;
    }
    /**
     * Method that removes players name from firebase database after player presses back button
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mReference.child(usernameKey).removeValue();
        if(firstChild != null){
            mDatabase.child("communication").child(firstChild).child("odustao").setValue(usernameKey);
        }
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }

    /**
     * Method that removes players name from firebase database after player presses home button
     * First checks if new activity is been open because then this method can't be used
     * It doesn't know the difference between home button and new activity
     */
    @Override
    protected void onUserLeaveHint() {
        if(!isNewActiviy) {
            Log.d("onUserLeaveHint", "Home button pressed");
            super.onUserLeaveHint();
            if(firstChild != null){
                mDatabase.child("communication").child(firstChild).child("odustao").setValue(usernameKey);
            }
            mReference.child(usernameKey).removeValue();
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    public void showPopUpDoYouWantToPlay(View view, final String teammateName, final String username){
        final String userName = username;
        final View popupView = getLayoutInflater().inflate(R.layout.pop_up_do_you_want_to_play, null);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        popupWindow = new PopupWindow(popupView, (int)(width*.8) , (int)(height*.4));
        TextView TextViewtemmateName = (TextView) popupView.findViewById(R.id.textViewTeammateName);
        TextViewtemmateName.setText(teammateName);
        Button buttonNo = (Button) popupView.findViewById(R.id.buttonNo);
        Button buttonYes = (Button) popupView.findViewById(R.id.buttonYes);
        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase.child("communication").child(userName).child("ZeliIgrati").setValue("ne");
                popupWindow.dismiss();
            }
        });

        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDatabase.child("communication").child(userName).child("ZeliIgrati").setValue("da");
                popupWindow.dismiss();
            }
        });
        // If the PopupWindow should be focusable
        popupWindow.setFocusable(true);

        // If you need the PopupWindow to dismiss when when touched outside
       // popupWindow.setBackgroundDrawable(new ColorDrawable());

        // Using location, the PopupWindow will be displayed right under anchorView
        popupWindow.showAtLocation( view , Gravity.CENTER, 0,0);
    }
    public Toast toast;
    public void toastMessage(String textmessage) {

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast,
                (ViewGroup) findViewById(R.id.toast_layout));

        TextView text = (TextView) layout.findViewById(R.id.textViewToast);
        text.setText(textmessage);

        //int Y = 170;
        toast = new Toast(getApplicationContext());
        //toast.setGravity(Gravity.TOP, 0, Y);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, 3000);
    }

    public void checkIfPopUpIsOpen(){
        if(popupWindow.isShowing()){
            popupWindow.dismiss();
        }
    }
}

