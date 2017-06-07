package com.steto.jaurlib.response;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sbrega on 27/11/2014.
 */


public enum ResponseErrorEnum {

    NONE(0),
    CRC(1),
    TIMEOUT(2), UNKNOWN(3);

    final int value;

    ResponseErrorEnum(int val) {
        value = val;
    }

    private static Map mapVal2Enum = createMap();

    private static Map createMap() {

        Map result = new HashMap();
        for (ResponseErrorEnum e : values()) {
            result.put(e.get(), e);
        }
        return Collections.unmodifiableMap(result);
    }


    public final int get() {
        return value;
    }

    public static ResponseErrorEnum fromCode(Integer code) {
        return (ResponseErrorEnum) mapVal2Enum.get(code);
    }
}
