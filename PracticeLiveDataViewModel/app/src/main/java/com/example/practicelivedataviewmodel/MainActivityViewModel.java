package com.example.practicelivedataviewmodel;

import android.os.Handler;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class MainActivityViewModel extends ViewModel {

    private String TAG= MainActivityViewModel.class.getSimpleName();
    private MutableLiveData<List<String>> songList;
    // MutableLiveData la lop mo rong cua liveData - setValue , postValue
    LiveData<List<String>> getSongList(){
        if(songList == null){
            songList = new MutableLiveData<>();
            loadSong();
        }
        return songList;
    }

    private void loadSong(){
        Handler mHandler = new android.os.Handler();//data đây
        mHandler.postDelayed(()->{
            List<String> songStringList = new ArrayList<>();
            songStringList.add("Never be like you");
            songStringList.add("Happening");
            songStringList.add("Holo");
            songStringList.add("Glorious");
            songStringList.add("Fire on Fire ");
            long seed = System.nanoTime();
            Collections.shuffle(songStringList,new Random(seed));
            songList.setValue(songStringList);
        },5000);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG,"on cleared called ");
    }
}
