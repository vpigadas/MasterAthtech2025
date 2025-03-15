package gr.athtech.course;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import gr.athtech.course.databinding.ActivityLoginBinding;
import gr.athtech.course.network.NetworkActivity;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.mainBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = binding.mainEditUsername.getText().toString();
                String password = binding.mainEditPassword.getText().toString();

                Log.d("Login", "username:" + username + ", password:" + password);
                Snackbar.make(v, "username:" + username + ", password:" + password, Snackbar.LENGTH_SHORT).show();
            }
        });

        binding.mainBtnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, NetworkActivity.class);
                startActivity(intent);
            }
        });

        binding.mainEditForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name", "vassilis");
                intent.putExtra("age", 100);

                setResult(5000, intent);
                finish();
            }
        });
    }
}