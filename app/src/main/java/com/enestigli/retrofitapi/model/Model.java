package com.enestigli.retrofitapi.model;

import com.google.gson.annotations.SerializedName;

public class Model {
    @SerializedName("ad")
    public String ad;

    @SerializedName("id")
    public int id;

    @SerializedName("soyad")
    public String soyad;

    @SerializedName("personelNo")
    public String personelNo;

    @SerializedName("yaptığı_iş")
    public String yaptigi_is;
}
