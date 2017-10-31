package com.doan.learnjapanese.BaiMinna;



public class ThuocTinhHoiThoai {
    // lớp đối tượng ThuocTinhHoiThoai gồm các thuộc tính
    private int id;
    private String nguoi;
    private String cauNhat;
    private String cauViet;
    private int bai;
    private int IDminna;

    // phương thức khởi tạo gồm các thuộc tính của đối tượng ThuocTinhHoiThoai
    public ThuocTinhHoiThoai(int id, String nguoi, String cauNhat, String cauViet, int bai, int IDminna) {
        this.id = id;
        this.nguoi = nguoi;
        this.cauNhat = cauNhat;
        this.cauViet = cauViet;
        this.bai = bai;
        this.IDminna = IDminna;
    }
    // phương thức
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNguoi() {
        return nguoi;
    }

    public void setNguoi(String nguoi) {
        this.nguoi = nguoi;
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

