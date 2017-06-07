package com.steto.jaurlib;

import com.steto.jaurlib.modbus.MB_Struct;

import java.nio.ByteOrder;

/**
 * Created by sbrega on 10/12/2014.
 */


public class LongBigEndianStruct extends MB_Struct {

    public Unsigned32 val ;

    public LongBigEndianStruct(long aLong) {
        this();
        this.val.set(aLong);
    }


    public LongBigEndianStruct() {
        val= new Unsigned32();

    }

    // sembra che i valori misurati dall'inverter siano in BIG_ENDIAN a differenza del CRC
    @Override
    public ByteOrder byteOrder() {
        return ByteOrder.BIG_ENDIAN;
    }
}