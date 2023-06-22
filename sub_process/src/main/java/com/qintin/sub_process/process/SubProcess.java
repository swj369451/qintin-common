package com.qintin.sub_process.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @name: 子程序
 * @description
 * @author: 苏敏
 * @create: 2023-06-20 11:55
 **/
//@Log4j
public class SubProcess {


    private Runtime runtime;
    private Process process;
    private ProcessStartupConfig processStartupConfig;

    private BufferedReader reader;
    private String outLine;
    private Thread thread;


    public SubProcess(Runtime runtime, ProcessStartupConfig processStartupConfig) {
        this.runtime = runtime;
        this.processStartupConfig = processStartupConfig;
    }

    /**
     * 启动子程序
     *
     * @return
     */
    public ProcessStartupResult launch() {
        try {
            process = Runtime.getRuntime().exec(processStartupConfig.getCommand());
            reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));

        } catch (NullPointerException | IllegalArgumentException e) {
            e.printStackTrace();
            return ProcessStartupResult.createErrorResult("启动子程序的指令不能为空" + e.getMessage());
        } catch (SecurityException e) {
            e.printStackTrace();
            return ProcessStartupResult.createErrorResult("没有足够的权限启动子程序" + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            return ProcessStartupResult.createErrorResult("开启io通道失败" + e.getMessage());
        }
        thread = new Thread() {
            @Override
            public void run() {
                try {
                    while ((outLine = reader.readLine()) != null) {
                        if (processStartupConfig.getCallback() != null) {
                            processStartupConfig.getCallback().onReadLine(outLine);
                        }
                    }
                    reader.close();

                    int exitValue = process.exitValue();
                    if (processStartupConfig.getCallback() != null) {
                        processStartupConfig.getCallback().onClose(String.valueOf(exitValue));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        };
        thread.start();


        return ProcessStartupResult.createSuccessResult(this);
    }

    public Boolean processIsAlive() {
        return process.isAlive() && thread.isAlive();
    }

    public void close() {
        process.destroy();
        thread.interrupt();
    }
}
