package com.example.foxproject1;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private String lastText;
    private Integer textCount = 0;

    public void setText(String s) {
        lastText = s;
        textCount++;
    }

    public String getLastText() {
        return lastText + " " + textCount;
    }
}
