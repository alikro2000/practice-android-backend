package ir.alikro.session8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import app.app;

public class E02NetworkState extends AppCompatActivity {

    Button check;
    TextView result;

    boolean dataState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e02_network_state);

        setTitle(getClass().getSimpleName());
        init();
    }

    private void init() {
        check = findViewById(R.id.check);
        result = findViewById(R.id.result);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Is there a connection to the internet or not.
                result.setText(app.isConnected() ? R.string.connected : R.string.notConnected);


                // If connected, can data be exchanged? - data charge available for client
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        dataState = app.isDataAvailable();

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (dataState) {
                                    result.append("\n" + getString(R.string.dataAvailable));
                                } else {
                                    result.append("\n" + getString(R.string.dataNotAvailable));
                                }
                            }
                        });
                    }
                }).start();
            }
        });
    }


}