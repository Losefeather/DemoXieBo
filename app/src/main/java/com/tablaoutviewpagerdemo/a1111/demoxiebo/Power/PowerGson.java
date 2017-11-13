package com.tablaoutviewpagerdemo.a1111.demoxiebo.Power;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.tablaoutviewpagerdemo.a1111.demoxiebo.Http.HttpPowerAPI.PowerResultEntity;
/**
 * Created by a1111 on 17/11/13.
 */

public class PowerGson{
    public PowerGson(){

    }
    public <T> void parseGson(String resulte,ArrayList<T> tArrayList){
        Gson gson = new Gson();
        Type type = new TypeToken<PowerResultEntity<List<T>>>(){}.getType();
        PowerResultEntity<List<T>> baseInfo=gson.fromJson(resulte,type);

        if(baseInfo.getData().size()>0) {
            for (int i = 0; i < baseInfo.getData().size(); i++) {
                tArrayList.add(baseInfo.getData().get(i));
            }
        }
    }
}
