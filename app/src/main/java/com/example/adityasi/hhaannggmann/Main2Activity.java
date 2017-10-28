package com.example.adityasi.hhaannggmann;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

import android.text.InputType;
import android.text.method.KeyListener;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import android.widget.ImageView;
import android.app.AlertDialog.Builder;
import android.app.AlertDialog;
import android.content.DialogInterface;


public class Main2Activity extends AppCompatActivity {
    Random rand= new Random();
    int z= rand.nextInt(10);
    String wordarray[]= {"liver","assam","point","start","class","datum","cross","devil","learn","stump"};
    String word= wordarray[z];
    String HINT="HINT : ";
    StringBuilder answer= new StringBuilder("*****");
    Button enter;
    Button guess_bt;
    
    String edit2;
    TextView edit;

    char guess;

    private int count=10;
    TextView left;
    







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       /* hint = (TextView)findViewById(R.id.editText);
        hint.setText("chances left "+count);*/

        left = (TextView) findViewById(R.id.editText);
        left.setText("chances left "+count);
       /*msg = (EditText) findViewById(R.id.editText);
        msg.setText("Developer: ADITYA SINGH");*/




        switch (z)
        {
            case 0 : HINT=(" the largest gland of human body");
                break;
            case 1 : HINT=("  a state  famous for its tea production");
                break;
            case 2 : HINT=("  it has no dimensions");
                break;
            case 3 : HINT=("  a synonym of 'beginning'");
                break;
            case 4 : HINT=("  it contains 'objects' in OOP");
                break;
            case 5 : HINT=("  singular of data");
                break;
            case 6 : HINT=("  X");
                break;
            case 7 : HINT=("  name of Salman Khan in KICK");
                break;
            case 8 : HINT=("  _______ how to earn : English Saying");
                break;
            case 9 : HINT=(" i break that..when i bowl");
                break;

            default:  HINT=("");
                break;

        }



        guess_bt = (Button)findViewById(R.id.button3);
        guess_bt.setOnClickListener(new View.OnClickListener(){

                                       public void onClick(View v){

                                           //edit2 = (EditText) findViewById(R.id.editText2);

                                          // edit2.requestFocus();

                                           AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
                                           builder.setTitle("ENTER YOUR GUESS HERE");
                                           final EditText input = new EditText(Main2Activity.this);
                                           input.setInputType(InputType.TYPE_CLASS_TEXT);
                                           builder.setView(input);

                                           builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                               @Override
                                               public void onClick(DialogInterface dialog, int which) {
                                                   edit2 = input.getText().toString();

                                                   guess = edit2.toString().charAt(0);
                                                   count--;
                                                   left.setText("CHANCES LEFT : " + count);

                                                   if (count == 0) {
                                                       left.setText("YOU LOST!! YOU WILL BE HANGED!");
                                                       edit.setText(word);


                                                   }
                                                   else {
                                                       for (int i = 0; i < word.length(); i++) {


                                                           char a = word.charAt(i);

                                                           if (a == guess) {
                                                               answer.setCharAt(i, guess);
                                                           }


                                                       }

                                                       edit = (TextView) findViewById(R.id.edit);
                                                       edit.setText("      " + answer);
                                                       //  edit2.setText("");
                                                       if (answer.toString().trim().equals(word.trim())) {
                                                           left.setText("Congratulations!! YOU WON");
                                                           edit.setText(word);
                                                       }


                                                       edit.setKeyListener(null);
                                                       edit.setTag(left.getKeyListener());                                            //to set editable text uneditable
                                                       edit.setKeyListener(null);
                                                       edit.setKeyListener((KeyListener) edit.getTag());


                                                   }

                                               



                                               }
                                           });

                                           builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                               @Override
                                               public void onClick(DialogInterface dialog, int which) {
                                                   dialog.cancel();
                                               }
                                           });

                                           builder.show();

                                       }

        }
        );



      

}


        public void buttonClick(View v)
        {
            
            AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
            builder.setTitle("HINT for the word is ");
            final EditText hnt = new EditText(Main2Activity.this);
            hnt.setText(HINT);
            builder.setView(hnt);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();


        }

    public void clear(View v){
        //hint.setText("HINT :");
        edit.setText("  * * * * *");
        //msg.setText("Developer: ADITYA SINGH");
        count=10;
        left.setText("CHANCES LEFT : "+count);
       // edit2.setText("");
        recreate();
    }



    }

