package com.example.finalhw;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class Add_Problem_Screen extends AppCompatActivity implements View.OnClickListener {
    EditText et_add_name, et_add_satatus, et_add_desc,
            et_add_date, et_add_type;
    Button btn_add_save;
    String uid = null;


    DatabaseReference problemRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_problem_screen);


        et_add_desc = findViewById(R.id.et_add_desc);
        et_add_name = findViewById(R.id.et_add_name);
        et_add_satatus = findViewById(R.id.et_add_satatus);
        et_add_type = findViewById(R.id.et_add_type);
        et_add_date = findViewById(R.id.et_add_date);

        btn_add_save = findViewById(R.id.btn_add_save);
        btn_add_save.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == btn_add_save) {
            Log.d("tag", "before uid");

            String date = null;
            String status = null;
            String type = null;
            String description = null;
            try {
                date = et_add_date.getText().toString();
                status = et_add_satatus.getText().toString();
                type = et_add_type.getText().toString();
                description = et_add_desc.getText().toString();
                String name = et_add_name.getText().toString();
                Log.d("tag", "after: "+uid+"\t"+type);

            } catch (Exception e) {
                e.printStackTrace();
                Log.d("tag", "problem");
            }

            //    public Problem(String description, String type, String prbm_id, String usr_id, String date, boolean status) {
            Problem p = new Problem(description, type, "",uid, date, Boolean.parseBoolean(status));

            problemRef = FirebaseDatabase.getInstance().getReference("Problems").push();
            p.setPrbm_id(problemRef.getKey());
            problemRef.setValue(p);

        }
    }
}