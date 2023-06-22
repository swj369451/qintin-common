package com.qintin.sub_process.process;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @name: 进程服务
 * @description 通过命令运行一个子进程，子进程由单独的线程运行
 * @author: 苏敏
 * @create: 2023-06-20 11:05
 **/
@Service
@Slf4j
public class ProcessService {
    private final Runtime runtime;

    private final List<SubProcess> subProcessList = new ArrayList<>();

    public ProcessService() {
        this.runtime = Runtime.getRuntime();
    }


    /**
     * 执行一个命令，并生成一个子程序。当运行成功的时候加入到队列中
     *
     * @param processStartupConfig 子程序配置
     * @return
     */
    public ProcessStartupResult executeCommandForProcess(ProcessStartupConfig processStartupConfig) {
        SubProcess subProcess = new SubProcess(runtime, processStartupConfig);
        ProcessStartupResult launchResult = subProcess.launch();
        if (launchResult.getIsSuccess()) {
            subProcessList.add(subProcess);
        } else {
            log.error(launchResult.getErrorMessage());
        }
        return launchResult;
    }
}
