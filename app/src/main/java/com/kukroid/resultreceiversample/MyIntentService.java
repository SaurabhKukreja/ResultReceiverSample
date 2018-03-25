package com.kukroid.resultreceiversample;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.annotation.Nullable;

import java.util.Random;

/**
 * Created by saura on 3/24/2018.
 */

public class MyIntentService extends IntentService {

    ResultReceiver myResultReceiver;
    private static String TAG = MyIntentService.class.getSimpleName();
    public MyIntentService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        Random random = new Random();
        int compValue = random.nextInt(50)+1;

        if(intent!=null){
           myResultReceiver =  intent.getParcelableExtra("result");
        }

        Bundle bundle = new Bundle();
        bundle.putInt("compValue",compValue);
        myResultReceiver.send(100,bundle);
    }
}
