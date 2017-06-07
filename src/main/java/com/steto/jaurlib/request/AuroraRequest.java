package com.steto.jaurlib.request;

import com.steto.jaurlib.modbus.MB_PDU;
import com.steto.jaurlib.modbus.MB_code;
import com.steto.jaurlib.modbus.MB_data;
import com.steto.jaurlib.response.AuroraResponseBuilder;
import com.steto.jaurlib.response.AuroraResponse;
import javolution.io.Struct;

/**
 * Created by stefano on 22/11/14.
 */
public abstract class AuroraRequest extends MB_PDU {



    public abstract AuroraResponse create(AuroraResponseBuilder builder) ;

    class _Data extends MB_data
    {
        Unsigned8[] bytes = array(new Struct.Unsigned8[6]);

    }

    public AuroraRequest(MB_code code) {
        this.code = code;
        this.data = new _Data();
    }


    public void setParam1(char val)
    {
        ((_Data)data).bytes[0].set((short) val);
    }

    public short getParam1()
    {
        return ((_Data)data).bytes[0].get();
    }



}
