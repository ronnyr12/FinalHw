package com.example.finalhw;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class LoginScreen extends AppCompatActivity implements View.OnClickListener {
    FirebaseAuth firebaseAuth;

    Button btn_submit_login;
    EditText etEmail_login, etPass_login;
    TextView tv_forgot_pass;
    ConstraintLayout layout_login;

    Dialog d;
    EditText et_email_dialog;   //dialog edittext
    Button btn_reset_dialog, btn_back_dialog;   //dialog buttons

    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        getSupportActionBar().hide(); //<< this removes the toolbar from the screen
        initElements();
        
    }

    private void initElements() {
        progressDialog = new ProgressDialog(this);
        layout_login = findViewById(R.id.layout_login);
        etEmail_login = findViewById(R.id.etEmail_login);
        etPass_login = findViewById(R.id.etPass_login);
        tv_forgot_pass = findViewById(R.id.tv_forgot_pass);
        tv_forgot_pass.setOnClickListener(this);
        btn_submit_login = findViewById(R.id.btn_submit_login);
        btn_submit_login.setOnClickListener(this);

        firebaseAuth = FirebaseAuth.getInstance();

    }


    @Override
    public void onClick(View view) {
        if(view == btn_submit_login){
            String email = etEmail_login.getText().toString();
            String pass = etPass_login.getText().toString();
            if(!checkInput(email, pass)){
                //todo - add login option
                loginUser("ronny761@gmail.com", "12345678");
                //startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        }
        if(view == tv_forgot_pass){
            createforgotPassDialog();
        }

        if(view == btn_back_dialog){
            d.dismiss();
        }

        if(view == btn_reset_dialog){
            progressDialog.setMessage("Please Wait...");
            progressDialog.show();

            String email = et_email_dialog.getText().toString();
            if(email.trim().length() != 0){
                firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(
                        new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            progressDialog.dismiss();
                            d.dismiss();
                            mySnackBar("Email Sent!");
                        }else{
                            progressDialog.dismiss();
                            d.dismiss();
                            mySnackBar(task.getException().getMessage());
                        }
                    }
                });

            }else{
                mySnackBar("please enter the email.");
            }
        }
    }

    /**
     * login user
     * email and pass required for signIn option
     * @param email
     * @param pass
     */
    public  void loginUser(String email, String pass)
    {
        progressDialog.setMessage("Login Please Wait...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email , pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {

                        if(task.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(),
                                    "auth_success",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),
                                    MainActivity.class));

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),
                                    "auth_failed",Toast.LENGTH_SHORT).show();

                        }
                        progressDialog.dismiss();

                    }
                });

    }

    /**
     * register user to firebase auth
     * @param email
     * @param pass
     */
    private void registerUser_firebase(String email, String pass) {
        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email, pass).
                addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //todo - add what happens if all ok
                        } else {
                            //
                        }
                    }
                });
    }//endOf_registerUser_firebase
    private void createforgotPassDialog() {
        d = new Dialog(this);
        d.setContentView(R.layout.reset_password_dialog);
        d.setTitle("Reset Password");
        d.setCancelable(true);
        et_email_dialog = d.findViewById(R.id.et_email_dialog);
        btn_reset_dialog = d.findViewById(R.id.btn_reset_dialog);
        btn_reset_dialog.setOnClickListener(this);
        btn_back_dialog = d.findViewById(R.id.btn_back_dialog);
        btn_back_dialog.setOnClickListener(this);
        d.show();
    }

    /**
     * validatesthe given email and password
     * @param email
     * @param pass
     * @return false if all ok
     */
    private boolean checkInput(String email, String pass) {
        boolean error = false;
        String message = "Error:\t";
        if(email.trim().length() == 0){
            error = true;
            message += "Enter your registered email.\t";
        }
        if(pass.trim().length() == 0){
            error = true;
            message += "Missing required password.\t";
        }
        if(error)
            mySnackBar(message);
        return error;
    }//endOf_checkInput

    /**
     * creates a snackbar to prompt the message
     * @param message
     */
    public void mySnackBar(String message){
        Snackbar snackbar = Snackbar
                .make(layout_login, message, Snackbar.LENGTH_LONG);
        snackbar.show();
    }
}
