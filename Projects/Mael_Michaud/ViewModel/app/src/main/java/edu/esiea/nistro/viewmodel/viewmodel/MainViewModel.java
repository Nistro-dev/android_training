package edu.esiea.nistro.viewmodel.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public MutableLiveData<Integer> score;

    public MainViewModel() {
        score = new MutableLiveData<>();
        score.setValue(0);
    }


    public void increment() {
        if (score.getValue() != null) {
            score.setValue(score.getValue() + 1);
        }
    }

    public void decrement() {
        if (score.getValue() != null) {
            score.setValue(score.getValue() - 1);
        }
    }
}
