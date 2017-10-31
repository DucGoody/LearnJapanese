package com.doan.learnjapanese.BangChuCai;


public class ThuocTinhBangChuCai {
    private int id,IDmuc;
    private String tuNhat, tuViet, chuThich, loai, colum, nghia,kata;

    public ThuocTinhBangChuCai(int id, String tuNhat, String tuViet, String chuThich, String loai, String colum, String nghia,int IDmuc,String kata) {
        this.tuNhat = tuNhat;
        this.tuViet = tuViet;
        this.chuThich = chuThich;
        this.loai = loai;
        this.id = id;
        this.colum = colum;
        this.nghia = nghia;
        this.IDmuc=IDmuc;
        this.kata=kata;
    }

    public String getKata() {
        return this.kata;
    }

    public void setKata(String kata) {
        this.kata = kata;
    }

    public int getIDmuc() {
        return IDmuc;
    }

    public void setIDmuc(int IDmuc) {
        this.IDmuc = IDmuc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColum() {
        return colum;
    }

    public void setColum(String colum) {
        this.colum = colum;
    }

    public String getNghia() {
        return nghia;
    }

    public void setNghia(String nghia) {
        this.nghia = nghia;
    }

    public String getTuNhat() {
        return tuNhat;
    }

    public void setTuNhat(String tuNhat) {
        this.tuNhat = tuNhat;
    }

    public String getTuViet() {
        return tuViet;
    }

    public void setTuViet(String tuViet) {
        this.tuViet = tuViet;
    }



    public String getChuThich() {
        return chuThich;
    }

    public void setChuThich(String chuThich) {
        this.chuThich = chuThich;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
}
