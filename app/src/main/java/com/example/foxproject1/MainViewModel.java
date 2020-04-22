package com.example.foxproject1;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    MutableLiveData<ScreenEvent> telephone = new MutableLiveData<>();

    private Integer olaTextCount = 0;
    private Integer mamaTextCount = 0;

    public void onClickOla(String text) {
        olaTextCount++;
        telephone.postValue(new ShowLabel(text + olaTextCount));
    }

    public void onClickMama(String text) {
        mamaTextCount++;
        telephone.postValue(new ShowToast(text + mamaTextCount));
    }

}
