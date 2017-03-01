package com.allan.creditdatapp.monitor;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.allan.creditdatapp.App;
import com.allan.creditdatapp.AppUtil;

public class StatFileAlterationListener implements FileAlterationListener {
    private static final Logger LOGGER = LogManager
            .getLogger(LogManager.getLogger(StatFileAlterationListener.class.getName()));

    private static ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Override
    public void onDirectoryChange(File directory) {

        // LOGGER.info("onDirectoryChange::" + directory.getName());
    }

    @Override
    public void onDirectoryCreate(File directory) {

        // LOGGER.info("onDirectoryCreate::" + directory.getName());
    }

    @Override
    public void onDirectoryDelete(File directory) {

        // LOGGER.info("onDirectoryDelete::" + directory.getName());
    }

    @Override
    public void onFileChange(File file) {

        // LOGGER.info("onFileChange::" + file.getName());
    }

    @Override
    public void onFileCreate(File file) {
        UUID uuid = UUID.randomUUID();
        LOGGER.info(AppUtil.getFTID(uuid) + "detected a new file {" + file.getName() + "}");

        String fileName = file.getName();
        // validate file name
        if (FileValidator.validateFileName(fileName)) {
            LOGGER.info(AppUtil.getFTID(uuid) + "accept valid name of file {" + fileName + "}");

            // start a job for parse file
            executorService.execute(new CreditFileProcessor(file, uuid));

        } else {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECT A INVALID-NAME FILE {" + fileName + "}");
            try {
                String[] nameSegs = fileName.split("\\.");
                String suffix = nameSegs[nameSegs.length - 1];
                
                String prefix = fileName.substring(0, fileName.length() - suffix.length() - 1);
                SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");

                String newFileName = prefix + "(" + df.format(new Date()) + ")." + suffix;
                LOGGER.info(AppUtil.getFTID(uuid) + "New Invalid File {" + newFileName + "}");
                
                File newFile = new File(App.DIR_UPLOAD + File.separator + newFileName);
                FileUtils.copyFile(file, newFile);
                FileUtils.moveFileToDirectory(newFile, App.DIR_INVALID, true);
                LOGGER.info(AppUtil.getFTID(uuid) + "move invalid-name file to DIR_INVALID.");
                
                FileUtils.forceDelete(file);
                LOGGER.info(AppUtil.getFTID(uuid) + "delete a upload file {" + fileName + "}");
            } catch (IOException e) {
                LOGGER.warn(AppUtil.getFTID(uuid) + "MOVE INVALID-NAME FILE TO DIR_INVALID FAILED.", e);
            }
        }
    }

    @Override
    public void onFileDelete(File file) {

        // LOGGER.info("onFileDelete::" + file.getName());
    }

    @Override
    public void onStart(FileAlterationObserver observer) {

        // LOGGER.info("onStart::" + observer.toString());

    }

    @Override
    public void onStop(FileAlterationObserver observer) {

        // LOGGER.info("onStop::" + observer.toString());
    }

}
