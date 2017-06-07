package com.steto.jaurlib.modbus;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by stefano on 22/11/14.
 */
public abstract class PDUFactory {




    protected abstract MB_PDU create(MB_code code) ;



    public MB_PDU read(InputStream inputStream) throws IOException {


        final MB_code code = new MB_code();
        code.read(inputStream);


        MB_PDU request = create(code);
        if (request==null)
        {
            throw new IOException("No PDU found for code: "+code.getValue());
        }
        request.data.read(inputStream);
        return  request;
    }


}
