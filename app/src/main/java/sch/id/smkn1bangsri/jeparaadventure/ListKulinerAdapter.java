package sch.id.smkn1bangsri.jeparaadventure;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListKulinerAdapter extends RecyclerView.Adapter<ListKulinerAdapter.CardViewViewHolder> {

    private Context context;
    private ArrayList<Kuliner> listKuliner;
    private ListKulinerAdapter.OnClick onClick;
    private CardView cardView;

    public ListKulinerAdapter(Context context, ListKulinerAdapter.OnClick onClick) {
        this.context = context;
        this.onClick = onClick;
    }


    @NonNull
    @Override
    public ListKulinerAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_kuliner, viewGroup, false);
        ListKulinerAdapter.CardViewViewHolder viewHolder = new ListKulinerAdapter.CardViewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListKulinerAdapter.CardViewViewHolder cardViewViewHolder, int i) {

        Kuliner p = getListKuliner().get(i);
        cardViewViewHolder.tampil(p, onClick);

    }

    @Override
    public int getItemCount() {
        return getListKuliner().size();
    }

    public ArrayList<Kuliner> getListKuliner() {
        return listKuliner;
    }

    public void setListKuliner(ArrayList<Kuliner> listKuliner) {
        this.listKuliner= listKuliner;
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFoto;
        TextView tvNama, tvDetail;
        CardView btnDetail;
        Kuliner kuliner;


        public CardViewViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.img_view);
            tvNama = (TextView) itemView.findViewById(R.id.txt_nama);
            btnDetail = (CardView) itemView.findViewById(R.id.btn_detail);

        }

        public void tampil(final Kuliner kuliner, final ListKulinerAdapter.OnClick OnItemClick) {

            Glide.with(context)
                    .load(kuliner.getFoto())

                    .into(imgFoto);

            tvNama.setText(kuliner.getNama());

            btnDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OnItemClick.onClick(kuliner);

                }
            });

        }
    }

    public interface OnClick {
        void onClick(Object kuliner);
    }
}