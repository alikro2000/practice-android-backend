package adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ir.alikro.session8.R;
import objects.E06Customers;

public class E06Adapter extends RecyclerView.Adapter<E06Adapter.E06ViewHolder> {

    Activity activity;
    List<E06Customers> customers;

    public E06Adapter(Activity activity, List<E06Customers> customers) {
        this.activity = activity;
        this.customers = customers;
    }

    @NonNull
    @Override
    public E06ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.layout_e06_row, parent, false);
        return new E06ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull E06ViewHolder holder, int position) {
        holder.customerName.setText(customers.get(position).getCustomerName());
    }

    @Override
    public int getItemCount() {
        return this.customers.size();
    }

    public class E06ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        RelativeLayout row;
        TextView customerName;

        public E06ViewHolder(@NonNull View itemView) {
            super(itemView);

            row = itemView.findViewById(R.id.row);
            customerName = itemView.findViewById(R.id.customerName);

            row.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //TODO: onlick
        }
    }

}
