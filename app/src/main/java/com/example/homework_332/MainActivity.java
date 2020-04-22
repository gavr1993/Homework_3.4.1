package com.example.homework_332;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    String[] colors;
    String[] languages;
    String[] margins;
    private Button btnOk;
    private Spinner langSpin;
    private Spinner colSpin;
    private TextView statusTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        btnOk = findViewById(R.id.btnOk);
        languages = new String[]{getString(R.string.ru), getString(R.string.en)};
        colors = new String[]{getString(R.string.green), getString(R.string.blue), getString(R.string.black)};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, languages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner langSpin = findViewById(R.id.langSpin);
        langSpin.setAdapter(adapter);
        langSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       final int position, long id) {
                btnOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (position) {
                            case 0:
                                Locale locale = new Locale("ru");
                                Configuration config = new Configuration();
                                config.setLocale(locale);
                                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                                recreate();
                                break;
                            case 1:
                                Locale locale1 = new Locale("en");
                                Configuration config1 = new Configuration();
                                config1.setLocale(locale1);
                                getResources().updateConfiguration(config1, getBaseContext().getResources().getDisplayMetrics());
                                recreate();

                        }
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, colors);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner colSpin = findViewById(R.id.colSpin);
        colSpin.setAdapter(adapter2);
        colSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       final int position, long id) {
                btnOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (position) {
                            case 0:
                                Utils.changeToTheme(MainActivity.this, Utils.THEME_GREEN);
                                break;
                            case 1:
                                Utils.changeToTheme(MainActivity.this, Utils.THEME_BLUE);
                            case 2:
                                Utils.changeToTheme(MainActivity.this, Utils.THEME_BLACK);
                        }
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
}
}