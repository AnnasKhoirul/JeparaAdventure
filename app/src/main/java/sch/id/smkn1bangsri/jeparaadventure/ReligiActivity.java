package sch.id.smkn1bangsri.jeparaadventure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class ReligiActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Religi> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_religi);

        recyclerView = (RecyclerView) findViewById(R.id.rv_category);
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(ReligiJepara.getListDAta());

        showRecyclerList();
    }

    private void showRecyclerList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListReligiAdapter listReligiAdapter = new ListReligiAdapter(this, new ListReligiAdapter.OnClick() {
            @Override
            public void onClick(Object religi) {
                Religi religi1 = (Religi) religi;
                Intent intent = new Intent(ReligiActivity.this, DetailReligiActivity.class);
                intent.putExtra("kunci", religi1);
                startActivity(intent);
            }
        });
        listReligiAdapter.setListReligi(list);
        recyclerView.setAdapter(listReligiAdapter);

    }
}
