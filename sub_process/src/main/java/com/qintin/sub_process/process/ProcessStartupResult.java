package com.qintin.sub_process.process;

import lombok.Data;

/**
 * @name: 子程序启动结果
 * @description
 * @author: 苏敏
 * @create: 2023-06-20 11:24
 **/
@Data
public class ProcessStartupResult {

    /**
     * 是否初始化成功
     */
    private Boolean isSuccess = false;

    /**
     * 错误信息
     */
    private String errorMessage;

    /**
     * 运行的子程序
     */
    private SubProcess subProcess;


    public static ProcessStartupResult createErrorResult(String errorMessage) {
        ProcessStartupResult processStartupResult = new ProcessStartupResult();
        processStartupResult.setIsSuccess(false);
        processStartupResult.setErrorMessage(errorMessage);
        return processStartupResult;
    }

    public static ProcessStartupResult createSuccessResult(SubProcess subProcess) {
        ProcessStartupResult processStartupResult = new ProcessStartupResult();
        processStartupResult.setIsSuccess(true);
        processStartupResult.setSubProcess(subProcess);
        return processStartupResult;
    }
}
