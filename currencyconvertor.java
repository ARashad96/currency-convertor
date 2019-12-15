package com.ARashad96.androidbeginnerdeveloperkit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class currencyconvertor extends AppCompatActivity {
    EditText value;
    Button convert;
    Double newvalue;
    Spinner dropdown1;
    Spinner dropdown2;
    Button github;
    Button info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_currencyconvertor);

        github = findViewById(R.id.github);
        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/ARashad96/currency-convertor"));
                startActivity(intent);
            }
        });
        info = findViewById(R.id.info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new android.app.AlertDialog.Builder(currencyconvertor.this)
                        .setIcon(R.drawable.profile)
                        .setTitle("App info")
                        .setMessage("This app is performing a simple conversion of currencies using buttons, toast, textview, edittext, spinner and linearlayout.")
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .show();
            }
        });
        dropdown1 = findViewById(R.id.dropdown1);
        dropdown2 = findViewById(R.id.dropdown2);
        value = findViewById(R.id.value);
        String[] items = new String[]{"USD", "EUR", "RUB"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown1.setAdapter(adapter);
        dropdown2.setAdapter(adapter);
        convert = findViewById(R.id.convert);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (value.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Enter value", Toast.LENGTH_LONG).show();
                } else {
                    //usd to usd or euro to euro or rub to rub
                    if (dropdown1.getSelectedItem().toString().equals(dropdown2.getSelectedItem().toString())) {
                        Toast.makeText(currencyconvertor.this, value.getText().toString() + " " + dropdown2.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                    }
                    //usd to euro
                    else if (dropdown1.getSelectedItem().toString().equals("USD") && dropdown2.getSelectedItem().toString().equals("EUR")) {
                        newvalue = Double.parseDouble(value.getText().toString()) * 0.9;
                        Toast.makeText(currencyconvertor.this, newvalue + " " + dropdown2.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                    }
                    //usd to rub
                    else if (dropdown1.getSelectedItem().toString().equals("USD") && dropdown2.getSelectedItem().toString().equals("RUB")) {
                        newvalue = Double.parseDouble(value.getText().toString()) * 62.84;
                        Toast.makeText(currencyconvertor.this, newvalue + " " + dropdown2.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                    }
                    //euro to usd
                    else if (dropdown1.getSelectedItem().toString().equals("EUR") && dropdown2.getSelectedItem().toString().equals("USD")) {
                        newvalue = Double.parseDouble(value.getText().toString()) * 1.11;
                        Toast.makeText(currencyconvertor.this, newvalue + " " + dropdown2.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                    }
                    //euro to rub
                    else if (dropdown1.getSelectedItem().toString().equals("EUR") && dropdown2.getSelectedItem().toString().equals("RUB")) {
                        newvalue = Double.parseDouble(value.getText().toString()) * 69.88;
                        Toast.makeText(currencyconvertor.this, newvalue + " " + dropdown2.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                    }
                    //rub to usd
                    else if (dropdown1.getSelectedItem().toString().equals("EUR") && dropdown2.getSelectedItem().toString().equals("RUB")) {
                        newvalue = Double.parseDouble(value.getText().toString()) * 0.016;
                        Toast.makeText(currencyconvertor.this, newvalue + " " + dropdown2.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                    }
                    //rub to eur
                    else {
                        newvalue = Double.parseDouble(value.getText().toString()) * 0.014;
                        Toast.makeText(currencyconvertor.this, newvalue + " " + dropdown2.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}