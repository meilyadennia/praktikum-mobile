package com.example.pengelolaanpenyimpananinternal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.*;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private final String fileName = "contohfile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
    }

    public void saveFile(View view) {
        String text = editText.getText().toString();
        try (FileOutputStream fos = openFileOutput(fileName, MODE_PRIVATE)) {
            fos.write(text.getBytes());
            File fileDir = getFilesDir();
            String path = fileDir.getAbsolutePath() + "/" + fileName;
            Toast.makeText(this, "File disimpan di:\n" + path, Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(this, "Gagal menyimpan", Toast.LENGTH_SHORT).show();
        }
    }

    public void readFile(View view) {
        try (FileInputStream fis = openFileInput(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(fis))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            String content = sb.toString().trim();
            editText.setText(content);
            Toast.makeText(this, "Isi file:\n" + content, Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(this, "Gagal membaca", Toast.LENGTH_SHORT).show();
        }
    }

    public void updateFile(View view) {
        // Buat dialog input teks baru
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Ubah Isi File");

        final EditText input = new EditText(this);
        input.setHint("Teks baru");
        builder.setView(input);

        builder.setPositiveButton("Simpan", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String updatedText = input.getText().toString();
                try (FileOutputStream fos = openFileOutput(fileName, MODE_PRIVATE)) {
                    fos.write(updatedText.getBytes());
                    editText.setText(updatedText);
                    Toast.makeText(MainActivity.this, "File berhasil diubah", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(MainActivity.this, "Gagal mengubah", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("Batal", null);
        builder.show();
    }

    public void deleteFile(View view) {
        File file = new File(getFilesDir(), fileName);
        if (file.exists() && file.delete()) {
            Toast.makeText(this, "File dihapus", Toast.LENGTH_SHORT).show();
            editText.setText("");
        } else {
            Toast.makeText(this, "Gagal menghapus", Toast.LENGTH_SHORT).show();
        }
    }
}
