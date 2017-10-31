package com.doan.learnjapanese.BaiMinna;



public class ThuocTinhHoiThoaiMau {
    private int id;
    private String cauNhat;
    private String cauViet;
    private int bai;
    private int IDminna;

    public ThuocTinhHoiThoaiMau(int id, String cauNhat, String cauViet, int bai, int IDminna) {
        this.id = id;
        this.cauNhat = cauNhat;
        this.cauViet = cauViet;
        this.bai = bai;
        this.IDminna = IDminna;
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


    public int getBai() {
        return bai;
    }

    public void setBai(int bai) {
        this.bai = bai;
    }

    public int getIDminna() {
        return IDminna;
    }

    public void setIDminna(int IDminna) {
        this.IDminna = IDminna;
    }
}
