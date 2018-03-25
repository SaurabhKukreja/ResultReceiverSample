package com.kukroid.resultreceiversample;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MyResultReceiver.GetResultInterface {

    EditText myNumber;
    TextView compNumber;
    MyResultReceiver myResultReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myNumber = findViewById(R.id.myNumber);
        compNumber = findViewById(R.id.compNumber);
        myResultReceiver = new MyResultReceiver(new Handler());
        myResultReceiver.setReceiver(this);
    }

    @Override
    public void getResult(int resultCode, Bundle resultData) {
        if(resultData!=null){
            switch (resultCode){
                case 100:
                    compNumber.setText(resultData.getInt("compValue")+"");
                    break;
            }
        }
    }

    public void getNumber(View view) {
        Intent intent = new Intent(MainActivity.this,MyIntentService.class);
        intent.putExtra("result",myResultReceiver);
        startService(intent);
    }
}
