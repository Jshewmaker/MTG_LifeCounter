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

public class Player_1_Fragment extends Fragment {
    private static  final String TAG = "Player_1_Fragment";

    private Button btn_increase;
    private Button btn_decrease;
    private TextView tv_LifeTotal;
    int currentTotal;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player_1_health, container, false);
        btn_increase = view.findViewById(R.id.player_1_increase);
        btn_decrease = view.findViewById(R.id.player_1_decrease);
        tv_LifeTotal = view.findViewById(R.id.life_total_p1);

        btn_increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentTotal = Integer.valueOf((tv_LifeTotal.getText().toString()));
                currentTotal += 1;
                tv_LifeTotal.setText(Integer.toString(currentTotal));
               // Toast.makeText(getActivity(), "Player 1 Increase",Toast.LENGTH_SHORT).show();
            }
        });

        btn_decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentTotal = Integer.valueOf((tv_LifeTotal.getText().toString()));
                currentTotal -= 1;
                tv_LifeTotal.setText(Integer.toString(currentTotal));
                //Toast.makeText(getActivity(), "Player 1 Decrease",Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}
