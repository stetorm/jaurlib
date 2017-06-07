package com.steto.jaurlib.eventbus;

/**
 * Created by stefano on 26/12/15.
 */
public class EBResponseOK extends EBResponse {


    public final Object data;

    public EBResponseOK(Object payload) {
        data = payload;
    }

    public static void main(String[] args) {

        EBResponseOK webResponseOK = new EBResponseOK("400");
        System.out.print(webResponseOK.toJson());
    }


}