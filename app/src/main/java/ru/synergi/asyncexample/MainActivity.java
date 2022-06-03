package ru.synergi.asyncexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void buttonClick(View view){
        Intent intent = null
        switch(view.getId()){  //привязывыаем реализацию онклик на кнопку
            case R.id.asynctask:
                Intent = new Intent(this, AsyncTaskExample.class);
                startActivity(intent);
                break;
            case R.id:thread:
            Intent = new Intent(this, ThreadExample.class);
                startActivity(intent);
                break;
            default:return;
        }
    }
}