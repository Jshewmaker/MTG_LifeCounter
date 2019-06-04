package com.example.yeti.mtg_lifecounter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

public class DiceFragment extends Fragment {

    ImageButton b_min_subtraction;
    ImageButton b_min_addition;
    TextView tv_min_Value;
    ImageButton b_max_subtraction;
    ImageButton b_max_addition;
    TextView tv_max_Value;
    int lower_dice_value, upper_dice_value;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dice_activity, container, false);

        b_min_subtraction = view.findViewById(R.id.min_subtraction_button);
        b_min_addition = view.findViewById(R.id.min_addition_button);
        tv_min_Value = view.findViewById(R.id.min_dice);
        b_max_subtraction = view.findViewById(R.id.max_subtraction_button);
        b_max_addition = view.findViewById(R.id.max_addition_button);
        tv_max_Value = view.findViewById(R.id.max_dice);

        b_min_subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lower_dice_value = Integer.valueOf((tv_min_Value.getText().toString()));
                lower_dice_value -= 1;
                tv_min_Value.setText(Integer.toString(lower_dice_value));
                // Toast.makeText(getActivity(), "Player 1 Increase",Toast.LENGTH_SHORT).show();
            }
        });

        b_min_addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lower_dice_value = Integer.valueOf((tv_min_Value.getText().toString()));
                lower_dice_value += 1;
                tv_min_Value.setText(Integer.toString(lower_dice_value));
                // Toast.makeText(getActivity(), "Player 1 Increase",Toast.LENGTH_SHORT).show();
            }
        });

        b_max_subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                upper_dice_value = Integer.valueOf((tv_max_Value.getText().toString()));
                upper_dice_value -= 1;
                tv_max_Value.setText(Integer.toString(upper_dice_value));
                // Toast.makeText(getActivity(), "Player 1 Increase",Toast.LENGTH_SHORT).show();
            }
        });

        b_max_addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                upper_dice_value = Integer.valueOf((tv_max_Value.getText().toString()));
                upper_dice_value += 1;
                tv_max_Value.setText(Integer.toString(upper_dice_value));
                // Toast.makeText(getActivity(), "Player 1 Increase",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
