package sch.id.smkn1bangsri.jeparaadventure;

import android.os.Parcel;
import android.os.Parcelable;

public class Wisata implements Parcelable {
    private String nama, detail, foto, detail2, htm, alamat, lokasi, infolain;

    protected Wisata(Parcel in) {
        nama = in.readString();
        detail = in.readString();
        foto = in.readString();
        detail2 = in.readString();
        htm = in.readString();
        alamat = in.readString();
        lokasi = in.readString();
        infolain = in.readString();

    }

    public static final Parcelable.Creator<Wisata> CREATOR = new Parcelable.Creator<Wisata>() {
        @Override
        public Wisata createFromParcel(Parcel in) {
            return new Wisata(in);
        }

        @Override
        public Wisata[] newArray(int size) {
            return new Wisata[size];
        }
    };

    public Wisata() {

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

    public String getHtm() {
        return htm;
    }

    public void setHtm(String htm) {
        this.htm= htm;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat= alamat;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi= lokasi;
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
        parcel.writeString(this.htm);
        parcel.writeString(this.alamat);
        parcel.writeString(this.lokasi);
        parcel.writeString(this.infolain);
    }
}
