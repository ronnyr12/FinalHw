package com.example.finalhw;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import android.os.Bundle;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class All_Problems_Screen extends AppCompatActivity {
    ArrayList<Problem> problems_list;
    ListView lv_all_problems;
    ProblemAdpter adpter;
    DatabaseReference problemRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_problems_screen);

        problemRef = FirebaseDatabase.getInstance().getReference("Problems");

        this.retriveProblemsDB();
        lv_all_problems = findViewById(R.id.lv_all_problems);
    }

    private void retriveProblemsDB() {
        problemRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                problems_list = new ArrayList<Problem>();
                for (DataSnapshot data : snapshot.getChildren()) {
                    Problem p = data.getValue(Problem.class);
                    problems_list.add(p);
                }
                adpter = new ProblemAdpter(All_Problems_Screen.this, 0, 0,
                        problems_list);
                lv_all_problems.setAdapter(adpter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}