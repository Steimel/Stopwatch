package com.tommysteimel.stopwatch;

import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class Stopwatch extends ActionBarActivity {

    private final int STATE_STOPPED = 0;
    private final int STATE_RUNNING = 1;
    private int state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        state = STATE_STOPPED;
    }

    public void click(View view) {
        switch(state) {
            case STATE_STOPPED:
                startTime();
                break;
            case STATE_RUNNING:
                stopTime();
                break;
        }
    }

    private void startTime() {
        getChron().setBase(SystemClock.elapsedRealtime());
        getChron().start();
        getButton().setText(R.string.stop);
        state = STATE_RUNNING;
    }

    private void stopTime() {
        getChron().stop();
        getButton().setText(R.string.start);
        state = STATE_STOPPED;
    }

    private Chronometer getChron() {
        return (Chronometer) findViewById(R.id.chron);
    }

    private Button getButton() {
        return (Button) findViewById(R.id.button);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stopwatch, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}
