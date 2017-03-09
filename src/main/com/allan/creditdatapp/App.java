package com.allan.creditdatapp;

import java.io.File;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.allan.creditdatapp.monitor.FileMonitor;

/*
 * CreditData Application
 */
public class App {

    private static final Logger LOGGER = LogManager.getLogger(LogManager.getLogger(App.class.getName()));

    private static int MONITOR_INTERVAL;
    public static String FILE_PATH_UPLOAD;
    public static String FILE_PATH_PARSING;
    public static String FILE_PATH_PARSED;
    public static String FILE_PATH_BACKUP;
    public static String FILE_PATH_INVALID;

    public static File DIR_UPLOAD;
    public static File DIR_PARSING;
    public static File DIR_PARSED;
    public static File DIR_BACKUP;
    public static File DIR_INVALID;

    public static void INIT_CONF() throws Exception {
        Configurations configs = new Configurations();
        Configuration config = configs.properties(new File("/config.properties"));

        MONITOR_INTERVAL  = config.getInt("MONITOR_INTERVAL");
        FILE_PATH_UPLOAD  = config.getString("FILE_PATH_UPLOAD");
        FILE_PATH_PARSING = config.getString("FILE_PATH_PARSING");
        FILE_PATH_PARSED  = config.getString("FILE_PATH_PARSED");
        FILE_PATH_BACKUP  = config.getString("FILE_PATH_BACKUP");
        FILE_PATH_INVALID = config.getString("FILE_PATH_INVALID");

        DIR_UPLOAD  = new File(FILE_PATH_UPLOAD);
        DIR_PARSING = new File(FILE_PATH_PARSING);
        DIR_PARSED  = new File(FILE_PATH_PARSED);
        DIR_BACKUP  = new File(FILE_PATH_BACKUP);
        DIR_INVALID = new File(FILE_PATH_INVALID);

        LOGGER.info("App configuration initialized ...");
    }

    private static void INIT_MAIN_PROCESS() throws Exception {
        FileMonitor monitor = new FileMonitor(FILE_PATH_UPLOAD, MONITOR_INTERVAL);
        monitor.start();
        LOGGER.info("File Monitor started ...");
        // TimeUnit.SECONDS.sleep(180);
        // monitor.stop();
    }

    public static void main(String[] args) {
        try {
            // initialize application global parameters
            INIT_CONF();

            // start file change monitor
            INIT_MAIN_PROCESS();
        } catch (Exception e) {
            LOGGER.error("APP ERROR", e);
        }
    }
}
