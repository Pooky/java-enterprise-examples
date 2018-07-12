package org.examples.jasper;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.examples.jasper.entity.Address;
import org.examples.jasper.entity.Faktura;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class JasperProcessor {

	public static final String drevotrieskaTemplate = "src/main/resources/exampleReport.jrxml";
	public static final String parsedJasperFile = "src/main/resources/exampleReport.jasper";
	private static final String jasperReportPDF = "src/main/resources/jasperReportPDF.pdf";
	
	private JasperPrint filledReport;
	
	public void processFile() {
		
		compileFile(false);
		setParams();
		saveToFile();
		
	}

	public void compileFile(boolean force) {
		
		// Pokud soubor neexistuje nebo chceme vynutit novou kompilaci
		if(!(new File(parsedJasperFile).exists()) || force) {

			// Try parse report
			try {
				JasperCompileManager.compileReportToFile(drevotrieskaTemplate, parsedJasperFile);
			} catch (JRException e) {
				e.printStackTrace();
			}
	
		}
	}
	
	public void setParams() {
		
        DataBeanList DataBeanList = new DataBeanList();
        ArrayList<DataBean> dataList = DataBeanList.getDataBeanList();
        
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);

        Address dodavatel = new Address();
        dodavatel.setCity("Mesto");
        dodavatel.setFirstName("Jan");
        dodavatel.setLastName("Novak");
        
        // Parametry
        Faktura faktura = new Faktura();
        faktura.setCelkovaCena("150Eur");
        faktura.setDatumSplatnosti("15.2.2019");
        faktura.setDatumVystaveni("15.9.2019");
        faktura.setVs("00000001");
        faktura.setDodavatelAdresa(dodavatel);
		
        Map<String, Object> parameters = new HashMap<String, Object>();
        
        parameters.put("ReportTitle", "List of Contacts");
        parameters.put("Author", "Prepared By Manisha");
        parameters.put("Faktura", faktura);
                
        // Fill parameters
		try {
			filledReport = JasperFillManager.fillReport(parsedJasperFile, parameters, beanColDataSource);
		} catch (JRException e) {
			e.printStackTrace();
		}
		
	}
	
	public void saveToFile() {
		
        try {
        	JasperExportManager.exportReportToPdfFile(filledReport, jasperReportPDF);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
	
}
