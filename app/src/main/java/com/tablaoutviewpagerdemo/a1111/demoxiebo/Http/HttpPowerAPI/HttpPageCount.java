package com.tablaoutviewpagerdemo.a1111.demoxiebo.Http.HttpPowerAPI;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by a1111 on 17/11/13.
 */

public class HttpPageCount<T> {
    @SerializedName("pages")
    private String pages;
    @SerializedName("total")
    private String total;
    @SerializedName("list")
    public List<T> list;

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }


}
