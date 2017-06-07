package com.steto.jaurlib.modbus;

import javolution.io.Struct;

/**
 * Created by stefano on 22/11/14.
 */
public class MB_code extends MB_Struct {

    public Struct.Unsigned8 val = new Struct.Unsigned8();

    public MB_code(int value) {

        val.set((short) value);
    }


    public MB_code() {
        this(0);
    }

    public Integer getValue() {
        return (int) val.get();
    }
}
