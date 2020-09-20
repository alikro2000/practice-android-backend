package ir.alikro.session8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class E06CustomersActivity extends AppCompatActivity {

    public static final String OBJECT_KEY = "CUSTOMERS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e06_customers_activity);

        getIntent().getSerializableExtra(OBJECT_KEY);
    }
}