package com.steto.jaurlib.response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by sbrega on 10/12/2014.
 */
public class AResp_TimeCounter extends AuroraResponse {
    public void set(long timeCounter) {

        setLongParam(timeCounter);
    }

    public Long get() {
        Long result = null;
        try {
            result = getLongParam();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String toString() {
        return description.isEmpty() ? super.toString() : description + ": "+String.valueOf(TimeUnit.MILLISECONDS.toDays(get() * 1000));
    }

    @Override
    public String getValue() {
        return String.valueOf(get());
    }
}
