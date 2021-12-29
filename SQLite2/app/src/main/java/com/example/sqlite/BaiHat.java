package com.example.sqlite;

public class BaiHat {

    String maBH;
    String teBH,casi,theLoai;

    public BaiHat(String maBH, String teBH, String casi, String theLoai) {
        this.maBH = maBH;
        this.teBH = teBH;
        this.casi = casi;
        this.theLoai = theLoai;
    }

    public BaiHat() {


    }

    public String getMaBH() {
        return maBH;
    }

    public void setMaBH(String maBH) {
        this.maBH = maBH;
    }

    public String getTeBH() {
        return teBH;
    }

    public void setTeBH(String teBH) {
        this.teBH = teBH;
    }

    public String getCasi() {
        return casi;
    }

    public void setCasi(String casi) {
        this.casi = casi;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }
}
