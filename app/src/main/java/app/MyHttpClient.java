package app;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.client.ResponseHandler;
import ir.alikro.session8.R;

public class MyHttpClient {

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
//        if (relativeUrl.contains("http://") || relativeUrl.contains("https://")) {
//            return relativeUrl;
//        } else {
//            return app.main.BASE_URL + relativeUrl;
//        }

        return relativeUrl.contains("http://") || relativeUrl.contains("https://") ?
                relativeUrl : app.main.BASE_URL + relativeUrl;
    }

}
