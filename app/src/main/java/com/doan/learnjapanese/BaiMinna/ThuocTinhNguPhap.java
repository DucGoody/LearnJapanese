package com.doan.learnjapanese.BaiMinna;


public class ThuocTinhNguPhap {
    private int id;
    private String tieuDe;
    private String noiDung;
    private String tieuDeChiTiet;
    private String viDuChiTiet;
    private String chuY;
    private String tieuDeMoRong;
    private String chuThichMoRong;
    private String viDuMoRong;
    private int bai;
    private int IDMinna;

    public ThuocTinhNguPhap(int id, String tieuDe, String noiDung, String tieuDeChiTiet, String viDuChiTiet, String chuY, String tieuDeMoRong, String chuThichMoRong, String viDuMoRong, int bai, int IDMinna) {
        this.id = id;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.tieuDeChiTiet = tieuDeChiTiet;
        this.viDuChiTiet = viDuChiTiet;
        this.chuY = chuY;
        this.tieuDeMoRong = tieuDeMoRong;
        this.chuThichMoRong = chuThichMoRong;
        this.viDuMoRong = viDuMoRong;
        this.bai = bai;
        this.IDMinna = IDMinna;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getTieuDeChiTiet() {
        return tieuDeChiTiet;
    }

    public void setTieuDeChiTiet(String tieuDeChiTiet) {
        this.tieuDeChiTiet = tieuDeChiTiet;
    }

    public String getViDuChiTiet() {
        return viDuChiTiet;
    }

    public void setViDuChiTiet(String viDuChiTiet) {
        this.viDuChiTiet = viDuChiTiet;
    }

    public String getChuY() {
        return chuY;
    }

    public void setChuY(String chuY) {
        this.chuY = chuY;
    }

    public String getTieuDeMoRong() {
        return tieuDeMoRong;
    }

    public void setTieuDeMoRong(String tieuDeMoRong) {
        this.tieuDeMoRong = tieuDeMoRong;
    }

    public String getChuThichMoRong() {
        return chuThichMoRong;
    }

    public void setChuThichMoRong(String chuThichMoRong) {
        this.chuThichMoRong = chuThichMoRong;
    }

    public String getViDuMoRong() {
        return viDuMoRong;
    }

    public void setViDuMoRong(String viDuMoRong) {
        this.viDuMoRong = viDuMoRong;
    }

    public int getBai() {
        return bai;
    }

    public void setBai(int bai) {
        this.bai = bai;
    }

    public int getIDMinna() {
        return IDMinna;
    }

    public void setIDMinna(int IDMinna) {
        this.IDMinna = IDMinna;
    }
}
