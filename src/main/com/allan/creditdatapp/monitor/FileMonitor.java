package com.allan.creditdatapp.monitor;

import java.util.concurrent.ThreadFactory;

import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

public class FileMonitor {
    private static final Logger LOGGER = LogManager.getLogger(LogManager.getLogger(FileMonitor.class.getName()));

    private static final String MONITOR_THREAD_NAME = "File Monitor";

    // The state of a file or directory, capturing the following File attributes
    // at a point in time.
    // private FileEntry fileEntry;

    // represents the state of files below a root directory, checking the file
    // system and notifying listeners of create, change or delete events.
    private FileAlterationObserver observer;
    // A runnable that spawns a monitoring thread triggering any registered
    // FileAlterationObserver at a specified interval.
    private FileAlterationMonitor monitor;

    public FileMonitor(String path, int interval) {
        // this.fileEntry = new FileEntry(FileUtils.getFile(path));
        this.observer = new FileAlterationObserver(path);
        this.observer.addListener(new StatFileAlterationListener());
        this.monitor = new FileAlterationMonitor(interval * 1000, this.observer);

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat(MONITOR_THREAD_NAME).build();
        this.monitor.setThreadFactory(namedThreadFactory);
    }

    public void start() {
        try {
            this.monitor.start();
        } catch (Exception e) {
            LOGGER.error("START FILE MONITOR FAILED.", e);
        }
    }

    public void stop() {
        try {
            monitor.stop();
        } catch (Exception e) {
            LOGGER.warn("STOP FILE MONITOR FAILED.", e);
        }
    }

}
