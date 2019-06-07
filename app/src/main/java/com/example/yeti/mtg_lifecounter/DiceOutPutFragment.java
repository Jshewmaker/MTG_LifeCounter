package com.example.yeti.mtg_lifecounter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class DiceOutPutFragment extends Fragment {

    Button b_roll;
    TextView diceOutput;
    int lower_dice_value, upper_dice_value, random;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dice_output_fragment, container, false);

        diceOutput = view.findViewById(R.id.diceNumberOutput);
        b_roll = view.findViewById(R.id.roll_button);


        b_roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lower_dice_value = ((MainActivity)getActivity()).diceLower;
                upper_dice_value = ((MainActivity)getActivity()).diceUpper;
                final int random = new Random().nextInt((upper_dice_value - lower_dice_value) + 1) + lower_dice_value;
                diceOutput.setText(Integer.toString(random));
            }
        });





        return view;
    }
}
