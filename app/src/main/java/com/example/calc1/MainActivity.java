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

        binding.off.setOnClickListener(v -> binding.screen.setVisibility(View.GONE));
        binding.on.setOnClickListener(v -> {
            binding.screen.setVisibility(View.VISIBLE);
            binding.screen.setText("0");
        });
        binding.ac.setOnClickListener(v -> {
            firstNum = 0;
            binding.screen.setText("0");
        });
        binding.num0.setOnClickListener(v -> {
            binding.screen.setText("0");
        });
        binding.num1.setOnClickListener(v -> {
            binding.screen.setText("1");
        });
        binding.num2.setOnClickListener(v -> {
            binding.screen.setText("2");
        });
        binding.num3.setOnClickListener(v -> {
            binding.screen.setText("3");
        });
        binding.num4.setOnClickListener(v -> {
            binding.screen.setText("4");
        });
        binding.num5.setOnClickListener(v -> {
            binding.screen.setText("5");
        });
        binding.num6.setOnClickListener(v -> {
            binding.screen.setText("6");
        });
        binding.num7.setOnClickListener(v -> {
            binding.screen.setText("7");
        });
        binding.num8.setOnClickListener(v -> {
            binding.screen.setText("8");
        });
        binding.num9.setOnClickListener(v -> {
            binding.screen.setText("9");
        });

        ArrayList<Button> nums = new ArrayList<>();
        nums.add(binding.num0);
        nums.add(binding.num1);
        nums.add(binding.num2);
        nums.add(binding.num3);
        nums.add(binding.num4);
        nums.add(binding.num5);
        nums.add(binding.num6);
        nums.add(binding.num7);
        nums.add(binding.num8);
        nums.add(binding.num9);

        for (Button b : nums) {
            if (!binding.screen.getText().toString().equals("0")) {
                binding.screen.setText(binding.screen.getText().toString() + b.getText().toString());
            } else {
                binding.screen.setText(b.getText().toString());
            }
        }

        binding.div.setOnClickListener(v -> {
            binding.screen.setText("/");
        });
        binding.times.setOnClickListener(v -> {
            binding.screen.setText("X");
        });
        binding.minus.setOnClickListener(v -> {
            binding.screen.setText("-");
        });
        binding.plus.setOnClickListener(v -> {
            binding.screen.setText("+");
        });


        ArrayList<Button> operators = new ArrayList<>();
        operators.add(binding.div);
        operators.add(binding.times);
        operators.add(binding.minus);
        operators.add(binding.plus);
        for (Button b : operators) {
            b.setOnClickListener(v -> {
                firstNum = Double.parseDouble(binding.screen.getText().toString());
                operation = b.getText().toString();
                binding.screen.setText(b.getText().toString());

            });
        }

        binding.del.setOnClickListener(v -> {
            String num = binding.screen.getText().toString();
            if (num.length() > 1) {
                binding.screen.setText(num.substring(0, num.length() - 1));
            } else if (num.length() == 1 && !num.equals("0")) {
                binding.screen.setText("0");
            }
        });

        binding.point.setOnClickListener(v -> {
            binding.screen.setText(".");
            if (!binding.screen.getText().toString().contains(".")) {
                binding.screen.setText(binding.screen.getText().toString() + ".");
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
}