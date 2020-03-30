package sch.id.smkn1bangsri.jeparaadventure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class DetailWisataActivity extends AppCompatActivity {

    ImageView fotoku;
    TextView nama, detail2, htm, alamat, infolain;

    public void maps(View view){
        Wisata for_maps = getIntent().getParcelableExtra("kunci");
        Intent mapsIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(for_maps.getLokasi()));
        startActivity(mapsIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);

        Wisata diterima = getIntent().getParcelableExtra("kunci");

        fotoku = (ImageView) findViewById(R.id.img_view);
        nama = (TextView) findViewById(R.id.txt_nama);
        detail2 = (TextView) findViewById(R.id.tv_detail_panjang);
        htm = (TextView) findViewById(R.id.tv_htm);
        alamat = (TextView) findViewById(R.id.tv_alamat);
        infolain = (TextView) findViewById(R.id.tv_infolain);

        Glide.with(this).load(diterima.getFoto()).into(fotoku);

        nama.setText(diterima.getNama());
        detail2.setText(diterima.getDetail2());
        htm.setText(diterima.getHtm());
        alamat.setText(diterima.getAlamat());
        infolain.setText(diterima.getInfolain());

    }

}
