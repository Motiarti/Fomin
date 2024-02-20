package ru.Sberbank.LogHandler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class LogWriter {

    public void writeLog(List<TargetFiles> list) {
        StringBuilder allStr = new StringBuilder();
        String str1 = "String1";
        String str2 = "String2";
        String str3 = "String3";
        String str4 = "String4";
        String str5 = "String5";
        allStr.append(str1 + "\n").append(str2 + "\n").append(str3 + "\n").append(str4 + "\n").append(str5 + "\n");
        for (TargetFiles f : list) {
            String logName = f.getName();
            String logPath = f.getLogPath();
            try {
                FileWriter currentFile = new FileWriter(logPath + logName);
                currentFile.write(String.valueOf(allStr));
                currentFile.flush();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
