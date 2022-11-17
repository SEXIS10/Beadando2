package com.projekt.beadando.Classes;

import java.sql.Date;

public class MemberShip
{
    private int id;
    private int mnumber;
    private int userid;
    private Date expiriy;

    public MemberShip(int mnumber, int userid, Date expiriy) {
        this.mnumber = mnumber;
        this.userid = userid;
        this.expiriy = expiriy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMnumber() {
        return mnumber;
    }

    public void setMnumber(int mnumber) {
        this.mnumber = mnumber;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Date getExpiriy() {
        return expiriy;
    }

    public void setExpiriy(Date expiriy) {
        this.expiriy = expiriy;
    }

    public MemberShip(int id, int mnumber, int userid, Date expiriy) {
        this.id = id;
        this.mnumber = mnumber;
        this.userid = userid;
        this.expiriy = expiriy;
    }
}
