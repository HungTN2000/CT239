/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manegement.classData;

/**
 *
 * @author HP
 */
public class listBKT {
    private String maBKT, maND, tenCapDo, tenChuDe;
    private float Diem;

    public listBKT() {
    }

    public listBKT(String maBKT, String maND, String tenCapDo, String tenChuDe, float Diem) {
        this.maBKT = maBKT;
        this.maND = maND;
        this.tenCapDo = tenCapDo;
        this.tenChuDe = tenChuDe;
        this.Diem = Diem;
    }

    public String getMaBKT() {
        return maBKT;
    }

    public void setMaBKT(String maBKT) {
        this.maBKT = maBKT;
    }

    public String getMaND() {
        return maND;
    }

    public void setMaND(String maND) {
        this.maND = maND;
    }

    public String getTenCapDo() {
        return tenCapDo;
    }

    public void setTenCapDo(String tenCapDo) {
        this.tenCapDo = tenCapDo;
    }

    public String getTenChuDe() {
        return tenChuDe;
    }

    public void setTenChuDe(String tenChuDe) {
        this.tenChuDe = tenChuDe;
    }

    public float getDiem() {
        return Diem;
    }

    public void setDiem(float Diem) {
        this.Diem = Diem;
    }
    
    
}
