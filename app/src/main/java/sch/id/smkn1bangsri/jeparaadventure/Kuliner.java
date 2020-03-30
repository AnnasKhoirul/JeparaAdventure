package sch.id.smkn1bangsri.jeparaadventure;

import android.os.Parcel;
import android.os.Parcelable;

public class Kuliner implements Parcelable {
    private String nama, detail, foto, detail2, infolain;

    protected Kuliner(Parcel in) {
        nama = in.readString();
        detail = in.readString();
        foto = in.readString();
        detail2 = in.readString();
        infolain = in.readString();

    }

    public static final Parcelable.Creator<Kuliner> CREATOR = new Parcelable.Creator<Kuliner>() {
        @Override
        public Kuliner createFromParcel(Parcel in) {
            return new Kuliner(in);
        }

        @Override
        public Kuliner[] newArray(int size) {
            return new Kuliner[size];
        }
    };

    public Kuliner() {

    }

    public String getNama() {

        return nama;
    }

    public void setName(String nama) {
        this.nama = nama;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDetail2() {
        return detail2;
    }

    public void setDetail2(String detail2) {
        this.detail2 = detail2;
    }

    public String getInfolain() {
        return infolain;
    }

    public void setInfolain(String infolain) {
        this.infolain= infolain;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.nama);
        parcel.writeString(this.detail);
        parcel.writeString(this.foto);
        parcel.writeString(this.detail2);
        parcel.writeString(this.infolain);


    }
}