package com.example.foxproject1;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.foxproject1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        viewModel.telephone.observe(this, new Observer<ScreenEvent>() {
            @Override
            public void onChanged(ScreenEvent screenEvent) {
                if (screenEvent instanceof ShowLabel) {
                    binding.test.setText(((ShowLabel) screenEvent).label);
                } else if (screenEvent instanceof ShowToast) {
                    Toast.makeText(MainActivity.this, ((ShowToast) screenEvent).message, Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.onClickOla("OLA BOGA!");
            }
        });

        binding.buttonMama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.onClickMama("Mamma Mia!");
            }
        });

    }
}