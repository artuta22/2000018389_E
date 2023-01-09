package com.praktikum.responsii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class Login_Karyawan extends AppCompatActivity {
    EditText username, password;
    Button btnlogin;
    String keynama, keypass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_karyawan);
        btnlogin = findViewById(R.id.tombollogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = findViewById(R.id.editekuser);
                password = findViewById(R.id.editekpassword);
                btnlogin = findViewById(R.id.tombollogin);
                keynama = username.getText().toString();
                keypass = password.getText().toString();

                //username diisi dengan admin dan password dengan admin
                if (keynama.equals("karyawan") && keypass.equals("karyawan")) {
                    //jika login berhasil
                    Toast.makeText(getApplicationContext(),
                            "LOGIN BERHASIL", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Login_Karyawan.this, MainActivity.class);
                    Login_Karyawan.this.startActivity(intent);
                    finish();
                }
                else {
                    //jika login gagal
                    AlertDialog.Builder builder = new AlertDialog.Builder(Login_Karyawan.this);
                    builder.setMessage
                            ("Username atau password salah").setNegativeButton
                            ("ulangi", null).create().show();
                    username.setText("");
                    password.setText("");

                }
            }
        });
    }
}