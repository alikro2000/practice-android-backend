package app;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.InetAddresses;
import android.util.Log;
import android.widget.Toast;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class app {

    public static class main {
        public static final String TAG = "Season8";
//        public static final String BASE_URL = "https://trainzero.000webhostapp.com/";
        public static final String BASE_URL = "http://";
    }

    public static void l(String message) {
        Log.e(main.TAG, message);
    }

    public static void t(String message) {
        Toast.makeText(Application.getContext(), message, Toast.LENGTH_SHORT).show();
    }

    public static boolean isConnected() {

        ConnectivityManager connectivityManager = (ConnectivityManager)
                Application.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        return connectivityManager.getActiveNetwork() != null;
    }

    public static boolean isDataAvailable() {
        try {
//            InetAddress inetAddress = InetAddress.getByName("https://trainzero.000webhostapp.com/");
            InetAddress inetAddress = InetAddress.getByName("www.google.com");

            return !inetAddress.equals("");
        } catch (UnknownHostException e) {
            return false;
        }
    }
}
