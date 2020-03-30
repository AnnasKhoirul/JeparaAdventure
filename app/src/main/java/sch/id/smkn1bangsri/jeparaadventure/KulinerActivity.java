package sch.id.smkn1bangsri.jeparaadventure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class KulinerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Kuliner> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuliner);

        recyclerView = (RecyclerView) findViewById(R.id.rv_category);
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(KulinerJepara.getListDAta());

        showRecyclerList();
    }

    private void showRecyclerList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListKulinerAdapter listKulinerAdapter= new ListKulinerAdapter(this, new ListKulinerAdapter.OnClick() {
            @Override
            public void onClick(Object kuliner) {
                Kuliner kuliner1 = (Kuliner) kuliner;
                Intent intent = new Intent(KulinerActivity.this, DetailKulinerActivity.class);
                intent.putExtra("kunci", kuliner1);
                startActivity(intent);
            }
        });
        listKulinerAdapter.setListKuliner(list);
        recyclerView.setAdapter(listKulinerAdapter);

    }
}