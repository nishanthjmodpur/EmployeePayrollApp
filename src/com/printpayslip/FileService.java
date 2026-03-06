package com.printpayslip;

import java.io.FileWriter;
import java.io.IOException;

/*
 * File service handles saving payslip data to files
 *  
 *  Why this class exists:
 *	 - File operations should not be inside Payslip.
 *	 - Separates persistence from data representation. 
 */

public class FileService {
	
	/*
	 * Saves payslip as a textfile
	 * 
	 * A unique filename is generated using timestamp to avoid
	 * overwriting existing files.
	 */

    public String savePayslipAsText(DownloadablePayslip payslip) throws IOException {
        String fileName = "Payslip_" + payslip.getEmpId() + "_"
                + System.currentTimeMillis() + ".txt";
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write(payslip.toString());
        }
        return fileName;
    }
    
    /*
     * Saves files as pdf
     */

    public String savePayslipAsPdf(DownloadablePayslip payslip) throws IOException {
        String fileName = "Payslip_" + payslip.getEmpId() + "_"
                + System.currentTimeMillis() + ".pdf";
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write(payslip.toString());
        }
        return fileName;
    }
}