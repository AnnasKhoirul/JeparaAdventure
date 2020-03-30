package sch.id.smkn1bangsri.jeparaadventure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class BudayaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Budaya> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budaya);

        recyclerView = (RecyclerView) findViewById(R.id.rv_category);
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(BudayaJepara.getListDAta());

        showRecyclerList();
    }

    private void showRecyclerList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListBudayaAdapter listBudayaAdapter = new ListBudayaAdapter(this, new ListBudayaAdapter.OnClick() {
            @Override
            public void onClick(Object budaya) {
                Budaya budaya1 = (Budaya) budaya;
                Intent intent = new Intent(BudayaActivity.this, DetailBudayaActivity.class);
                intent.putExtra("kunci", budaya1);
                startActivity(intent);
            }
        });
        listBudayaAdapter.setListBudaya(list);
        recyclerView.setAdapter(listBudayaAdapter);

    }
}
