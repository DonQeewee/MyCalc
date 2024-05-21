package com.example.calc1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.calc1.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    double firstNum;
    double secondNum;

    String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.off.setOnClickListener(v -> {
            binding.screen.setVisibility(View.GONE);
        });
        binding.on.setOnClickListener(v -> {
            binding.screen.setVisibility(View.VISIBLE);
            binding.screen.setText("0");
        });
        binding.ac.setOnClickListener(v -> {
            firstNum = 0;
            binding.screen.setText("0");
        });
        //Number buttons click listeners
        View.OnClickListener numberClickListener = v ->{
            Button button = (Button) v;
            String currentText = binding.screen.getText().toString();
            if (currentText.equals("0")){
                binding.screen.setText(button.getText().toString());
            }else {
                binding.screen.setText(currentText + button.getText().toString());
            }
        };

        binding.num0.setOnClickListener(numberClickListener);
        binding.num1.setOnClickListener(numberClickListener);
        binding.num2.setOnClickListener(numberClickListener);
        binding.num3.setOnClickListener(numberClickListener);
        binding.num4.setOnClickListener(numberClickListener);
        binding.num5.setOnClickListener(numberClickListener);
        binding.num6.setOnClickListener(numberClickListener);
        binding.num7.setOnClickListener(numberClickListener);
        binding.num8.setOnClickListener(numberClickListener);
        binding.num9.setOnClickListener(numberClickListener);

        binding.div.setOnClickListener(v -> {
            handleOperatorClick("/");
        });
        binding.times.setOnClickListener(v -> {
            handleOperatorClick("X");
        });
        binding.minus.setOnClickListener(v -> {
            handleOperatorClick("-");
        });
        binding.plus.setOnClickListener(v -> {
            handleOperatorClick("+");
        });

        binding.del.setOnClickListener(v -> {
            String num = binding.screen.getText().toString();
            if (num.length() > 1) {
                binding.screen.setText(num.substring(0, num.length() - 1));
            } else if (num.length() == 1 && !num.equals("0")) {
                binding.screen.setText("0");
            }
        });

        binding.point.setOnClickListener(v -> {
            String currentText = binding.screen.getText().toString();
            if (!currentText.contains(".")) {
                binding.screen.setText(currentText + ".");
            }
        });

        binding.equals.setOnClickListener(v -> {
            secondNum = Double.parseDouble(binding.screen.getText().toString());
            double result;
            switch (operation) {
                case "/":
                    result = firstNum / secondNum;
                    break;
                case "X":
                    result = firstNum * secondNum;
                    break;
                case "+":
                    result = firstNum + secondNum;
                    break;
                case "-":
                    result = firstNum - secondNum;
                    break;
                default:
                    result = firstNum + secondNum;
            }
            binding.screen.setText(String.valueOf(result));
            firstNum = result;
        });

    }
    private void handleOperatorClick(String operator) {
        firstNum = Double.parseDouble(binding.screen.getText().toString());
        operation = operator;
        binding.screen.setText(operator);
        binding.screen.setText("0");
    }
}