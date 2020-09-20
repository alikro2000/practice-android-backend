package ir.alikro.session8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import objects.E06Customers;

public class E06JSONObject extends AppCompatActivity {

    RecyclerView recyclerView;
    List<E06Customers> customers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e06_jsonobject);
    }
}