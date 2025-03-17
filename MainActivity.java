package com.example.mobileapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inisialisasi tombol dan TextView
        Button buttonAplikasiSeluler = findViewById(R.id.button5);
        Button buttonAplikasiWeb = findViewById(R.id.button6);
        TextView textViewMessage = findViewById(R.id.textViewMessage);

        // Event klik untuk tombol "Aplikasi Seluler"
        buttonAplikasiSeluler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewMessage.setText("Anda memasuki menu Aplikasi Seluler");
                textViewMessage.setVisibility(View.VISIBLE);
            }
        });

        // Event klik untuk tombol "Aplikasi Web"
        buttonAplikasiWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewMessage.setText("Anda memasuki menu Aplikasi Web");
                textViewMessage.setVisibility(View.VISIBLE);
            }
        });
    }
}