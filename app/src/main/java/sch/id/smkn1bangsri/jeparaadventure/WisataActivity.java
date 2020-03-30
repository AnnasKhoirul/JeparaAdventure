package sch.id.smkn1bangsri.jeparaadventure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class WisataActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Wisata> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata);

        recyclerView = (RecyclerView) findViewById(R.id.rv_category);
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(WisataJepara.getListDAta());

        showRecyclerList();
    }

    private void showRecyclerList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListWisataAdapter listWisataAdapter = new ListWisataAdapter(this, new ListWisataAdapter.OnClick() {
            @Override
            public void onClick(Object wisata) {
                Wisata wisata1 = (Wisata) wisata;
                Intent intent = new Intent(WisataActivity.this, DetailWisataActivity.class);
                intent.putExtra("kunci", wisata1);
                startActivity(intent);
            }
        });
        listWisataAdapter.setListWisata(list);
        recyclerView.setAdapter(listWisataAdapter);

    }
}
