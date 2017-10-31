package com.doan.learnjapanese.MauCauGiaoTiep;



public class ThuocTinhCauGiaoTiep {
    private int id;
    private String cauNhat;
    private String cauViet;
    private String loai;
    private int IDmuc;

    public ThuocTinhCauGiaoTiep(int id, String cauNhat, String cauViet,String loai,int IDmuc) {
        this.id = id;
        this.cauNhat = cauNhat;
        this.cauViet = cauViet;
        this.loai=loai;
        this.IDmuc=IDmuc;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
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

    public String getCauNhat() {
        return cauNhat;
    }

    public void setCauNhat(String cauNhat) {
        this.cauNhat = cauNhat;
    }

    public String getCauViet() {
        return cauViet;
    }

    public void setCauViet(String cauViet) {
        this.cauViet = cauViet;
    }

}
