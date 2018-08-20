package com.myshare.optimization.jvm.gc;

public class GCPolicyDataObject {

    byte[] bytes = null;
    GCPolicyRefObject object = null;

    public GCPolicyDataObject(int factor) {

        //create object in kb
        bytes = new byte[factor * 1024];
        object = new GCPolicyRefObject();
    }


    class GCPolicyRefObject {
        GCPolicyRefChildObject refChildObject;

        public GCPolicyRefObject() {
            refChildObject = new GCPolicyRefChildObject();
        }
    }


    class GCPolicyRefChildObject {
        public GCPolicyRefChildObject() {
            ;
        }
    }


}
