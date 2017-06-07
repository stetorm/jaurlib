package com.steto.jaurlib.response;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by stefano on 29/11/14.
 */
public enum AI_TransformerType {


    Transformer_Version('T'),
    Transformerless_Version('N'),
    Transformer_HF_version('t'),
    Dummy_transformer_type('X') ;


    final char value;

    public char get() {
        return value;
    }


    AI_TransformerType(char val) {
        value=val;
    }

    private static Map mapVal2Enum = createMap();

    private static Map createMap() {

        Map result = new HashMap();
        for (AI_TransformerType e : values())
        {
            result.put(e.get(), e);
        }
        return Collections.unmodifiableMap(result);
    }


    public static AI_TransformerType fromCode(char code) {

        return (AI_TransformerType) mapVal2Enum.get(code);
    }

}


