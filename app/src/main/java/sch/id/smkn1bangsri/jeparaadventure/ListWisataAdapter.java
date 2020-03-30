package sch.id.smkn1bangsri.jeparaadventure;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListWisataAdapter extends RecyclerView.Adapter<ListWisataAdapter.CardViewViewHolder> {

    private Context context;
    private ArrayList<Wisata> listWisata;
    private ListWisataAdapter.OnClick onClick;
    private CardView cardView;

    public ListWisataAdapter(Context context, ListWisataAdapter.OnClick onClick) {
        this.context = context;
        this.onClick = onClick;
    }


    @NonNull
    @Override
    public ListWisataAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_wisata, viewGroup, false);
        ListWisataAdapter.CardViewViewHolder viewHolder = new ListWisataAdapter.CardViewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListWisataAdapter.CardViewViewHolder cardViewViewHolder, int i) {

        Wisata p = getListWisata().get(i);
        cardViewViewHolder.tampil(p, onClick);

    }

    @Override
    public int getItemCount() {
        return getListWisata().size();
    }

    public ArrayList<Wisata> getListWisata() {
        return listWisata;
    }

    public void setListWisata(ArrayList<Wisata> listWisata) {
        this.listWisata = listWisata;
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFoto;
        TextView tvNama, tvDetail;
        Button btnShare;
        CardView btnDetail;
        Wisata wisata;


        public CardViewViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.img_view);
            tvNama = (TextView) itemView.findViewById(R.id.txt_nama);
            btnDetail = (CardView) itemView.findViewById(R.id.btn_detail);

        }

        public void tampil(final Wisata wisata, final ListWisataAdapter.OnClick OnItemClick) {

            Glide.with(context)
                    .load(wisata.getFoto())

                    .into(imgFoto);

            tvNama.setText(wisata.getNama());

            btnDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OnItemClick.onClick(wisata);

                }
            });

        }
    }

    public interface OnClick {
        void onClick(Object wisata);
    }
}
