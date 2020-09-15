package receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import app.*;
import interfaces.NetworkStateChangeListener;

public class NetworkStateChangeReceiver extends BroadcastReceiver {

    public static NetworkStateChangeListener networkStateChangeListener;

    @Override
    public void onReceive(Context context, Intent intent) {
        app.l("Network: true");

        if (networkStateChangeListener != null) {
            networkStateChangeListener.onChange(app.isConnected());
        }
    }

}
