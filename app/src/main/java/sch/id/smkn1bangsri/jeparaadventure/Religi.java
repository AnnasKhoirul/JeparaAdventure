package sch.id.smkn1bangsri.jeparaadventure;

import android.os.Parcel;
import android.os.Parcelable;

public class Religi implements Parcelable {
    private String nama, foto, detail2, infolain;

    protected Religi(Parcel in) {
        nama = in.readString();
        foto = in.readString();
        detail2 = in.readString();
        infolain = in.readString();

    }

    public static final Parcelable.Creator<Religi> CREATOR = new Parcelable.Creator<Religi>() {
        @Override
        public Religi createFromParcel(Parcel in) {
            return new Religi(in);
        }

        @Override
        public Religi[] newArray(int size) {
            return new Religi[size];
        }
    };

    public Religi() {

    }


    public String getNama() {

        return nama;
    }

    public void setName(String nama) {
        this.nama = nama;
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
        parcel.writeString(this.foto);
        parcel.writeString(this.detail2);
        parcel.writeString(this.infolain);


    }
}