package com.allan.creditdatapp.monitor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.allan.creditdatapp.AppConstant;

public class FileValidator {

    public static void main(String[] args) {
        FileValidator.validatDateFormat("1012-22-1");
    }

    private static boolean validatDateFormat(String date) {
        Pattern patter = Pattern.compile("^\\d{4}\\-\\d{1,2}\\-\\d{1,2}$");
        Matcher matcher = patter.matcher(date);
        boolean match = matcher.matches();
        return match;
    }
    
    private static boolean validatePreFileName(String preFileName, String dataType)
    {
        if (preFileName.indexOf(dataType) > 0) {
            String[] subSegs = preFileName.split(dataType);
            if (subSegs.length != 2) {
                return false;
            }
            
            // 校验文件中的日期格式："YYYY-MM-DD"
            String date = subSegs[1];
            if(!validatDateFormat(date))
            {
                return false;
            }

            return true;
        }
        
        return false;
    }

    public static boolean validateFileName(String fileName) {
        String[] segs = fileName.split("\\.");
        // 文件名包含多余的 "."
        if (segs.length != 2) {
            return false;
        }

        String preFileName = segs[0];
        if(validatePreFileName(preFileName, AppConstant.ENT_ADMINISTRATIVE_PENALTY)
                || validatePreFileName(preFileName, AppConstant.ENT_ADMINISTRATIVE_PERMIT)
                || validatePreFileName(preFileName, AppConstant.ENT_AWARD)
                || validatePreFileName(preFileName, AppConstant.ENT_CLASSIFICATION_REGULATION)
                || validatePreFileName(preFileName, AppConstant.ENT_DEBT)
                || validatePreFileName(preFileName, AppConstant.ENT_INSPECTION_TEST)
                || validatePreFileName(preFileName, AppConstant.ENT_JUDICIAL_DECISION)
                || validatePreFileName(preFileName, AppConstant.ENT_QUALIFICATION)
                || validatePreFileName(preFileName, AppConstant.ENT_SERIOUS_VIOLATION_OF_LAW))
        {
            return true;
        }
        return false;
    }
}
