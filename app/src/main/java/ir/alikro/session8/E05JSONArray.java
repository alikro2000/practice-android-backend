package ir.alikro.session8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import java.util.ArrayList;
import java.util.List;

import adapter.E05Adapter;

public class E05JSONArray extends AppCompatActivity {

    RecyclerView recyclerView;
    List<String> list;
    E05Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e05_jsonarray);

        setTitle(getClass().getSimpleName());
        init();
    }

    private void init() {
        recyclerView = findViewById(R.id.recyclerView);
        list = new ArrayList<String>();
        adapter = new E05Adapter(list);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutAnimation(new LayoutAnimationController(
                AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        ));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getData();
    }

    private void getData() {
        
    }
}