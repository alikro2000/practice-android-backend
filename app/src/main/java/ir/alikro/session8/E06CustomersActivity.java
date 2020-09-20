package ir.alikro.session8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import objects.E06Customer;

public class E06CustomersActivity extends AppCompatActivity {

    public static final String OBJECT_KEY = "CUSTOMERS";

    E06Customer customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e06_customers_activity);

        customer = (E06Customer) getIntent().getSerializableExtra(OBJECT_KEY);
        setTitle(customer.getContactName());

        setText(R.id.customerID, customer.getCustomerID() + "");
        setText(R.id.customerName, customer.getCustomerName() + "");
        setText(R.id.contactName, customer.getContactName() + "");
        setText(R.id.address, customer.getAddress() + "");
        setText(R.id.city, customer.getCity() + "");
        setText(R.id.country, customer.getCountry() + "");

    }

    private void setText(int resID, String message) {
        TextView txt = findViewById(resID);
        txt.setText(message);
    }
}