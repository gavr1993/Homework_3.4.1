package com.example.homework_332;

import androidx.appcompat.app.AppCompatActivity;

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
    String[] languages;
    private Button btnOk;
    private Spinner spinner;
    private TextView statusTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOk = findViewById(R.id.btnOk);
        languages = new String[]{getString(R.string.ru), getString(R.string.en)};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, languages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
    }
}