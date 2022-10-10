/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.io.Serializable;

/**
 *
 * @author HP
 */
public class imgList {
    private int id;
    private String EN, Pro, VN, date;
    private byte[] img;

    public imgList() {
    }

    public imgList(int id, String EN, String Pro, String VN, byte[] img, String date) {
        this.id = id;
        this.EN = EN;
        this.Pro = Pro;
        this.VN = VN;
        this.img = img;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEN() {
        return EN;
    }

    public void setEN(String EN) {
        this.EN = EN;
    }

    public String getPro() {
        return Pro;
    }

    public void setPro(String Pro) {
        this.Pro = Pro;
    }

    public String getVN() {
        return VN;
    }

    public void setVN(String VN) {
        this.VN = VN;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }


}
