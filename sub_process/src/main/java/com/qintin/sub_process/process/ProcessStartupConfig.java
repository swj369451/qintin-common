package com.qintin.sub_process.process;

import lombok.Data;

/**
 * @name:
 * @description
 * @author: 苏敏
 * @create: 2023-06-20 11:18
 **/
@Data
public class ProcessStartupConfig {

    /**
     * 程序初始化执行的命令
     */
    private String command;

    /**
     * 回调
     */
    private Callback callback;

    /**
     * 是否重启
     */
    private Boolean isRestart = false;
}
