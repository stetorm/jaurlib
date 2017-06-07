package com.steto.jaurlib.response;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by stefano on 29/11/14.
 */
public enum AI_NationEnum {

    USA_UL1741('A'),
    Germany_VDE0126('E'),
    Spain_DR_1663_2000('S'),
    Italy_ENEL_DK_5950('I'),
    UK_UK_G83('U'),
    Australia_AS_4777('K'),
    France_VDE_French_Model('F');


    final char value;

    AI_NationEnum(char val) {
        value=val;
    }

    private static Map mapVal2Enum = createMap();

    private static Map createMap() {

        Map result = new HashMap();
        for (AI_NationEnum e : values())
        {
            result.put(e.get(), e);
        }
        return Collections.unmodifiableMap(result);
    }


    public char get() {
        return value;
    }

    public static AI_NationEnum fromCode(char code) {

        return (AI_NationEnum) mapVal2Enum.get(code);
    }

}


