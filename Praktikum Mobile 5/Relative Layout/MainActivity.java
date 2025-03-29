package com.example.mobileapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi elemen UI
        EditText etInput = findViewById(R.id.etInput);
        Button btnSubmit = findViewById(R.id.btnSubmit);
        Button btnClear = findViewById(R.id.btnClear);
        TextView tvResult = findViewById(R.id.tvResult);

        // Aksi ketika tombol "Tampilkan" diklik
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = etInput.getText().toString().trim();
                if (!inputText.isEmpty()) {
                    tvResult.setText("Teks: " + inputText);
                } else {
                    tvResult.setText("Silakan masukkan teks.");
                }
            }
        });

        // Aksi ketika tombol "Hapus" diklik
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etInput.setText("");
                tvResult.setText("");
            }
        });
    }
}

