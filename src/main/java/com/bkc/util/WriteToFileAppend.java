package com.bkc.util;

import org.apache.commons.lang3.StringUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class WriteToFileAppend {
    static PrintStream ps;

    public static void writeToFile(String file, String content) throws IOException {
        if (StringUtils.isBlank(file)) {
            file = "/Users/bkc/Desktop/text";
        }
        //写入相应的文件
        try {
            ps = new PrintStream(new FileOutputStream(file));
            ps.println(content);// 在已有的基础上添加字符串
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
