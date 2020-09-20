package ir.alikro.session8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import adapter.E06Adapter;
import app.MyHttpClient;
import cz.msebera.android.httpclient.Header;
import objects.E06Customer;

import app.*;

public class E06JSONObject extends AppCompatActivity {

    RecyclerView recyclerView;
    List<E06Customer> customers;
    E06Adapter adapter;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e06_jsonobject);
        setTitle(this.getClass().getSimpleName());

        init();
    }

    private void init() {

        recyclerView = findViewById(R.id.recyclerView);
        customers = new ArrayList<E06Customer>();
        adapter = new E06Adapter(this, customers);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutAnimation(new LayoutAnimationController(
                AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        ));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });

        getData();
    }

    private void getData() {
        swipeRefreshLayout.setRefreshing(true);

        MyHttpClient.get("E06JSONObject.php", null, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                app.l(new String(responseBody));
                parseData(new String(responseBody));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                app.l("Failed: " + statusCode);
            }

            @Override
            public void onFinish() {
                swipeRefreshLayout.setRefreshing(false);
                super.onFinish();
            }

        });
    }

    private void parseData(String data) {

        customers.clear();

        try {
            JSONArray jsonArray = new JSONArray(data);

            for (int i = 0; i < jsonArray.length(); ++i) {
                customers.add(new E06Customer(jsonArray.getJSONObject(i)));
            }

            adapter.notifyDataSetChanged();

        } catch (JSONException e) {
            e.toString();
        }

    }
}