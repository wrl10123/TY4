package com.sc.ty4.Controller.Activity;


public class User {
    private String name;
    private String icon;
    private String img;
    private String imgName;
    private String guanzhu;
    private String dianzan;
    private String pinglun;
    private String zhuanfa;

    public User() {
    }
    public User(String name, String icon, String img, String imgName, String guanzhu, String dianzan, String pinglun, String zhuanfa) {
        this.name = name;
        this.icon = icon;
        this.img = img;
        this.imgName = imgName;
        this.guanzhu = guanzhu;
        this.dianzan = dianzan;
        this.pinglun = pinglun;
        this.zhuanfa = zhuanfa;
    }
    public String getName() {
        return name;
    }
    public String getIcon() {
        return icon;
    }
    public String getImg() {
        return img;
    }
    public String getImgName() {
        return imgName;
    }
    public String getGuanzhu() {
        return guanzhu;
    }
    public String getDianzan() {
        return dianzan;
    }
    public String getPinglun() {
        return pinglun;
    }
    public String getZhuanfa() {
        return zhuanfa;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public void setGuanzhu(String guanzhu) {
        this.guanzhu = guanzhu;
    }

    public void setDianzan(String dianzan) {
        this.dianzan = dianzan;
    }

    public void setPinglun(String pinglun) {
        this.pinglun = pinglun;
    }

    public void setZhuanfa(String zhuanfa) {
        this.zhuanfa = zhuanfa;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", img='" + img + '\'' +
                ", imgName='" + imgName + '\'' +
                ", guanzhu='" + guanzhu + '\'' +
                ", dianzan='" + dianzan + '\'' +
                ", pinglun='" + pinglun + '\'' +
                ", zhuanfa='" + zhuanfa + '\'' +
                '}';
    }
}
