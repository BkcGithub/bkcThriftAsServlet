/*
package com.bkc.controller;

import com.alibaba.fastjson.JSON;
import com.iflytek.msp.cpdb.lfasr.client.LfasrClientImp;
import com.iflytek.msp.cpdb.lfasr.exception.LfasrException;
import com.iflytek.msp.cpdb.lfasr.model.LfasrType;
import com.iflytek.msp.cpdb.lfasr.model.Message;
import com.iflytek.msp.cpdb.lfasr.model.ProgressStatus;
import org.apache.log4j.PropertyConfigurator;

import java.util.HashMap;

public class XunfeiVoice {
    // 本地文件地址
    private static final String local_file = "/Users/bkc/Desktop/startsportz.WAV";

    */
/**
     *  LfasrType枚举类型说明：
     // 16K标准版-已录制音频，支持格式wav,flac,opus,mp3,m4a
     LfasrType.LFASR_STANDARD_RECORDED_AUDIO
     // 8K电话专用版-已录制音频，支持格式wav,flac,mp3
     LfasrType.LFASR_TELEPHONY_RECORDED_AUDIO
     *//*

    private static final LfasrType type = LfasrType.LFASR_STANDARD_RECORDED_AUDIO;
    // sleep
    private static int sleepSecond = 20;

    public static void main(String[] args) {
        // log
        PropertyConfigurator.configure("log4j.properties");

        // LfasrClientImp
        LfasrClientImp lc = null;
        try {
            lc = LfasrClientImp.initLfasrClient();
        } catch (LfasrException e) {
            // Message
            Message initMsg = JSON.parseObject(e.getMessage(), Message.class);
            System.out.println("ecode=" + initMsg.getErr_no());
            System.out.println("failed=" + initMsg.getFailed());
        }

        String task_id = "";
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("has_participle", "true");
        try {
            // 上传
            Message uploadMsg = lc.lfasrUpload(local_file, type, params);

            // 结果
            int ok = uploadMsg.getOk();
            if (ok == 0) {
                //
                task_id = uploadMsg.getData();
                System.out.println("task_id=" + task_id);
            } else {
                //
                System.out.println("ecode=" + uploadMsg.getErr_no());
                System.out.println("failed=" + uploadMsg.getFailed());
                return;
            }
        } catch (LfasrException e) {
            //
            Message uploadMsg = JSON.parseObject(e.getMessage(), Message.class);
            System.out.println("ecode=" + uploadMsg.getErr_no());
            System.out.println("failed=" + uploadMsg.getFailed());
            return;
        }

        //
        while (true) {
            try {
                Thread.sleep(sleepSecond * 1000);
                System.out.println("waiting ...");
            } catch (InterruptedException e) {
            }
            try {
                // 获取结果
                Message progressMsg = lc.lfasrGetProgress(task_id);

                if (progressMsg.getOk() != 0) {
                    System.out.println("task was fail. task_id:" + task_id);
                    System.out.println("ecode=" + progressMsg.getErr_no());
                    System.out.println("failed=" + progressMsg.getFailed());
                    continue;
                } else {
                    ProgressStatus progressStatus = JSON.parseObject(progressMsg.getData(), ProgressStatus.class);
                    if (progressStatus.getStatus() == 9) {
                        System.out.println("task was completed. task_id:" + task_id);
                        break;
                    } else {
                        // δ�������
                        System.out.println(
                            "task was incomplete. task_id:" + task_id + ", status:" + progressStatus.getDesc());
                        continue;
                    }
                }
            } catch (LfasrException e) {
                Message progressMsg = JSON.parseObject(e.getMessage(), Message.class);
                System.out.println("ecode=" + progressMsg.getErr_no());
                System.out.println("failed=" + progressMsg.getFailed());
            }
        }

        try {
            Message resultMsg = lc.lfasrGetResult(task_id);
            if (resultMsg.getOk() == 0) {
                System.out.println(resultMsg.getData());
            } else {
                System.out.println("ecode=" + resultMsg.getErr_no());
                System.out.println("failed=" + resultMsg.getFailed());
            }
        } catch (LfasrException e) {
            Message resultMsg = JSON.parseObject(e.getMessage(), Message.class);
            System.out.println("ecode=" + resultMsg.getErr_no());
            System.out.println("failed=" + resultMsg.getFailed());
        }
    }
}
*/
