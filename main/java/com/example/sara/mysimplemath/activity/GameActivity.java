package com.example.sara.mysimplemath.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sara.mysimplemath.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    String child;
    String temmates_username;
    String players_username;
    private DatabaseReference mDatabase;
    TextView textViewCounter;
    TextView textViewQuestion;
    RadioGroup radioGroupAnswers;
    Button buttonAnswer;
    Button buttonFinish;
    public Map<String,Object> questionsMap = new HashMap<>();
    Map<String,Object> mapOfquestionThatWillBeAsked = new HashMap<>();
    List<Integer> listOfNumbers = new ArrayList<>();
    public Map<String, String> mapOfAnswers = new HashMap<>();
    Object currentKey;
    Map<String, String> currentAnswers = new HashMap<>();
    List<Integer> listofRandomNumbers = new ArrayList<>();
    Integer suma = 0;
    long startTime = 0;
    Runnable timerRunnable;
    //runs without a timer by reposting this handler at the end of the runnable
    final Handler timerHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        temmates_username = getIntent().getStringExtra("teammates_username");
        players_username = getIntent().getStringExtra("username");
        child = getIntent().getStringExtra("child");

        mDatabase = FirebaseDatabase.getInstance().getReference();

        textViewCounter = (TextView) findViewById(R.id.textView_Counter);
        textViewQuestion = (TextView) findViewById(R.id.textView_Question);
        buttonAnswer = (Button) findViewById(R.id.buttonAnswer);
        buttonFinish = (Button) findViewById(R.id.buttonFinish);
        radioGroupAnswers = (RadioGroup) findViewById(R.id.RadioGroupAnswers);

        //when button answer is clicked
        buttonAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = radioGroupAnswers.getCheckedRadioButtonId();
                //clears any radio button that has been selected before new question comes
                radioGroupAnswers.clearCheck();

                //if no radio button has been selected
                if(id<0){
                    Toast.makeText(GameActivity.this,"You have to answer something!", Toast.LENGTH_LONG).show();
                }

                //if radio button is selected then button that players choose has correct answer
                else{
                    RadioButton checkedRadioButton = (RadioButton) findViewById(id);

                    String radioAnswer = checkedRadioButton.getText().toString();

                    for(int i= 0; i < currentAnswers.size(); i++){
                        String key = currentAnswers.keySet().toArray()[i].toString();
                        String text = currentAnswers.get(key);
                        if(radioAnswer.equals(text)){
                            if(key.equals("tocno")){
                                suma +=10;
                            }
                        }
                    }
                    if(mapOfquestionThatWillBeAsked.size()!=0) {
                        generateQuestion();
                        mapOfquestionThatWillBeAsked.remove(currentKey);
                    }
                }

            }
        });

        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //timer is has been stoped
                timerHandler.removeCallbacks(timerRunnable);
                String time = textViewCounter.getText().toString();
                int id = radioGroupAnswers.getCheckedRadioButtonId();
                if(id<0){
                    Toast.makeText(GameActivity.this,"You have to answer something!", Toast.LENGTH_LONG).show();
                }
                else {
                    RadioButton checkedRadioButton = (RadioButton) findViewById(id);

                    String radioAnswer = checkedRadioButton.getText().toString();

                    for (int i = 0; i < currentAnswers.size(); i++) {
                        String key = currentAnswers.keySet().toArray()[i].toString();
                        String text = currentAnswers.get(key);
                        if (radioAnswer.equals(text)) {
                            if (key.equals("tocno")) {
                                suma += 10;
                            }
                        }
                    }

                    //adds score and time into database and goes to Results activity
                    mDatabase.child("communication").child(child).child("score").child(players_username).setValue(suma);
                    mDatabase.child("communication").child(child).child("time").child(players_username).setValue(time);
                    Intent intent = new Intent(GameActivity.this, ResultsOfGameActivity.class);
                    intent.putExtra("child", child);
                    intent.putExtra("username", players_username);
                    startActivity(intent);
                    finish();
                }
            }
        });

        //in dataChange all questions that are in database are added to questionMap
        mDatabase.child("questions").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> map = dataSnapshot.getChildren();
                for (DataSnapshot el : map) {
                    questionsMap.put(el.getKey(), (Object)el.getValue());
                }
                createGame();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        questions();

    }

    private void createGame(){
        findThreeRandomNumbers();
        createQuestionsList();
        if(mapOfquestionThatWillBeAsked.size()!=0){
            generateQuestion();
            mapOfquestionThatWillBeAsked.remove(currentKey);
        }
        createCounter();
        startCounter();
    }

    private void startCounter() {
        startTime = System.currentTimeMillis();
        timerHandler.postDelayed(timerRunnable, 0);
    }

    private void createCounter() {
        timerRunnable = new Runnable() {

            @Override
            public void run() {
                long millis = System.currentTimeMillis() - startTime;
                int seconds = (int) (millis / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;

                textViewCounter.setText(String.format("%d:%02d", minutes, seconds));

                timerHandler.postDelayed(this, 500);
            }
        };
    }

    private void findThreeRandomNumbers() {
        Random random = new Random();
        int num;
        int br=0;
        int size = questionsMap.size();
        while(br<3){
            num = random.nextInt(size);
            if(!listOfNumbers.contains(num)){
                listOfNumbers.add(num);
                br++;
            }
        }
    }
    private void threeRandomNumbersforAnswers(){
        Random random = new Random();
        listofRandomNumbers = new ArrayList<>();
        int num;
        int br=0;
        while(br<3){
            num = random.nextInt(3);
            if(!listofRandomNumbers.contains(num)){
                listofRandomNumbers.add(num);
                br++;
            }
        }
    }
    private void createQuestionsList() {
        for(Integer el: listOfNumbers){
            String firstKey = questionsMap.keySet().toArray()[el].toString();
            Object valueForFirstKey = questionsMap.get(firstKey);
            mapOfquestionThatWillBeAsked.put(firstKey, valueForFirstKey);
        }
    }

    private void generateQuestion() {
        String firstKey = mapOfquestionThatWillBeAsked.keySet().toArray()[0].toString();
        currentKey = firstKey;
        Map<String, String> valueForFirstKey = (Map<String, String>) mapOfquestionThatWillBeAsked.get(firstKey);
        currentAnswers = valueForFirstKey;
        textViewQuestion.setText(firstKey);
        threeRandomNumbersforAnswers();
        for(int i= 0; i < radioGroupAnswers.getChildCount(); i++){
            int m = listofRandomNumbers.get(i);
            String key = valueForFirstKey.keySet().toArray()[m].toString();
            String text = valueForFirstKey.get(key);
            ((RadioButton) radioGroupAnswers.getChildAt(i)).setText(text);
        }

        if(mapOfquestionThatWillBeAsked.size()==1){
            buttonAnswer.setVisibility(View.GONE);
            buttonAnswer.setClickable(false);
            buttonFinish.setVisibility(View.VISIBLE);
            buttonFinish.setClickable(true);
        }
    }

  public void questions(){
      // u ovom trecem childu treba pisati "tocno" za tocan odgovor!!
        mDatabase.child("questions").child("Solve 2^x = -4 ").child("tocno").setValue("no solution");
        mDatabase.child("questions").child("Solve 2^x = -4 ").child("krivo1").setValue("x = -2");
        mDatabase.child("questions").child("Solve 2^x = -4 ").child("krivo2").setValue("x = 2");
        mDatabase.child("questions").child("Solve x^2 -7x = 0").child("krivo1").setValue("x = 3,6");
        mDatabase.child("questions").child("Solve x^2 -7x = 0").child("tocno").setValue("x = 0, 7");
        mDatabase.child("questions").child("Solve x^2 -7x = 0").child("krivo2").setValue("x = 0, -7");
        mDatabase.child("questions").child("Solve x^3 - 7x^2 + 4x + 12 = 0").child("krivo1").setValue("x = -1,-2, 6");
        mDatabase.child("questions").child("Solve x^3 - 7x^2 + 4x + 12 = 0").child("krivo2").setValue("x = -1, 2,-6");
        mDatabase.child("questions").child("Solve x^3 - 7x^2 + 4x + 12 = 0").child("tocno").setValue("x = -1, 2, 6");
        mDatabase.child("questions").child("Solve log(x) + log(x-1) = log(3x+12)").child("krivo1").setValue("x = -2, 6");
        mDatabase.child("questions").child("Solve log(x) + log(x-1) = log(3x+12)").child("krivo2").setValue("x = 2,6");
        mDatabase.child("questions").child("Solve log(x) + log(x-1) = log(3x+12)").child("tocno").setValue("x = 6");
    }
}

