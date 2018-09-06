package org.examples.jasper;

import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * Jasper processor to compile and parse reports
 * @author 
 *
 */
public class JasperProcessor {

	private final static String reportTemplateDirectory = "src/main/resources";
	private final static String jasperReportDirectory = "src/main/resources/jasper";
	
	private String reportName;
	private String jrxmlReportPath;
	private String jasperReportPath;
	
	private JasperPrint filledReport;
	
	public JasperProcessor(String reportName){
		
		this.reportName = reportName;

		this.jrxmlReportPath = reportTemplateDirectory + "/" + reportName + ".jrxml";
		this.jasperReportPath = jasperReportDirectory + "/" + reportName + ".jasper";
	}
	

	/**
	 * Parse template and create .jasper file (binary file without parameters)
	 */
	public void parseTemplate(){
		
		// Check files exists
		if(!FileUtils.checkFileExists(jrxmlReportPath)){
			throw new RuntimeException("JXRML report doesn't exists " + jrxmlReportPath);
		}
		
		// Try parse report
        try  {
            JasperCompileManager.compileReportToFile(jrxmlReportPath, jasperReportPath);
        } catch (JRException e) {
        	throw new RuntimeException("Can not compile report " + jrxmlReportPath, e);
		}
		
	}
	
	/**
	 * Insert params and compile
	 * @param parameters
	 * @param dataSource
	 */
	public void insertParamsAndCompile(Map parameters, JRBeanCollectionDataSource dataSource){
		
        // Fill parameters
		try {
			filledReport = JasperFillManager.fillReport(jasperReportPath, parameters, dataSource);
		} catch (JRException e) {
			throw new RuntimeException("Can not parse report " + jasperReportPath, e);
		}
        
	}
	
	
	public void exportResultToFile(String resultFilePathPDF){
		
        try {
        	JasperExportManager.exportReportToPdfFile(filledReport, resultFilePathPDF);
		} catch (JRException e) {
			throw new RuntimeException("Can not export " + resultFilePathPDF, e);
		}
	}
	

	
	
	
}
