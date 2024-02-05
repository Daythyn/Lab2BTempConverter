package com.example.lab2btempconv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.lab2btempconv.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Do Fahrenheit Conversion
                try{

                    double fah = Double.parseDouble(String.valueOf(binding.fahDoubleField.getText()));
                    double cel = ((fah - 32.0000) / 1.8000);
                    binding.celDoubleField.setText(String.valueOf(cel));

                } catch (Exception e) {
                    //Do Celsius Conversion if Fahrenheit fails
                    try{

                        double cel = Double.parseDouble(String.valueOf(binding.celDoubleField.getText()));
                        double fah = ((cel * 1.8) + 32);
                        binding.fahDoubleField.setText(String.valueOf(fah));

                    } catch (Exception ex) {
                        //Do nothing if Celsius fails as well...
                    }
                }
            }
        });

        binding.clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                binding.celDoubleField.setText(String.valueOf(""));
                binding.fahDoubleField.setText(String.valueOf(""));

            }
        });

    }
}