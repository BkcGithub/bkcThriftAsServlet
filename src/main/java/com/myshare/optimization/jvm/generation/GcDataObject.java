package com.myshare.optimization.jvm.generation;

public class GcDataObject {
    byte[] bytes = null;
    RefObject object = null;

    public GcDataObject(int factor) {

        //create object in kb
        bytes = new byte[factor * 1024];
        object = new RefObject();
    }


    class RefObject {
        RefChildObject refChildObject;

        public RefObject() {
            refChildObject = new RefChildObject();
        }
    }


    class RefChildObject {
        public RefChildObject() {
            ;
        }
    }
}
