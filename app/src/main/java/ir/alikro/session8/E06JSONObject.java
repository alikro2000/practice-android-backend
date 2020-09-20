package ir.alikro.session8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import adapter.E06Adapter;
import app.MyHttpClient;
import cz.msebera.android.httpclient.Header;
import objects.E06Customers;

import app.*;

public class E06JSONObject extends AppCompatActivity {

    RecyclerView recyclerView;
    List<E06Customers> customers;
    E06Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e06_jsonobject);
        setTitle(this.getClass().getSimpleName());

        init();
    }

    private void init() {

        recyclerView = findViewById(R.id.recyclerView);
        customers = new ArrayList<E06Customers>();
        adapter = new E06Adapter(this, customers);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutAnimation(new LayoutAnimationController(
                AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        ));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getData();
    }

    private void getData() {
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

        });
    }

    private void parseData(String data) {

        customers.clear();

        try {
            JSONArray jsonArray = new JSONArray(data);

            for (int i = 0; i < jsonArray.length(); ++i) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                app.l(jsonObject.getString(ROUTER.CustomerName));

                E06Customers singleCustomer = new E06Customers();
                singleCustomer.setCustomerID(jsonObject.getInt(ROUTER.CustomerID));
                singleCustomer.setCustomerName(jsonObject.getString(ROUTER.CustomerName));
                singleCustomer.setContactName(jsonObject.getString(ROUTER.ContactName));
                singleCustomer.setAddress(jsonObject.getString(ROUTER.Address));
                singleCustomer.setCity(jsonObject.getString(ROUTER.City));
                singleCustomer.setPostalCode(jsonObject.getString(ROUTER.PostalCode));
                singleCustomer.setCountry(jsonObject.getString(ROUTER.Country));

                customers.add(singleCustomer);
            }

            adapter.notifyDataSetChanged();

        } catch (JSONException e) {
            e.toString();
        }

    }
}