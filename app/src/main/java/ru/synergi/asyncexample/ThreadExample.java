package ru.synergi.asyncexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExample extends AppCompatActivity {


    ExecutorService service = Executors.newFixedThreadPool(3);





    int mCounter;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            TextView mInfoTextView = (TextView) findViewById(R.id.textViewInfo);
            mInfoTextView.setText("Сегодня ворон было " + mCounter + " штук");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_example);

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                // do time consuming operaions here
//            }
//        }).start();
    }

//    private Runnable doInBackgroundProcessing = new Runnable() {
//        @Override
//        public void run() {
//            backgroundThreadProcessing();
//        }
//    }
//
//    private void backgroundThreadProcessing() {
//        //трудоемкие операции
//    }
//
//
//    private void mainProcessing(){
//
//        Thread thread = new Thread(null, doInBackgroundProcessing, "Background");

    public void onClick(View v) {

        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                Long endTime = System.currentTimeMillis() +20 * 100;
                while (System.currentTimeMillis()< endTime){
                    synchronized (this){
                        try {
                            wait(endTime - System.currentTimeMillis());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //Log.i( "SPARROWS", ("Сегодня ворон было " + mCounter++ + "штук"));
                    handler.sendEmptyMessage(0);
                }
            }
        };
//        Thread thread = new Thread(runnable);
//        thread.start();

       service.execute(runnable);


    }
}