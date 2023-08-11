package com.Moviecreedfull.moviecreedfull1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import android.content.Context;
import android.content.SharedPreferences;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private Button registerButton, loginButton;
    private TextView statusTextView;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        // Change the title of the ActionBar/Toolbar
        getSupportActionBar().setTitle("Moviecreed1.0");



        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        registerButton = findViewById(R.id.registerButton);
        loginButton = findViewById(R.id.loginButton);
        statusTextView = findViewById(R.id.statusTextView);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                registerUser(email, password);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                loginUser(email, password);
            }
        });
    }

    private void registerUser(String email, String password) {
        mAuth.fetchSignInMethodsForEmail(email)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        boolean isNewUser = task.getResult().getSignInMethods().isEmpty();

                        if (isNewUser) {
                            mAuth.createUserWithEmailAndPassword(email, password)
                                    .addOnCompleteListener(this, createTask -> {
                                        if (createTask.isSuccessful()) {
                                            FirebaseUser user = mAuth.getCurrentUser();
                                            if (user != null) {
                                                sendEmailVerification(user);

                                                // Perform the additional action here
                                                Calendar calendar = Calendar.getInstance();
                                                calendar.add(Calendar.DAY_OF_YEAR, 30); // Subtract 1 day
                                                String initialDate = formatDate(calendar.getTime());

                                                // Save the initial date in SharedPreferences
                                                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                                editor.putString("savedDate", initialDate);
                                                editor.apply();
                                                Toast.makeText(LoginActivity.this, "reggone ", Toast.LENGTH_SHORT).show();


                                            }
                                        } else {
                                            statusTextView.setText("Registration failed. Please try again.");
                                        }
                                    });
                        } else {
                            statusTextView.setText("Email already registered. Please use a different email.");
                        }
                    } else {
                        statusTextView.setText("Registration failed. Please try again.");
                    }
                });
    }

    private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return sdf.format(date);
    }


    private void sendEmailVerification(FirebaseUser user) {
        user.sendEmailVerification()
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        statusTextView.setText("Verification email sent. Please check your email.");
                    } else {
                        statusTextView.setText("Failed to send verification email.");
                    }
                });
    }

    private void loginUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        if (user != null && user.isEmailVerified()) {
                            statusTextView.setText("Login successful.");
                            launchMainActivity();
                        } else {
                            statusTextView.setText("Email not verified. Please check your email.");
                        }
                    } else {
                        statusTextView.setText("Login failed. Please check your credentials.");
                    }
                });
    }

    private void launchMainActivity() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

