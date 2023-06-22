package com.qintin.sub_process.process;

public interface Callback {
    void onReadLine(String outLine);

    void onClose(String closeCode);
}