package com.example.sara.mysimplemath.activity;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sara.mysimplemath.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

/**
 * After game is finished this activity is opened.
 * Here players can see results of the game
 */

public class ResultsOfGameActivity extends AppCompatActivity {
    String players_username;
    String this_players_score;
    String teammates_score;
    TextView view_this_player;
    TextView view_teammate;
    TextView win_or_lose;
    TextView viewPleaseWait;
    TextView your_score;
    TextView teammate_score;
    TextView your_time;
    TextView playersTime;
    TextView team_time;
    TextView temmatesTime;
    Button button_ok;
    String this_players_time;
    String teammates_time;
    String child;
    private DatabaseReference mDatabase;
    Boolean isCalled = false;

    ChildEventListener listener1;
    ChildEventListener listener2;
    ValueEventListener listener3;
    ValueEventListener listener4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_of_game);

        child = getIntent().getStringExtra("child");
        players_username = getIntent().getStringExtra("username");
        mDatabase = FirebaseDatabase.getInstance().getReference();

        listener1 = mDatabase.child("communication").child(child).child("score").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals(players_username)){
                    this_players_score= dataSnapshot.getValue().toString();
                }
                else {
                    teammates_score = dataSnapshot.getValue().toString();
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
        listener2 = mDatabase.child("communication").child(child).child("time").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals(players_username)){
                    this_players_time= dataSnapshot.getValue().toString();
                }
                else {
                    teammates_time = dataSnapshot.getValue().toString();
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

        listener3 = mDatabase.child("communication").child(child).child("score").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(this_players_score!=null && teammates_score!=null && this_players_time!=null && teammates_time!= null && !isCalled){
                    calculateScores();
                    isCalled = true;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        listener4 = mDatabase.child("communication").child(child).child("time").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(this_players_score!=null && teammates_score!=null && this_players_time!=null && teammates_time!= null && !isCalled){
                    calculateScores();
                    isCalled = true;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        win_or_lose =(TextView) findViewById(R.id.textView_win_or_lose);
        view_this_player =(TextView) findViewById(R.id.textView_this_players_points);
        view_teammate = (TextView) findViewById(R.id.textView_teammates_points);
        viewPleaseWait = (TextView) findViewById(R.id.textViewPleaseWait);
        your_score = (TextView) findViewById(R.id.textView_your_score);
        teammate_score = (TextView) findViewById(R.id.textView_teammates_score);
        button_ok = (Button) findViewById(R.id.button_resluts_ok);
        playersTime = (TextView)findViewById(R.id.textViewPlayerTime);
        your_time = (TextView)findViewById(R.id.textViewYourTime);
        team_time = (TextView) findViewById(R.id.textViewTeammatesTime);
        temmatesTime = (TextView)findViewById(R.id.textViewTeamTime);


       // this_players_score = getIntent().getStringExtra("this_players_score");
       // teammates_score = getIntent().getStringExtra("teammates_score");

    }

    public void calculateScores(){
        view_this_player.setText(this_players_score);
        view_teammate.setText(teammates_score);
        Integer total_score=Integer.parseInt(this_players_score) - Integer.parseInt(teammates_score);
        showResult();
        if(total_score > 0){
            win_or_lose.setText("YOU WON!");
        }
        else if(total_score<0){
            win_or_lose.setText("YOU LOSE");
        }
        else{
            your_time.setVisibility(View.VISIBLE);
            team_time.setVisibility(View.VISIBLE);
            playersTime.setVisibility(View.VISIBLE);
            playersTime.setText(this_players_time);
            temmatesTime.setVisibility(View.VISIBLE);
            temmatesTime.setText(teammates_time);
            String[] player_time = this_players_time.split(":");
            String[] teammate_time = teammates_time.split(":");
            if(!player_time[0].equals(teammate_time[0])){
                if(Integer.parseInt(player_time[0])< Integer.parseInt(teammate_time[0])){
                    win_or_lose.setText("YOU WON!");
                }
                else{
                    win_or_lose.setText("YOU LOSE");
                }
            }
            else if (!player_time[1].equals(teammate_time[1])){
                if(Integer.parseInt(player_time[1])< Integer.parseInt(teammate_time[1])){
                    win_or_lose.setText("YOU WON!");
                }
                else{
                    win_or_lose.setText("YOU LOSE");
                }
            }
            else{
                win_or_lose.setText("It's a tie!");
            }
        }

    }

    /**
     * This method is called when ok button is pressed
     * It closes this activity and opens AvailablePlayersActivity so player can choose new teammate
     * @param view
     */
    public void exit(View view){
        mDatabase.removeEventListener(listener1);
        mDatabase.removeEventListener(listener2);
        mDatabase.removeEventListener(listener3);
        mDatabase.removeEventListener(listener4);
        if(child.equals(players_username)){
            PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("used_username", players_username).commit();
            mDatabase.child("communication").child(players_username).removeValue();
        }
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void showResult(){
        win_or_lose.setVisibility(View.VISIBLE);
        view_this_player.setVisibility(View.VISIBLE);
        view_teammate.setVisibility(View.VISIBLE);
        viewPleaseWait.setVisibility(View.VISIBLE);
        your_score.setVisibility(View.VISIBLE);
        teammate_score.setVisibility(View.VISIBLE);
        button_ok.setVisibility(View.VISIBLE);
        button_ok.setClickable(true);

        viewPleaseWait.setVisibility(View.GONE);
    }
}
