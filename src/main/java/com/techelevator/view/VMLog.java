package com.techelevator.view;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//import java.util.logging.Logger;

public class VMLog {
//    Logger logger = Logger.getLogger(VMLog.class.getName());
    public static void log(String message, BigDecimal startBalance, BigDecimal endBalance) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
        String formattedTimestamp = LocalDateTime.now().format(format);

        File logDir = new File(System.getProperty("user.dir") + "\\logs");
        try {
            if (logDir.exists()) {
                File log = new File(logDir, "Log.txt");
                if (!log.exists()) {
                    log.createNewFile();
                }

                try (PrintWriter writer = new PrintWriter(new FileOutputStream(log, true))) {
                    writer.println(formattedTimestamp + " " + message + " $" + startBalance + " $" + endBalance);
                } catch (FileNotFoundException e) {
                    System.out.println("File not found.");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
