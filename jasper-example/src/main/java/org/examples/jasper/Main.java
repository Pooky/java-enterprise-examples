package org.examples.jasper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.examples.jasper.entity.Address;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * Jasper report example
 */
public class Main 
{
    public static void main( String[] args )
    {
        System.out.println("--- Jasper report example ---");
        
        String reportName = "exampleReport";
        
        JasperProcessor jasperProcessor = new JasperProcessor(reportName);
        jasperProcessor.parseTemplate();
        
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

        jasperProcessor.insertParamsAndCompile(parameters, beanColDataSource);
        jasperProcessor.exportResultToFile("src/main/resources/output/output.PDF");
        
        System.out.println("--- Done ---");
        
    }
}
