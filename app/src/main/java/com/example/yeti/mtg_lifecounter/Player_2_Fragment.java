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

public class Player_2_Fragment extends Fragment {
    private static  final String TAG = "Player_2_Fragment";

    private Button btn_increase;
    private Button btn_decrease;
    private TextView tv_LifeTotal;
    int currentTotal;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player_2_health, container, false);
        btn_increase = view.findViewById(R.id.player_2_increase);
        btn_decrease = view.findViewById(R.id.player_2_decrease);
        tv_LifeTotal = view.findViewById(R.id.life_total);


        btn_increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentTotal = ((MainActivity)getActivity()).player2_life;
                currentTotal += 1;
                tv_LifeTotal.setText(Integer.toString(currentTotal));
                ((MainActivity)getActivity()).player2_life = currentTotal;
            }
        });

        btn_decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentTotal = ((MainActivity)getActivity()).player2_life;
                currentTotal -= 1;
                tv_LifeTotal.setText(Integer.toString(currentTotal));
                ((MainActivity)getActivity()).player2_life = currentTotal;
            }
        });


        return view;
    }
}
