package com.steto.jaurlib.response;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by stefano on 29/11/14.
 */
public enum AI_Type {

    Wind_Version('W'),
    Photovoltaic_Version('N'),
    Dummy_inverter_type('X');

    final char value;

    public char get() {
        return value;
    }


    AI_Type(char val) {
        value=val;
    }

    private static Map mapVal2Enum = createMap();

    private static Map createMap() {

        Map result = new HashMap();
        for (AI_Type e : values())
        {
            result.put(e.get(), e);
        }
        return Collections.unmodifiableMap(result);
    }


    public static AI_Type fromCode(char code) {

        return (AI_Type) mapVal2Enum.get(code);
    }

}
