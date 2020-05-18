package com.example.tugasproject3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Main2Activity extends AppCompatActivity {

    private TextView title, hasil;
    private Button btn_hasil;
    private ImageView img_bangun;
    private TextInputLayout textInput1, textInput2, textInput3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn_hasil = findViewById(R.id.btn_hasil);
        textInput1 = findViewById(R.id.textField);
        textInput2 = findViewById(R.id.textField2);
        textInput3 = findViewById(R.id.textField3);
        title = findViewById(R.id.title);
        hasil = findViewById(R.id.hasil);
        img_bangun = findViewById(R.id.img_bangun);

        Intent i = getIntent();

        operation(i);
    }

    public void operation(Intent i){
        switch (i.getStringExtra("Bangun")) {
            case "prisma" :
                getSupportActionBar().setTitle("HITUNG VOLUME PRISMA");
                title.setText("Prisma Segi Lima");
                img_bangun.setImageResource(R.drawable.prisma_segilima);
                textInput1.setHint("Luas Alas");
                textInput2.setHint("Tinggi");

                btn_hasil.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (textInput1.getEditText().getText().toString().equals("") || textInput2.getEditText().getText().toString().equals("")) {
                            Toast.makeText(Main2Activity.this, "Luas Alas atau Tinggi Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                        }else{
                            int la = Integer.parseInt(textInput1.getEditText().getText().toString());
                            int t = Integer.parseInt(textInput2.getEditText().getText().toString());

                            int volume = la * t;

                            hasil.setText("VOLUMENYA ADALAH " + volume);
                        }
                    }
                });

                break;
            case "limas" :
                getSupportActionBar().setTitle("HITUNG VOLUME LIMAS");
                title.setText("Limas Segi Lima");
                img_bangun.setImageResource(R.drawable.limas_segilima);

                textInput1.setHint("Luas Alas");
                textInput2.setHint("Tinggi");

                btn_hasil.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (textInput1.getEditText().getText().toString().equals("") || textInput2.getEditText().getText().toString().equals("")) {
                            Toast.makeText(Main2Activity.this, "Luas Alas atau Tinggi Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                        }else{
                            int la = Integer.parseInt(textInput1.getEditText().getText().toString());
                            int t = Integer.parseInt(textInput2.getEditText().getText().toString());

                            float volume = 1/3f * (la * t);

                            hasil.setText("VOLUMENYA ADALAH " + volume);
                        }
                    }
                });

                break;
            case "kerucut":
                getSupportActionBar().setTitle("HITUNG VOLUME KERUCUT");
                title.setText("Kerucut");
                img_bangun.setImageResource(R.drawable.kerucut);

                textInput1.setHint("Jari Jari");
                textInput2.setHint("Tinggi");

                btn_hasil.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (textInput1.getEditText().getText().toString().equals("") || textInput2.getEditText().getText().toString().equals("")) {
                            Toast.makeText(Main2Activity.this, "Luas Alas atau Tinggi Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                        }else{
                            int r = Integer.parseInt(textInput1.getEditText().getText().toString());
                            int t = Integer.parseInt(textInput2.getEditText().getText().toString());

                            float volume = (float) (1/3f * (22/7f * Math.pow(r, 2) * t));

                            hasil.setText("VOLUMENYA ADALAH " + volume);
                        }
                    }
                });

                break;
            case "balok":
                getSupportActionBar().setTitle("HITUNG VOLUME BALOK");
                title.setText("Balok");
                img_bangun.setImageResource(R.drawable.balok);

                textInput1.setHint("Panjang");
                textInput2.setHint("Lebar");
                textInput3.setHint("Tinggi");

                textInput3.setVisibility(View.VISIBLE);

                btn_hasil.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (textInput1.getEditText().getText().toString().equals("") || textInput2.getEditText().getText().toString().equals("") || textInput3.getEditText().getText().toString().equals("")) {
                            Toast.makeText(Main2Activity.this, "Luas Alas atau Tinggi Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                        }else{
                            
                            int panjang = Integer.parseInt(textInput1.getEditText().getText().toString());
                            int lebar = Integer.parseInt(textInput2.getEditText().getText().toString());
                            int tinggi = Integer.parseInt(textInput3.getEditText().getText().toString());

                            float volume = panjang * lebar * tinggi;

                            hasil.setText("VOLUMENYA ADALAH " + volume);
                        }
                    }
                });

                break;
            default:
                Toast.makeText(this, "Default", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
