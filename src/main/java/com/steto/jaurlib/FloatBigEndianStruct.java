package com.steto.jaurlib;

import com.steto.jaurlib.modbus.MB_Struct;
import javolution.io.Struct;

import java.nio.ByteOrder;

/**
 * Created by stefano on 06/12/14.
 */
public class FloatBigEndianStruct extends MB_Struct {

    public Struct.Float32 val ;

    public FloatBigEndianStruct(float aFloat) {
        this();
        this.val.set(aFloat);
    }


    public FloatBigEndianStruct() {
          val= new Float32();

    }

    // sembra che i valori misurati dall'inverter siano in BIG_ENDIAN a differenza del CRC
    @Override
    public ByteOrder byteOrder() {
        return ByteOrder.BIG_ENDIAN;
    }
}