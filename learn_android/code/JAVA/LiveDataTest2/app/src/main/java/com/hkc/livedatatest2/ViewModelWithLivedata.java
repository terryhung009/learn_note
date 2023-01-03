package com.hkc.livedatatest2;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModelWithLivedata extends ViewModel {
    private MutableLiveData<Integer> LikedNumber ;

//    ViewModelWithLivedata(){
//        LikedNumber = new MutableLiveData<>();
//        LikedNumber.setValue(0);
//    }

    public MutableLiveData<Integer> getLikedNumber() {
        if(LikedNumber == null) {
            LikedNumber = new MutableLiveData<>();
            LikedNumber.setValue(0);
        }
        return LikedNumber;
    }

    public void addLikedNumber(int n) {
        LikedNumber.setValue(LikedNumber.getValue() + n );
    }





}

