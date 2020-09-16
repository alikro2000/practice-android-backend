package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.Application;
import ir.alikro.session8.R;

public class E05Adapter extends RecyclerView.Adapter<E05Adapter.MyViewHolder> {

    private List<String> list;

    public E05Adapter(List<String> list) {
        this.list = list;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(Application.getContext()).
                inflate(R.layout.layout_e05, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
