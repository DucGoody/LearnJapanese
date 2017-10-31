package com.doan.learnjapanese.LuyenThi;


public class ThuocTinhLuyenThi {
    private int id, bai,IDmuc;
    private String cauHoi, DA1, DA2, DA3, DA4, DAD;

    public ThuocTinhLuyenThi(int id, String cauHoi, String DA1, String DA2, String DA3, String DA4, int bai, String DAD,int IDmuc) {
        this.id = id;
        this.cauHoi = cauHoi;
        this.DA1 = DA1;
        this.DA2 = DA2;
        this.DA3 = DA3;
        this.DA4 = DA4;
        this.DAD = DAD;
        this.bai = bai;
        this.IDmuc=IDmuc;
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

    public String getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(String cauHoi) {
        this.cauHoi = cauHoi;
    }

    public String getDA1() {
        return DA1;
    }

    public void setDA1(String DA1) {
        this.DA1 = DA1;
    }

    public String getDA2() {
        return DA2;
    }

    public void setDA2(String DA2) {
        this.DA2 = DA2;
    }

    public String getDA3() {
        return DA3;
    }

    public void setDA3(String DA3) {
        this.DA3 = DA3;
    }

    public String getDA4() {
        return DA4;
    }

    public void setDA4(String DA4) {
        this.DA4 = DA4;
    }

    public String getDAD() {
        return DAD;
    }

    public void setDAD(String DAD) {
        this.DAD = DAD;
    }

    public int getBai() {
        return bai;
    }

    public void setBai(int bai) {
        this.bai = bai;
    }
}
