package com.example.finalhw;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycler_actionlist;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference problemRef;
    List<Integer> images;
    List<String> titles;
    Adapter_RecyclerView adapter;
    Button brn_add_main, btn_all_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide(); //<< this

        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                String deviceToken = task.getResult();
                Log.d("tag", deviceToken);
            }
        });
        recycler_actionlist = findViewById(R.id.recycler_actionlist);

        titles = new ArrayList<>();
        titles.add(Main_ActionsList_Enum.Open_error);
        titles.add(Main_ActionsList_Enum.Map);
        titles.add(Main_ActionsList_Enum.Fix_Team);
        titles.add(Main_ActionsList_Enum.Notify);
        titles.add(Main_ActionsList_Enum.Info);
        titles.add(Main_ActionsList_Enum.Peoples);
        titles.add(Main_ActionsList_Enum.Message);
        titles.add(Main_ActionsList_Enum.Settings);


        images = new ArrayList<>();
        images.add(R.drawable.ic_baseline_report_problem_24);
        images.add(R.drawable.ic_baseline_map_24);
        images.add(R.drawable.ic_baseline_engineering_24);
        images.add(R.drawable.ic_baseline_notification_important_24);
        images.add(R.drawable.ic_baseline_question_mark_24);
        images.add(R.drawable.ic_baseline_groups_24);
        images.add(R.drawable.ic_baseline_forum_24);
        images.add(R.drawable.ic_baseline_settings_24);

        adapter = new Adapter_RecyclerView(titles, images,this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),
                2, GridLayoutManager.VERTICAL, false);
        recycler_actionlist.setLayoutManager(gridLayoutManager);
        recycler_actionlist.setAdapter(adapter);


        firebaseDatabase = FirebaseDatabase.getInstance();




    }


}