package com.steto.jaurlib.response;

import com.steto.jaurlib.FloatBigEndianStruct;
import com.steto.jaurlib.LongBigEndianStruct;
import com.steto.jaurlib.modbus.MB_PDU;
import com.steto.jaurlib.modbus.MB_Struct;
import com.steto.jaurlib.modbus.MB_code;
import com.steto.jaurlib.modbus.MB_data;
import javolution.io.Struct;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class AuroraResponse extends MB_PDU {


    protected String description = "";
    protected ResponseErrorEnum errorCode = ResponseErrorEnum.NONE;

    public abstract String getValue() ;


    class _Data extends MB_data {
        public Unsigned8 subCode;
        _Bytes byteArray;

        _Data() {
            subCode = new Unsigned8();
            byteArray = new _Bytes();
        }

        @Override
        public int read(InputStream in) throws IOException {
            return super.read(in) + byteArray.read(in);
        }

        @Override
        public void write(OutputStream out) throws IOException {
            super.write(out);
            byteArray.write(out);
        }


        @Override
        public String toString() {
            return super.toString() + ((errorCode!=ResponseErrorEnum.TIMEOUT) ? byteArray.toString(): "Invalid Response, error: "+errorCode);
        }
    }

    class _Bytes extends MB_data {

        final Unsigned8[] bytes;

        _Bytes() {
            bytes = array(new Struct.Unsigned8[4]);
        }


    }

    public AuroraResponse(MB_code code) {
        this.code = code;
        this.data = new _Data();

    }

    public AuroraResponse() {
        this.code = new MB_code(0);
        this.data = new _Data();

    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setSubCode(char val) {
        ((_Data) data).subCode.set((short) val);
    }

    public void setParam1(char val) {
        ((_Data) data).byteArray.bytes[0].set((short) val);
    }

    public void setParam2(char val) {
        ((_Data) data).byteArray.bytes[1].set((short) val);
    }

    public void setParam3(char val) {
        ((_Data) data).byteArray.bytes[2].set((short) val);
    }

    public void setParam4(char val) {
        ((_Data) data).byteArray.bytes[3].set((short) val);
    }


    public void setFloatParam(float val) {

        MB_Struct struct = new FloatBigEndianStruct(val);
        try {
            ByteArrayInputStream iStream = new ByteArrayInputStream(struct.toByteArray());
            ((_Data) this.data).byteArray.read(iStream);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public float getFloatParam() {

        float result = (float) -9999.9;
        FloatBigEndianStruct struct = new FloatBigEndianStruct(0);
        try {
            ByteArrayInputStream iStream = new ByteArrayInputStream(((_Data) this.data).byteArray.toByteArray());
            struct.read(iStream);
            result = struct.val.get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;


    }

    public void setLongParam(long val) {

        MB_Struct struct = new LongBigEndianStruct(val);
        try {
            ByteArrayInputStream iStream = new ByteArrayInputStream(struct.toByteArray());
            ((_Data) this.data).byteArray.read(iStream);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public long getLongParam() throws IOException {

        LongBigEndianStruct struct = new LongBigEndianStruct(0);

        ByteArrayInputStream iStream = new ByteArrayInputStream(((_Data) this.data).byteArray.toByteArray());
        struct.read(iStream);
        return struct.val.get();


    }

    public char getParam1() {
        return (char) ((_Data) data).byteArray.bytes[0].get();
    }

    public char getParam2() {
        return (char) ((_Data) data).byteArray.bytes[1].get();
    }

    public char getParam3() {
        return (char) ((_Data) data).byteArray.bytes[2].get();
    }

    public char getParam4() {
        return (char) ((_Data) data).byteArray.bytes[3].get();
    }

    public char getSubCode() {
        return (char) ((_Data) data).subCode.get();
    }


    public ResponseErrorEnum getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ResponseErrorEnum code) {
        errorCode = code;
    }

}
