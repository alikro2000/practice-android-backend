package ir.alikro.session8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import app.*;

public class E01HttpConnection extends AppCompatActivity implements View.OnClickListener {

    AppCompatImageView go;
    AppCompatEditText urlTxt;
    AppCompatTextView result;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e01_http_connection);

        setTitle(getClass().getSimpleName());
        init();
    }

    private void init() {
        go = findViewById(R.id.go);
        urlTxt = findViewById(R.id.urlTxt);
        result = findViewById(R.id.result);
        progressBar = findViewById(R.id.progressBar);

        go.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        app.l("Let's load some data from the server! :D");

        result.setText(null);
        progressBar.setVisibility(View.VISIBLE);

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    loadDataFromServer();
//                } catch (MalformedURLException e) {
//                    app.l(e.toString());
//                } catch (IOException e) {
//                    app.l(e.getMessage());
//                }
//            }
//        }).start();

        new AsyncHttp().execute();
    }

    private void loadDataFromServer() throws IOException {

        URL url = new URL(urlTxt.getText().toString());

        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        urlConnection.setConnectTimeout(3000);

        InputStream inputStream = urlConnection.getInputStream();
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            stringBuffer.append(line).append("\n");
        }

        final String resultText = stringBuffer.toString();

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                result.setText(resultText);
            }
        });

        app.l(stringBuffer.toString());
    }


    private class AsyncHttp extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {

            StringBuffer stringBuffer = new StringBuffer();

            try {

                URL url = new URL(urlTxt.getText().toString());

                URLConnection urlConnection = url.openConnection();
                urlConnection.connect();
                urlConnection.setConnectTimeout(3000);

                InputStream inputStream = urlConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuffer.append(line).append("\n");
                }

                final String resultText = stringBuffer.toString();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        result.setText(resultText);
                    }
                });

            } catch (MalformedURLException e) {
                app.l(e.toString());
            } catch (IOException e) {
                app.l(e.getMessage());
            }

            return stringBuffer.toString();
        }

        @Override
        protected void onPostExecute(String aVoid) {

            result.setText(aVoid);
            progressBar.setVisibility(View.GONE);

            super.onPostExecute(aVoid);
        }
    }
}
