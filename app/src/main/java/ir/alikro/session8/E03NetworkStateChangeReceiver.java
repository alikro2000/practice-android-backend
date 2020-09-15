package ir.alikro.session8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import interfaces.NetworkStateChangeListener;
import receivers.NetworkStateChangeReceiver;

public class E03NetworkStateChangeReceiver extends AppCompatActivity {

    TextView netState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e03_network_state_change_receiver);

        setTitle(getClass().getSimpleName());
        netState = findViewById(R.id.netState);

        NetworkStateChangeReceiver.networkStateChangeListener = new NetworkStateChangeListener() {
            @Override
            public void onChange(boolean status) {
                netState.setText(getString(status ? R.string.connected : R.string.notConnected));
            }
        };

    }
}