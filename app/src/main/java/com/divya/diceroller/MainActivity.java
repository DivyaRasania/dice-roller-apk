package com.divya.diceroller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int diceRolledCount = 0;
    private int diceRoll = 0;
    private int lastRoll = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rollButton = findViewById(R.id.rollButton);

        rollDice();
    }

    public void roll(View view) {
        diceRolledCount++;
        rollDice();
        updates();
        lastRoll = diceRoll;
    }

    private void rollDice() {
        Dice dice = new Dice();
        diceRoll = dice.roll(6);

        ImageView diceImage = findViewById(R.id.dice);

        switch (diceRoll) {
            case 1:
                diceImage.setBackgroundResource(R.drawable.dice_1);
                break;
            case 2:
                diceImage.setBackgroundResource(R.drawable.dice_2);
                break;
            case 3:
                diceImage.setBackgroundResource(R.drawable.dice_3);
                break;
            case 4:
                diceImage.setBackgroundResource(R.drawable.dice_4);
                break;
            case 5:
                diceImage.setBackgroundResource(R.drawable.dice_5);
                break;
            default:
                diceImage.setBackgroundResource(R.drawable.dice_6);
                break;
        }

        diceImage.setContentDescription(Integer.toString(diceRoll));
    }

    private void updates() {
        TextView times = findViewById(R.id.dice_rolled_times);
        times.setText("Dice rolled " + diceRolledCount + " times.");

        TextView to = findViewById(R.id.dice_rolled_to);
        to.setText("Dice rolled to: " + diceRoll);

        TextView last = findViewById(R.id.last_roll);
        last.setText("Last roll: " + lastRoll);
    }
}