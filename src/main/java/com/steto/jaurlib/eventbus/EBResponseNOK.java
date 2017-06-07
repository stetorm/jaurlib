package com.steto.jaurlib.eventbus;

/**
 * Created by stefano on 26/12/15.
 */
public class EBResponseNOK extends EBResponse {
    public EBResponseNOK() {

        this(-1, "Generic error");
    }

    public class _Error {
        public Integer code;
        public String message;
    }

    public _Error error = new _Error();

    public EBResponseNOK(int errorCode, String errorString) {
        error.code = errorCode;
        error.message = errorString;
    }


    public static void main(String[] args) {

        EBResponseNOK webResponseNOK = new EBResponseNOK(400, "messaggio");


        System.out.print(webResponseNOK.toJson());
    }


}