package com.steto.jaurlib.eventbus;

import com.google.gson.Gson;

/**
 * Created by stefano on 26/12/15.
 */
public abstract class EBResponse
{

    public String toJson()
    {

       return new Gson().toJson(this)  ;

    }

    @Override
    public String toString() {
        return  toJson();
    }
}