package com.example.sara.mysimplemath.activity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sara.mysimplemath.R;
import com.example.sara.mysimplemath.fragment.DerivationsFragment;
import com.example.sara.mysimplemath.fragment.EquationsFragment;
import com.example.sara.mysimplemath.fragment.FunctionsFragment;
import com.example.sara.mysimplemath.fragment.GameFragment;
import com.example.sara.mysimplemath.fragment.HomeFragment;
import com.example.sara.mysimplemath.fragment.IntegralsFragment;
import com.example.sara.mysimplemath.fragment.LessonsFragment;
import com.example.sara.mysimplemath.fragment.SettingsFragment;
import com.example.sara.mysimplemath.other.AvailablePlayers;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 *  Main activity
 */

public class MainActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener , GameFragment.OnFragmentInteractionListener,
        LessonsFragment.OnFragmentInteractionListener, FunctionsFragment.OnFragmentInteractionListener, DerivationsFragment.OnFragmentInteractionListener,
        EquationsFragment.OnFragmentInteractionListener, IntegralsFragment.OnFragmentInteractionListener, SettingsFragment.OnFragmentInteractionListener{

    private DatabaseReference mDatabase;

    public String playerName;
    public Boolean isUnique=true;
    public GameFragment gameFrag;
    public SettingsFragment settingsFrag;
    public String textItema = null;
    public DerivationsFragment derivationsFrag;

    private NavigationView navigationView;
    private DrawerLayout drawer;
    private View navHeader;
    private Toolbar toolbar;

    // index to identify current nav menu item
    public static int navItemIndex = 0;

    // tags used to attach the fragments
    private static final String TAG_HOME = "home";
    private static final String TAG_LESSONS = "lessons";
    private static final String TAG_GAME = "game";
    private static final String TAG_DERIVATIONS = "derivations";
    private static final String TAG_INTEGRALS = "integrals";
    private static final String TAG_FUNCTIONS = "functions";
    private static final String TAG_EQUATIONS = "equations";
    private static final String TAG_SETTINGS= "settings";
    public static String CURRENT_TAG = TAG_HOME;

    // toolbar titles respected to selected nav menu item
    private String[] activityTitles;

    // flag to load home fragment when user presses back key
    private boolean shouldLoadHomeFragOnBackPress = true;
    private Handler mHandler;
    private List<AvailablePlayers> usedUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mHandler = new Handler();

        usedUsername = new ArrayList<AvailablePlayers>();

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("players").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                AvailablePlayers current_username = dataSnapshot.getValue(AvailablePlayers.class);
                usedUsername.add(current_username);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                AvailablePlayers current_username = dataSnapshot.getValue(AvailablePlayers.class);
                String username;
                for(AvailablePlayers el: usedUsername){
                    username = el.getUsername();
                    if(current_username.getUsername().equals(username)){
                        usedUsername.remove(el);
                        break;
                    }
                }
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);

        // Navigation view header
        navHeader = navigationView.getHeaderView(0);


        // load toolbar titles from string resources
        activityTitles = getResources().getStringArray(R.array.nav_item_activity_titles);

        // initializing navigation menu
        setUpNavigationView();

        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOME;
            loadHomeFragment();
        }
    }

    /***
     * Returns respected fragment that user
     * selected from navigation menu
     */
    private void loadHomeFragment() {
        // selecting appropriate nav menu item
        selectNavMenu();

        // set toolbar title
        setToolbarTitle();

        // if user select the current navigation menu again, don't do anything
        // just close the navigation drawer
        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            drawer.closeDrawers();
            return;
        }
        // Sometimes, when fragment has huge data, screen seems hanging
        // when switching between navigation menus
        // So using runnable, the fragment is loaded with cross fade effect
        // This effect can be seen in GMail app
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };
        // If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }
        //Closing drawer on item click
        drawer.closeDrawers();

        // refresh toolbar menu
        invalidateOptionsMenu();
    }

    private Fragment getHomeFragment() {
        switch (navItemIndex) {
            case 0:
                // home
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
            case 1:
                // lessons
                LessonsFragment lessonsFragment = new LessonsFragment();
                return lessonsFragment;
            case 2:
                // game fragment
                GameFragment gameFragment = new GameFragment();
                return gameFragment;
            case 3:
                // equations fragment
                EquationsFragment equationsFragment = new EquationsFragment();
                return equationsFragment;
            case 4:
                // functions fragment
                FunctionsFragment functionsFragment = new FunctionsFragment();
                return functionsFragment;
            case 5:
                // derivations fragment
                DerivationsFragment derivationsFragment = new DerivationsFragment();
                return derivationsFragment;
            case 6:
                // integrals fragment
                IntegralsFragment integralsFragment = new IntegralsFragment();
                return integralsFragment;
            case 7:
                // settings fragment
                SettingsFragment settingsFragment = new SettingsFragment();
                return settingsFragment;
            default:
                return new HomeFragment();
        }
    }
    private void setToolbarTitle() {
        getSupportActionBar().setTitle(activityTitles[navItemIndex]);
    }
    private void selectNavMenu() {
        navigationView.getMenu().getItem(navItemIndex).setChecked(true);
    }
    private void setUpNavigationView() {
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.menu_home:
                        navItemIndex = 0;
                        CURRENT_TAG = TAG_HOME;
                        break;
                    case R.id.menu_lessons:
                        navItemIndex = 1;
                        CURRENT_TAG = TAG_LESSONS;
                        break;
                    case R.id.menu_item_game:
                        navItemIndex = 2;
                        CURRENT_TAG = TAG_GAME;
                        break;
                    case R.id.menu_eqations:
                        navItemIndex = 3;
                        CURRENT_TAG = TAG_EQUATIONS;
                        break;
                    case R.id.menu_functions:
                        navItemIndex = 4;
                        CURRENT_TAG = TAG_FUNCTIONS;
                        break;
                    case R.id.menu_derivations:
                        navItemIndex = 5;
                        CURRENT_TAG = TAG_DERIVATIONS;
                        break;
                    case R.id.menu_integrals:
                        navItemIndex = 6;
                        CURRENT_TAG = TAG_INTEGRALS;
                        break;
                    case R.id.menu_item_settings:
                        navItemIndex = 7;
                        CURRENT_TAG = TAG_SETTINGS;
                        break;
                    default:
                        navItemIndex = 0;
                }
                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                loadHomeFragment();

                return true;
            }
        });
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawer.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawers();
            return;
        }
        // This code loads home fragment when back key is pressed
        // when user is in other fragment than home
        if (shouldLoadHomeFragOnBackPress) {
            // checking if user is on other navigation menu
            // rather than home
            if (navItemIndex != 0) {
                navItemIndex = 0;
                CURRENT_TAG = TAG_HOME;
                loadHomeFragment();
                return;
            }
        }
        super.onBackPressed();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.menu_settings_settings) {
            navItemIndex = 7;
            CURRENT_TAG = TAG_SETTINGS;
            loadHomeFragment();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {}

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    /**
     * Method that is called when you press button Game in home fragment
     * Opens fragment game
     */
    public void openGame(View view){
        navItemIndex = 2;
        CURRENT_TAG = TAG_GAME;
        loadHomeFragment();
        /*Fragment fragment = new GameFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG);

        //klikom na gumbic back se iz game vracamo nazad u home(bez toga bi se izaslo iz aplikacije)
        fragmentTransaction.addToBackStack(CURRENT_TAG);
        fragmentTransaction.commitAllowingStateLoss();*/
    }

    /**
     * Method that is called when you press button Lessons in home fragment
     * Opens fragment lessons
     */
    public void openLessons(View view){
        navItemIndex = 1;
        CURRENT_TAG = TAG_LESSONS;
        loadHomeFragment();
    }

    /**
     * Method that is called when you press button Derivations in lessons fragment
     * Opens derivations fragment
     * */
    public void openDerivations(View view){
        navItemIndex = 5;
        CURRENT_TAG = TAG_DERIVATIONS;
        loadHomeFragment();
    }

    /**
     * Method that is called when you press button Integrals in lessons fragment
     * Opens integrals fragment
     * */
    public void openIntegrals(View view){
        navItemIndex = 6;
        CURRENT_TAG = TAG_INTEGRALS;
        loadHomeFragment();
    }

    /**
     * Method that is called when you press button graphs in lessons fragment
     * Opens graphs fragment
     * */
    public void openFunctions(View view){
        navItemIndex = 4;
        CURRENT_TAG = TAG_FUNCTIONS;
        loadHomeFragment();
    }

    /**
     * Method that is called when you press button Equations in lessons fragment
     * Opens derivations fragment
     * */
    public void openEquations(View view){
        navItemIndex = 3;
        CURRENT_TAG = TAG_EQUATIONS;
        loadHomeFragment();
    }

    /**
     * Method that is called when you press button Play in game fragement
     * Goes to new activity where you can choose teammate
     * */
    public void GoChooseTeammate(View view){

        gameFrag = (GameFragment) getSupportFragmentManager().findFragmentById(R.id.frame);
        playerName = gameFrag.edit_text_player.getText().toString();
        isUnique = true;

        if(playerName.equals("")){
            Toast.makeText(this,"Username can not be empty!", Toast.LENGTH_LONG).show();
        }
        else{
            //check if username is used in game
            String user = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("used_username", "no_username");
            if(user.equals(playerName)){
                Toast.makeText(this,"You can not use same username twice. Please choose another username.", Toast.LENGTH_LONG).show();
            }
            else {
                isUsernameExists(playerName);
                if (isUnique) {
                    writeNewUsername(playerName, playerName);
                    Intent intent = new Intent(this, AvailablePlayersActivity.class);
                    intent.putExtra("username", playerName);
                    startActivity(intent);
                } else
                    Toast.makeText(this, "This username already exists! Choose another one.", Toast.LENGTH_LONG).show();
            }
        }
    }

    /**
     * Method that is called when you press button Change in settings fragement
     * Sound of a button can be enabled or disabled
     * */
    public void changeClickable(View view){
        settingsFrag = (SettingsFragment) getSupportFragmentManager().findFragmentById(R.id.frame);
        textItema = String.valueOf(settingsFrag.spin_sound.getSelectedItem());
        AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        Button btn = (Button) findViewById(R.id.button_change);
        if(textItema.equals("Disable")){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                audioManager.adjustStreamVolume(AudioManager.STREAM_SYSTEM, AudioManager.ADJUST_MUTE, 0);
            } else {
                audioManager.setStreamMute(AudioManager.STREAM_SYSTEM, true);
            }
        }
        else if(textItema.equals("Enable")){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                audioManager.adjustStreamVolume(AudioManager.STREAM_SYSTEM, AudioManager.ADJUST_UNMUTE, 0);
            } else {
                audioManager.setStreamMute(AudioManager.STREAM_SYSTEM, false);
            }
        }
    }

    /**
     * Method that sets username value into Firebase database
     * @param userId it will also be players username
     * @param username players username
     */
    public void writeNewUsername(String userId, String username){
        AvailablePlayers player = new AvailablePlayers(username);
        mDatabase.child("players").child(userId).setValue(player);
    }

    /**
     * This method checks if username, that players entered, is unique
     * @param enteredUsername entered username
     */
    public void isUsernameExists(final String enteredUsername) {
        for(AvailablePlayers el : usedUsername){
            String existingUsername = el.getUsername();
            if(existingUsername.equals(enteredUsername)){
                isUnique = false;
            }
        }
    }
}

