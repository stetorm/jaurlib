package com.steto.jaurlib.modbus;

/**
 * Created by stefano on 26/11/14.
 */
public class MB_address extends MB_Struct {
    Unsigned8 val = new Unsigned8();

    public MB_address(int i) {
         val.set((short) i);
    }
}
