package sch.id.smkn1bangsri.jeparaadventure;

import android.os.Parcel;
import android.os.Parcelable;

public class Budaya implements Parcelable {
    private String nama, alamatlok, foto, detail2, lokasi;

    protected Budaya(Parcel in) {
        nama = in.readString();
        alamatlok = in.readString();
        foto = in.readString();
        detail2 = in.readString();
        lokasi = in.readString();

    }

    public static final Parcelable.Creator<Budaya> CREATOR = new Parcelable.Creator<Budaya>() {
        @Override
        public Budaya createFromParcel(Parcel in) {
            return new Budaya(in);
        }

        @Override
        public Budaya[] newArray(int size) {
            return new Budaya[size];
        }
    };

    public Budaya() {

    }

    public String getNama() {

        return nama;
    }

    public void setName(String nama) {
        this.nama = nama;
    }

    public String getAlamatlok() {
        return alamatlok;
    }

    public void setAlamatlok(String alamatlok) {
        this.alamatlok = alamatlok;
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

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.nama);
        parcel.writeString(this.alamatlok);
        parcel.writeString(this.foto);
        parcel.writeString(this.detail2);
        parcel.writeString(this.lokasi);

    }
}
