package sch.id.smkn1bangsri.jeparaadventure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class DetailBudayaActivity extends AppCompatActivity {

    ImageView fotoku;
    TextView nama, alamatlok, detail2;

    public void maps(View view){
        Budaya for_maps = getIntent().getParcelableExtra("kunci");
        Intent mapsIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(for_maps.getLokasi()));
        startActivity(mapsIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_budaya);

        Budaya diterima = getIntent().getParcelableExtra("kunci");

        fotoku = (ImageView) findViewById(R.id.img_view);
        nama = (TextView) findViewById(R.id.txt_nama);
        alamatlok = (TextView) findViewById(R.id.alamatlok);
        detail2 = (TextView) findViewById(R.id.tv_detail_panjang);

        Glide.with(this).load(diterima.getFoto()).into(fotoku);

        nama.setText(diterima.getNama());
        alamatlok.setText(diterima.getAlamatlok());
        detail2.setText(diterima.getDetail2());

    }
}
