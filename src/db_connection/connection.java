/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_connection;

import com.sap.conn.jco.ext.DestinationDataProvider;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 *
 * @author LABS- 119
 */
public class connection {
    
        public String connection() {
        String DST = "pde";
        Properties connectProperties = new Properties();
        connectProperties.setProperty(DestinationDataProvider.JCO_ASHOST, "172.16.5.17");
        connectProperties.setProperty(DestinationDataProvider.JCO_SYSNR, "00");
        connectProperties.setProperty(DestinationDataProvider.JCO_CLIENT, "120");
        connectProperties.setProperty(DestinationDataProvider.JCO_USER, "qandeel");
        connectProperties.setProperty(DestinationDataProvider.JCO_PASSWD, "labs@12345");
        connectProperties.setProperty(DestinationDataProvider.JCO_LANG, "en");
//       connectProperties.setProperty(DestinationDataProvider.JCO_SAPROUTER,"/H/41.65.1.45/W/<rnF^/hLA@Dh!R6$g<sq&h/H/");
        File destCfg = new File(DST + ".jcoDestination");
        try {
            FileOutputStream fos = new FileOutputStream(destCfg, false);
            System.out.println("qandeela" + fos.getChannel());
            connectProperties.store(fos, "for tests only !");
            fos.close();
        } catch (Exception e) {
            throw new RuntimeException("Unable to create the destination files", e);
        }
   return DST;
    }

    
}
