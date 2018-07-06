package com.bkc.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms20m -Xmx20m -xx:+HeapDumpOnOutOfMemoryError
 * @author bkc
 */
public class HeapOOM {
    static  class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> oomObjectList = new ArrayList<>();

        while (true) {
            oomObjectList.add(new OOMObject());
        }
    }
}
