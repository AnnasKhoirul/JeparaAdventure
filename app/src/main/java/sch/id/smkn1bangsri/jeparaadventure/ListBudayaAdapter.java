package sch.id.smkn1bangsri.jeparaadventure;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListBudayaAdapter extends RecyclerView.Adapter<ListBudayaAdapter.CardViewViewHolder> {

    private Context context;
    private ArrayList<Budaya> listBudaya;
    private OnClick onClick;
    private CardView cardView;

    public ListBudayaAdapter(Context context, OnClick onClick) {
        this.context = context;
        this.onClick = onClick;
    }


    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_budaya, viewGroup, false);
        CardViewViewHolder viewHolder = new CardViewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewViewHolder cardViewViewHolder, int i) {

        Budaya p = getListBudaya().get(i);
        cardViewViewHolder.tampil(p, onClick);

    }

    @Override
    public int getItemCount() {
        return getListBudaya().size();
    }

    public ArrayList<Budaya> getListBudaya() {
        return listBudaya;
    }

    public void setListBudaya(ArrayList<Budaya> listBudaya) {
        this.listBudaya = listBudaya;
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFoto;
        TextView tvNama, tvDetail;
        Button btnShare;
        CardView btnDetail;
        Budaya budaya;


        public CardViewViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.img_view);
            tvNama = (TextView) itemView.findViewById(R.id.txt_nama);
            btnDetail = (CardView) itemView.findViewById(R.id.btn_detail);

        }

        public void tampil(final Budaya budaya, final OnClick OnItemClick) {

            Glide.with(context)
                    .load(budaya.getFoto())

                    .into(imgFoto);

            tvNama.setText(budaya.getNama());

            btnDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OnItemClick.onClick(budaya);

                }
            });

        }
    }

    public interface OnClick {
        void onClick(Object budaya);
    }
}
