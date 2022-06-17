package com.techelevator.view;

import java.io.*;
//import java.util.logging.Logger;

public class VMLog {
//    Logger logger = Logger.getLogger(VMLog.class.getName());
    public static void logger(String message) {
        File logDir = new File(System.getProperty("user.dir") + "\\logs");
        try {
            if (logDir.exists()) {
                File log = new File(logDir, "Log.txt");
                if (!log.exists()) {
                    log.createNewFile();
                }
                try (PrintWriter writer = new PrintWriter(new FileOutputStream(logDir, true))) {
                    writer.println(message);
                } catch (FileNotFoundException e) {
                    System.out.println("File not found.");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
