package com.steto.jaurlib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

/**
 * Created by stefano on 07/12/14.
 */
public class MyFormatter extends SimpleFormatter {
    @Override
    public synchronized String format(LogRecord record) {
        Date date = new Date(record.getMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("y.M.d HH:mm:ss.SSS");

        String str = simpleDateFormat.format(date);
        StringBuilder builder = new StringBuilder();
        builder.append(str).append(" ")
                .append(record.getThreadID()).append(" ")
                .append(record.getLevel()).append(" ")
                .append(record.getSourceClassName()).append(" ")
                .append(record.getSourceMethodName()).append(" \"")
                .append(record.getMessage()).append("\"\n");
        return builder.toString();
    }
}