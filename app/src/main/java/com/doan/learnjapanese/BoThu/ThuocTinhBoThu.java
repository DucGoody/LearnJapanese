package com.doan.learnjapanese.BoThu;



public class ThuocTinhBoThu {
    private  int id;
    private String tuNhat;
    private String nghia;
    private String nghiaViet;
    private int IDminna;
    private int bo;

    public ThuocTinhBoThu(int id, String tuNhat, String nghia, String nghiaViet, int IDminna, int bo) {
        this.id = id;
        this.tuNhat = tuNhat;
        this.nghia = nghia;
        this.nghiaViet = nghiaViet;
        this.IDminna = IDminna;
        this.bo = bo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTuNhat() {
        return tuNhat;
    }

    public void setTuNhat(String tuNhat) {
        this.tuNhat = tuNhat;
    }

    public String getNghia() {
        return nghia;
    }

    public void setNghia(String nghia) {
        this.nghia = nghia;
    }

    public String getNghiaViet() {
        return nghiaViet;
    }

    public void setNghiaViet(String nghiaViet) {
        this.nghiaViet = nghiaViet;
    }

    public int getIDminna() {
        return IDminna;
    }

    public void setIDminna(int IDminna) {
        this.IDminna = IDminna;
    }

    public int getBo() {
        return bo;
    }

    public void setBo(int bo) {
        this.bo = bo;
    }
}
