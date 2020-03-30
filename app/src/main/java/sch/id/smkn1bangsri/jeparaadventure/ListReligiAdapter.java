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

public class ListReligiAdapter extends RecyclerView.Adapter<ListReligiAdapter.CardViewViewHolder> {

    private Context context;
    private ArrayList<Religi> listReligi;
    private ListReligiAdapter.OnClick onClick;
    private CardView cardView;

    public ListReligiAdapter(Context context, ListReligiAdapter.OnClick onClick) {
        this.context = context;
        this.onClick = onClick;
    }


    @NonNull
    @Override
    public ListReligiAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_religi, viewGroup, false);
        ListReligiAdapter.CardViewViewHolder viewHolder = new ListReligiAdapter.CardViewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListReligiAdapter.CardViewViewHolder cardViewViewHolder, int i) {

        Religi p = getListReligi().get(i);
        cardViewViewHolder.tampil(p, onClick);

    }

    @Override
    public int getItemCount() {
        return getListReligi().size();
    }

    public ArrayList<Religi> getListReligi() {
        return listReligi;
    }

    public void setListReligi(ArrayList<Religi> listReligi) {
        this.listReligi= listReligi;
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFoto;
        TextView tvNama, tvDetail;
        Button btnShare;
        CardView btnDetail;
        Religi religi;


        public CardViewViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.img_view);
            tvNama = (TextView) itemView.findViewById(R.id.txt_nama);
            btnDetail = (CardView) itemView.findViewById(R.id.btn_detail);

        }

        public void tampil(final Religi religi, final ListReligiAdapter.OnClick OnItemClick) {

            Glide.with(context)
                    .load(religi.getFoto())

                    .into(imgFoto);

            tvNama.setText(religi.getNama());

            btnDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OnItemClick.onClick(religi);

                }
            });

        }
    }

    public interface OnClick {
        void onClick(Object religi);
    }
}
