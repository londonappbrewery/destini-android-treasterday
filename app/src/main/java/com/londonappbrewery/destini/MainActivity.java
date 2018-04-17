package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView storyTextView;
    private Button buttonTop;
    private Button buttonBottom;
    private int mStoryIndex=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        storyTextView = findViewById(R.id.storyTextView);
        buttonTop = findViewById(R.id.buttonTop);
        buttonBottom = findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        buttonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String current_text = (String) storyTextView.getText();

                if (mStoryIndex == 1) {  //currently on 1
                    storyTextView.setText(R.string.T3_Story);
                    buttonTop.setText(R.string.T3_Ans1);
                    buttonBottom.setText(R.string.T3_Ans2);
                } else { //not on first screen anymore

                    if (current_text == getText(R.string.T2_Story)) {
                        storyTextView.setText(R.string.T3_Story);
                        buttonTop.setText(R.string.T3_Ans1);
                        buttonBottom.setText(R.string.T3_Ans2);
                    } else {
                        storyTextView.setText(R.string.T6_End);
                        buttonTop.setVisibility(View.GONE);
                        buttonBottom.setVisibility(View.GONE);
                    }
                }
                mStoryIndex++;
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        buttonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String current_text = (String) storyTextView.getText();

                if (mStoryIndex == 1) {  //currently on 1
                    storyTextView.setText(R.string.T2_Story);
                    buttonTop.setText(R.string.T2_Ans1);
                    buttonBottom.setText(R.string.T2_Ans2);
                } else {
                    if (current_text ==  getText(R.string.T3_Story)) {
                        storyTextView.setText(R.string.T5_End);
                    } else {
                        storyTextView.setText(R.string.T4_End);
                    }
                    buttonTop.setVisibility(View.GONE);
                    buttonBottom.setVisibility(View.GONE);
                }
                mStoryIndex++;
            }
        });

    }



}
