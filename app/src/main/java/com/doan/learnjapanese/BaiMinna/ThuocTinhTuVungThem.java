package com.doan.learnjapanese.BaiMinna;



public class ThuocTinhTuVungThem {
    private int id;
    private String tuNhat;
    private String tuViet;
    private int bai;

    public ThuocTinhTuVungThem(int id, String tuNhat, String tuViet, int bai) {
        this.id = id;
        this.tuNhat = tuNhat;
        this.tuViet = tuViet;
        this.bai = bai;
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

    public String getTuViet() {
        return tuViet;
    }

    public void setTuViet(String tuViet) {
        this.tuViet = tuViet;
    }

    public int getBai() {
        return bai;
    }

    public void setBai(int bai) {
        this.bai = bai;
    }
}
