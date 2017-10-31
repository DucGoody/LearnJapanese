package com.doan.learnjapanese.TuKanji;


public class ThuocTinhTuKanji {
    private int ID, loai,IDmuc;
    private String amHan, tuKanji;
    private String nghia;
    private String Onoymi, Kunyomi;
    private String viDuNhat, viDu2, ChuThich;
    private String viDuViet;

    public ThuocTinhTuKanji(int id, String kanji, String amhan, String nghia2, String onoymi, String kunyomi, String vidunhat, String viduviet, String chuthich, int loai2, String vd2,int IDmuc2) {
        ID = id;
        tuKanji = kanji;
        amHan = amhan;
        nghia = nghia2;
        Onoymi = onoymi;
        Kunyomi = kunyomi;
        viDuNhat = vidunhat;
        viDuViet = viduviet;
        ChuThich = chuthich;
        loai = loai2;
        viDu2 = vd2;
        IDmuc=IDmuc2;
    }

    public int getIDmuc() {
        return IDmuc;
    }

    public void setIDmuc(int IDmuc) {
        this.IDmuc = IDmuc;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }

    public String getAmHan() {
        return amHan;
    }

    public void setAmHan(String amHan) {
        this.amHan = amHan;
    }

    public String getTuKanji() {
        return tuKanji;
    }

    public void setTuKanji(String tuKanji) {
        this.tuKanji = tuKanji;
    }

    public String getNghia() {
        return nghia;
    }

    public void setNghia(String nghia) {
        this.nghia = nghia;
    }

    public String getOnoymi() {
        return Onoymi;
    }

    public void setOnoymi(String onoymi) {
        Onoymi = onoymi;
    }

    public String getKunyomi() {
        return Kunyomi;
    }

    public void setKunyomi(String kunyomi) {
        Kunyomi = kunyomi;
    }

    public String getViDuNhat() {
        return viDuNhat;
    }

    public void setViDuNhat(String viDuNhat) {
        this.viDuNhat = viDuNhat;
    }

    public String getViDu2() {
        return viDu2;
    }

    public void setViDu2(String viDu2) {
        this.viDu2 = viDu2;
    }

    public String getChuThich() {
        return ChuThich;
    }

    public void setChuThich(String chuThich) {
        ChuThich = chuThich;
    }

    public String getViDuViet() {
        return viDuViet;
    }

    public void setViDuViet(String viDuViet) {
        this.viDuViet = viDuViet;
    }
}
