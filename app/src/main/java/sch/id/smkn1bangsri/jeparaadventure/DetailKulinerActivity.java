package sch.id.smkn1bangsri.jeparaadventure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailKulinerActivity extends AppCompatActivity {

    ImageView fotoku;
    TextView nama, detail2, infolain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kuliner);

        Kuliner diterima = getIntent().getParcelableExtra("kunci");

        fotoku = (ImageView) findViewById(R.id.img_view);
        nama = (TextView) findViewById(R.id.txt_nama);
        detail2 = (TextView) findViewById(R.id.tv_detail_panjang);
        infolain = (TextView) findViewById(R.id.tv_infolain);

        Glide.with(this).load(diterima.getFoto()).into(fotoku);

        nama.setText(diterima.getNama());
        detail2.setText(diterima.getDetail2());
        infolain.setText(diterima.getInfolain());

    }
}
