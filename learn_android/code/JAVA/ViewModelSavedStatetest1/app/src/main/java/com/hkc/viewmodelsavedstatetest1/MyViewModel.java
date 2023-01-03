package com.hkc.viewmodelsavedstatetest1;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
//    MutableLiveData<Integer> number;
    private SavedStateHandle handle;

    public MyViewModel(SavedStateHandle handle){
        this.handle = handle;
    }

    public MutableLiveData<Integer> getNumber() {
        if(!handle.contains(MainActivity.KEY_NUMBER)){
            handle.set(MainActivity.KEY_NUMBER,0);
        }
        return handle.getLiveData(MainActivity.KEY_NUMBER);
//        if(number == null){
//            MutableLiveData<Integer> number = new MutableLiveData<>();
//            number.setValue(0);
//        }
//        return number;
    }
    public void addNumber(){
        getNumber().setValue(getNumber().getValue() +1);
//        number.setValue(number.getValue()+1);
    }


}
