package com.allan.creditdatapp;

import java.io.File;
import java.util.UUID;

import org.apache.poi.ss.usermodel.Row;

import com.allan.creditdatapp.model.ENTBaseInfo;
import com.allan.creditdatapp.parser.CreditExcelFileParser;
import com.allan.creditdatapp.parser.ENTAdministrativePenaltyParser;
import com.allan.creditdatapp.parser.ENTAdministrativePermitParser;
import com.allan.creditdatapp.parser.ENTAwardParser;
import com.allan.creditdatapp.parser.ENTClassificationRegulationParser;
import com.allan.creditdatapp.parser.ENTDebtParser;
import com.allan.creditdatapp.parser.ENTInspectionTestParser;
import com.allan.creditdatapp.parser.ENTJudicialDecisionParser;
import com.allan.creditdatapp.parser.ENTQualificationParser;
import com.allan.creditdatapp.parser.ENTSeriousViolationOfLawParser;

/*
 * 
 */
public class AppUtil {
    
    public static void initCommonENTBaseInfo(Row row, ENTBaseInfo entBaseInfo)
    {
        String entName = row.getCell(0).getStringCellValue();
        String entSocialCode = row.getCell(1).getStringCellValue();
        String entInstitutionCode = row.getCell(2).getStringCellValue();
        String entRegistrationCode = row.getCell(3).getStringCellValue();

        entBaseInfo.setEntName(entName);
        entBaseInfo.setEntSocialCode(entSocialCode);
        entBaseInfo.setEntInstitutionCode(entInstitutionCode);
        entBaseInfo.setEntRegistrationCode(entRegistrationCode);
    }
    
    public static CreditExcelFileParser initFileParser(File file)
    {
        String fileName = file.getName();
        
        CreditExcelFileParser parser;
        
        if(fileName.indexOf(AppConstant.ENT_ADMINISTRATIVE_PENALTY) > 0)
        {
            parser = new ENTAdministrativePenaltyParser(file);
            return parser;
        }
        
        if(fileName.indexOf(AppConstant.ENT_ADMINISTRATIVE_PERMIT) > 0)
        {
            parser = new ENTAdministrativePermitParser(file);
            return parser;
        }
        
        if(fileName.indexOf(AppConstant.ENT_AWARD) > 0)
        {
            parser = new ENTAwardParser(file);
            return parser;
        }
        
        if(fileName.indexOf(AppConstant.ENT_CLASSIFICATION_REGULATION) > 0)
        {
            parser = new ENTClassificationRegulationParser(file);
            return parser;
        }
        
        if(fileName.indexOf(AppConstant.ENT_DEBT) > 0)
        {
            parser = new ENTDebtParser(file);
            return parser;
        }
        
        if(fileName.indexOf(AppConstant.ENT_INSPECTION_TEST) > 0)
        {
            parser = new ENTInspectionTestParser(file);
            return parser;
        }
        
        if(fileName.indexOf(AppConstant.ENT_JUDICIAL_DECISION) > 0)
        {
            parser = new ENTJudicialDecisionParser(file);
            return parser;
        }
        
        if(fileName.indexOf(AppConstant.ENT_QUALIFICATION) > 0)
        {
            parser = new ENTQualificationParser(file);
            return parser;
        }
        
        if(fileName.indexOf(AppConstant.ENT_SERIOUS_VIOLATION_OF_LAW) > 0)
        {
            parser = new ENTSeriousViolationOfLawParser(file);
            return parser;
        }
        
        return null;
    }
    
    public static String getFTID(UUID uuid)
    {
        return new String("FTID("+uuid.toString()+") ");
    }
}
