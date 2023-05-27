package com.example.virusmap.Domain;
//实体层，用于存放我们的实体类，与数据库中的属性值基本保持一致，实现set和get的方法。
public class datastr {
    private Integer id;
    private String location;
    private Integer dia;
    private Integer res;
    private Integer de;

    public Integer getNowdia() {
        return nowdia;
    }

    public void setNowdia(Integer nowdia) {
        this.nowdia = nowdia;
    }

    private Integer nowdia;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Integer getRes() {
        return res;
    }

    public void setRes(Integer res) {
        this.res = res;
    }

    public Integer getDe() {
        return de;
    }

    public void setDe(Integer de) {
        this.de = de;
    }
}
