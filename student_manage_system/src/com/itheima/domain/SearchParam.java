package com.itheima.domain;

public class SearchParam {
    private String searchAge01;
    private String searchAge02;
    private String searchName ;

    @Override
    public String toString() {
        return "SearchParam{" +
                "searchAge01='" + searchAge01 + '\'' +
                ", searchAge02='" + searchAge02 + '\'' +
                ", searchName='" + searchName + '\'' +
                '}';
    }

    public String getSearchAge01() {
        return searchAge01;
    }

    public void setSearchAge01(String searchAge01) {
        this.searchAge01 = searchAge01;
    }

    public String getSearchAge02() {
        return searchAge02;
    }

    public void setSearchAge02(String searchAge02) {
        this.searchAge02 = searchAge02;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public SearchParam() {
    }

    public SearchParam(String searchAge01, String searchAge02, String searchName) {
        this.searchAge01 = searchAge01;
        this.searchAge02 = searchAge02;
        this.searchName = searchName;
    }
}
