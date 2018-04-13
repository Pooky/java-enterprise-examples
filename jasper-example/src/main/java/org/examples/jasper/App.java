package org.examples.jasper;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Path reportTemplatePath = Paths.get("c:\\data\\myfile.txt");
        JasperReport jasperReport = null;
        try  {
        	InputStream template = Files.newInputStream(reportTemplatePath);
            jasperReport = JasperCompileManager.compileReport(template);
        } catch (JRException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        jasperReport.
    }
}
