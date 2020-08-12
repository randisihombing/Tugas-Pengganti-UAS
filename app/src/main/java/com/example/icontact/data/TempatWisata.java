package com.example.icontact.data;

import android.os.Parcel;
import android.os.Parcelable;

public class TempatWisata implements Parcelable {

    public TempatWisata(String nama, String alamat, double latitude, double longitude) {
        this.nama = nama;
        this.alamat = alamat;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    private String link;

    private String nama;

    private String alamat;

    private double latitude;

    private double longitude;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    protected TempatWisata(Parcel in) {
        this.nama = in.readString();
        this.alamat = in.readString();
        this.link = in.readString();
        this.latitude = in.readDouble();
        this.longitude = in.readDouble();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(alamat);
        dest.writeString(link);
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
    }

    public static final Parcelable.Creator<TempatWisata> CREATOR = new Parcelable.Creator<TempatWisata>() {
        @Override
        public TempatWisata createFromParcel(Parcel in) {
            return new TempatWisata(in);
        }

        @Override
        public TempatWisata[] newArray(int size) {
            return new TempatWisata[size];
        }
    };
}
