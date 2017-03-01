package com.allan.creditdatapp.parser;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.allan.creditdatapp.AppUtil;
import com.allan.creditdatapp.model.ENTBaseInfo;

public abstract class CreditExcelFileParser {
    private static final Logger LOGGER = LogManager
            .getLogger(LogManager.getLogger(CreditExcelFileParser.class.getName()));

    protected File targetFile;
    protected String submitter;
    protected String submitDate;

    public CreditExcelFileParser(File file) {
        this.targetFile = file;
        String fileName = this.targetFile.getName();

        String[] keyArray = fileName.split(this.getFileType());
        this.submitter = keyArray[0];
        this.submitDate = keyArray[1].substring(0, 9);
    }

    public String getSubmitter() {
        return this.submitter;
    }

    public String getSubmitDate() {
        return this.submitDate;
    }

    public List<? extends ENTBaseInfo> extractCreditData(UUID uuid) {
        List<ENTBaseInfo> list = new ArrayList<ENTBaseInfo>();
        String fileName = this.targetFile.getName();
        LOGGER.info(AppUtil.getFTID(uuid) + "Starting parse " + fileName);
        try {
            FileInputStream inp = new FileInputStream(this.targetFile);
            Workbook wb;
            if (fileName.endsWith("xls")) {
                wb = new HSSFWorkbook(new POIFSFileSystem(inp));
            } else if (fileName.endsWith("xlsx")) {
                wb = new XSSFWorkbook(inp);
            } else {
                inp.close();
                return null;
            }

            Sheet sheet = wb.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0)
                    continue;

                // 解析到空行时退出
                if (row.getLastCellNum() < 0) {
                    break;
                }

                // 解析第一列Cell为空时退出
                if (row.getCell(0).getStringCellValue().length() == 0) {
                    break;
                }

                ENTBaseInfo entBaseInfo = this.parse(row, uuid);
                if (entBaseInfo == null) {
                    continue;
                }
                AppUtil.initCommonENTBaseInfo(row, entBaseInfo);

                list.add(entBaseInfo);
            }
            wb.close();
            inp.close();

            LOGGER.info(AppUtil.getFTID(uuid) + "Finish parse {" + this.targetFile.getName() + "}, row count(" + list.size() + ")");

            return list;
        } catch (Exception e) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "PARSE FILE {" + this.targetFile.getName() + "} FAILED.", e);
        }

        return null;
    }

    public abstract String getFileType();

    public abstract ENTBaseInfo parse(Row row, UUID uuid);

}
