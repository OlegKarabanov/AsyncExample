package ru.synergi.asyncexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AsyncTaskExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_example);

        MyAsyncTask asyncTask = new MyAsyncTask();
        asyncTask.execute();
    }

}

class MyAsyncTask extends AsyncTask<String, Integer, Integer>{



    @Override
    protected Integer doInBackground(String... strings){
        int myProgress = 0;
        publishProgress(myProgress);
        int result = myProgress++;
        return result;
    }

    @Override
    protected void onProgressUpdate(Integer... values){

        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Integer integer){
        super.onPostExecute(integer);
    }

}