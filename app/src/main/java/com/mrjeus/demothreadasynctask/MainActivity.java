package com.mrjeus.demothreadasynctask;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar mProgessLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        new Splash().execute();
    }

    private void initView() {
        mProgessLoading = findViewById(R.id.progress_bar);
    }

    private class Splash extends AsyncTask<Void, Integer, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            long minisPerProges = 25;
            int progess = 0;
            while (progess <= 100) {
                progess++;
                publishProgress(progess);
                try {
                    Thread.sleep(minisPerProges);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            mProgessLoading.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Intent intent = new Intent(MainActivity.this, LoadImageActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
