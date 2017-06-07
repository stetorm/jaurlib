package com.steto.jaurlib.modbus;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by stefano on 22/11/14.
 */
public class MB_PDU extends MB_Struct {

    public MB_code code;
    public MB_data data;


    public MB_PDU() {


    }

    protected void setCode(MB_code c) {
        code = c;
    }

    public int read(InputStream inputStream) throws IOException {

        int nbytes = code.read(inputStream);
        nbytes += data.read(inputStream);
        return nbytes;
    }

    public void write(OutputStream output) throws IOException {
        code.write(output);
        data.write(output);
    }


    @Override
    public String toString() {
        return getClass().getSimpleName()+"{" +
                "code=" + code +
                ", data=" + data +
                '}';
    }
}
