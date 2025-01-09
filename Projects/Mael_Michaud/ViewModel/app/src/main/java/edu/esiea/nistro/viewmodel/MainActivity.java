package edu.esiea.nistro.viewmodel;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import edu.esiea.nistro.viewmodel.databinding.ActivityMainBinding;
import edu.esiea.nistro.viewmodel.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        mainViewModel.score.observe(this, score -> {
            binding.counterTextView.setText(String.valueOf(score));
        });

        binding.plusBtn.setOnClickListener(view -> mainViewModel.increment());

        binding.minusBtn.setOnClickListener(view -> mainViewModel.decrement());
    }
}