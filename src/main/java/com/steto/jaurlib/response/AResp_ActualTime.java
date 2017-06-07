package com.steto.jaurlib.response;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sbrega on 11/12/2014.
 */
public class AResp_ActualTime extends AuroraResponse {
    static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    static long msecBase = 0;

    @Override
    public String getValue() {
        return Long.toString(get());
    }

    public AResp_ActualTime() {
        super();
        try {
            msecBase = (long) ((DATE_FORMAT.parse("01/01/2000").getTime())/1000.0);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public void set(long time) {

        setLongParam(time);
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

    public Date getDate() {
        Date result = new Date(get() * 1000 + msecBase*1000);
        return result;
    }

    @Override
    public String toString() {
        long msecNow = (long) (new Date().getTime() / 1000.0);
        return description.isEmpty() ? super.toString() : description + ": " + getDate() + ", difference (msec): " + (msecNow - get()-msecBase);
    }


}
