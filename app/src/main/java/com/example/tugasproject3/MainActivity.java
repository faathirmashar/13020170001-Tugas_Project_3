package com.example.tugasproject3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView image;
    private Toolbar toolbar;
    private Button prisma, limas, kerucut, balok;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        prisma = findViewById(R.id.prisma);
        limas = findViewById(R.id.limas);
        kerucut = findViewById(R.id.kerucut);
        balok = findViewById(R.id.balok);
        image = findViewById(R.id.imageView);

        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        prisma.setOnClickListener(click);
        limas.setOnClickListener(click);
        kerucut.setOnClickListener(click);
        balok.setOnClickListener(click);
    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.limas :
                    image.setImageResource(R.drawable.limas_segilima);

                    Intent i = new Intent(MainActivity.this, Main2Activity.class);
                    i.putExtra("Bangun", "limas");
                    startActivity(i);

                    break;
                case R.id.prisma :
                    image.setImageResource(R.drawable.prisma_segilima);

                    i = new Intent(MainActivity.this, Main2Activity.class);
                    i.putExtra("Bangun", "prisma");
                    startActivity(i);

                    break;
                case R.id.kerucut :
                    image.setImageResource(R.drawable.kerucut);

                    i = new Intent(MainActivity.this, Main2Activity.class);
                    i.putExtra("Bangun", "kerucut");
                    startActivity(i);

                    break;
                case R.id.balok :
                    image.setImageResource(R.drawable.balok);

                    i = new Intent(MainActivity.this, Main2Activity.class);
                    i.putExtra("Bangun", "balok");
                    startActivity(i);

                    break;
                default:
                    image.setImageResource(R.drawable.limas_segilima);
                    break;
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.account) {
            startActivity(new Intent(MainActivity.this, Main3Activity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
