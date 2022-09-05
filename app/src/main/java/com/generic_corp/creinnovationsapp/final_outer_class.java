package com.generic_corp.creinnovationsapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class final_outer_class {

    @SerializedName("data")
    @Expose
    private List<model_for_outer_data> data = null;
    public  List<model_for_outer_data> getData(){
        return data;
    }
    public void setData(List<model_for_outer_data> data){
        this.data = data;
    }
}
