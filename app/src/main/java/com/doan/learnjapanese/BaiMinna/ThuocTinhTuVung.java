package com.doan.learnjapanese.BaiMinna;



public class ThuocTinhTuVung {
    private  int id;
    private String amNhat;
    private String hanTu;
    private String amViet;
    private int bai,IDminna;

    public ThuocTinhTuVung(int id, String amNhat, String hanTu, String amViet, int bai,int IDminna) {
        this.id = id;
        this.amNhat = amNhat;
        this.amViet = amViet;
        this.hanTu = hanTu;
        this.bai = bai;
        this.IDminna=IDminna;
    }

    public int getIDminna() {
        return IDminna;
    }

    public void setIDminna(int IDminna) {
        this.IDminna = IDminna;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAmNhat() {
        return amNhat;
    }

    public void setAmNhat(String amNhat) {
        this.amNhat = amNhat;
    }

    public String getAmViet() {
        return amViet;
    }

    public void setAmViet(String amViet) {
        this.amViet = amViet;
    }

    public String getHanTu() {
        return hanTu;
    }

    public void setHanTu(String hanTu) {
        this.hanTu = hanTu;
    }


    public int getBai() {
        return bai;
    }

    public void setBai(int bai) {
        this.bai = bai;
    }
}
