package com.example.first_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Objects;

interface Command {
    String runCommand();
}

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText firstValue = findViewById(R.id.firstValue);
        EditText secondValue = findViewById(R.id.secondValue);

        EditText resultInput = findViewById(R.id.result);

        Button sumButton = findViewById(R.id.sum);
        Button subtractButton = findViewById(R.id.subtract);
        Button multiplyButton = findViewById(R.id.multiply);
        Button divideButton = findViewById(R.id.divide);

        HashMap<String, Command> operations = new HashMap<>();

        operations.put("sum", new Command() {
            @Override
            public String runCommand() {
                float result = Float.parseFloat(firstValue.getText().toString()) + Float.parseFloat(secondValue.getText().toString());
                return Float.toString(result);
            }
        });

        operations.put("subtract", new Command() {
            @Override
            public String runCommand() {
                float result = Float.parseFloat(firstValue.getText().toString()) - Float.parseFloat(secondValue.getText().toString());
                return Float.toString(result);
            }
        });

        operations.put("divide", new Command() {
            @Override
            public String runCommand() {
                float result = Float.parseFloat(firstValue.getText().toString()) / Float.parseFloat(secondValue.getText().toString());
                return Float.toString(result);
            }
        });

        operations.put("multiply", new Command() {
            @Override
            public String runCommand() {
                float result = Float.parseFloat(firstValue.getText().toString()) * Float.parseFloat(secondValue.getText().toString());
                return Float.toString(result);
            }
        });

        sumButton.setOnClickListener((view) -> {
            resultInput.setText(Objects.requireNonNull(operations.get("sum")).runCommand());
        });

        subtractButton.setOnClickListener((view) -> {
            resultInput.setText(Objects.requireNonNull(operations.get("subtract")).runCommand());
        });

        divideButton.setOnClickListener((view) -> {
            resultInput.setText(Objects.requireNonNull(operations.get("divide")).runCommand());
        });

        multiplyButton.setOnClickListener((view) -> {
            resultInput.setText(Objects.requireNonNull(operations.get("multiply")).runCommand());
        });
    }
}