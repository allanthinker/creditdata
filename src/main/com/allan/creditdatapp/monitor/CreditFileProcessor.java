package com.allan.creditdatapp.monitor;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.allan.creditdatapp.App;
import com.allan.creditdatapp.AppUtil;
import com.allan.creditdatapp.model.ENTBaseInfo;
import com.allan.creditdatapp.parser.CreditExcelFileParser;

public class CreditFileProcessor implements Runnable {
    private static final Logger LOGGER = LogManager
            .getLogger(LogManager.getLogger(CreditFileProcessor.class.getName()));

    private File file;
    private UUID uuid;

    public CreditFileProcessor(File file, UUID uuid) {
        this.file = file;
        this.uuid = uuid;
    }

    @Override
    public void run() {
        String fileName = this.file.getName();

        // copy file to parsing directory
        try {
            // if the same name of file exists in DIR_PARSING, DELETE IT.
            File targetFile = new File(App.DIR_PARSING + File.separator + fileName);
            if (targetFile.exists()) {
                FileUtils.forceDelete(targetFile);
            }

            FileUtils.moveFileToDirectory(file, App.DIR_PARSING, true);
            LOGGER.info(AppUtil.getFTID(uuid) + "move {" + fileName + "} to DIR_PARSING successfully.");
        } catch (IOException e) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "MOVE {" + fileName + "} TO DIR_PARSING FAILED.", e);
            return;
        }
        File parseFile = new File(App.FILE_PATH_PARSING + File.separator + fileName);

        // parse credit file
        CreditExcelFileParser parser = AppUtil.initFileParser(parseFile);
        List<? extends ENTBaseInfo> entCreditInfo = parser.extractCreditData(uuid);

        if (entCreditInfo != null) {
            // TODO
            
        } else {
            return;
        }

        // copy parsed credit file to parsed directory
        try {
            FileUtils.moveFileToDirectory(parseFile, App.DIR_PARSED, true);
            LOGGER.info(AppUtil.getFTID(uuid) + "move {" + fileName + "} to DIR_PARSED successfully.");
        } catch (IOException e) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "MOVE {" + fileName + "} TO DIR_PARSED FAILED.", e);
            return;
        }

        // backup parsed credit file, if the file have backuped, it should not overwrite.
        File parsedFile = new File(App.DIR_PARSED + File.separator + fileName);
        try {
            FileUtils.moveFileToDirectory(parsedFile, App.DIR_BACKUP, true);
            LOGGER.info(AppUtil.getFTID(uuid) + "move {" + fileName + "} to DIR_BACKUP successfully.");
        } catch (IOException e) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "MOVE {" + fileName + "} TO DIR_BACKUP FAILED.", e);
        }

    }

}
