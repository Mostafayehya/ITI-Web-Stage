/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import jakarta.servlet.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moust
 */
public class ServletContextListenerImpl implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
//
//        String line;
//        int userCount=0,pageHits=0;
//        String[] arr = new String[2];
//        try {
//            BufferedReader bufferreader = new BufferedReader(new FileReader("E:\\ITI 2020\\ITI-Web-Stage\\Servlets and JSP\\day7\\data.txt"));
//
//            for(int i =0; i<2 && ((line = bufferreader.readLine()) != null) ;i++) {
//                arr[i] = line;
//               System.out.println("===============================================");
//               System.out.println("===============================================");
//               System.out.println(line);
//
//            }

        System.out.println("===============================================");
        System.out.println("===============================================");
        Logger.getLogger(ServletContextListenerImpl.class.getName()).log(Level.SEVERE, null,
                "==============================================="
                + "==============================================="
                + " ContextInitialized===============================================");

//            userCount = Integer.parseInt(arr[0]);
//            pageHits = Integer.parseInt(arr[1]);
//            
//            sce.getServletContext().setAttribute("userCount", userCount);
//            sce.getServletContext().setAttribute("pageHits", pageHits);
//            
//            bufferreader.close();
//
//
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ServletContextListenerImpl.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(ServletContextListenerImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        try {
            FileWriter fileWriter = new FileWriter("E:\\ITI 2020\\ITI-Web-Stage\\Servlets and JSP\\day7\\data.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            System.out.println("===============================================");
            System.out.println("===============================================");
            System.out.println((Integer) sce.getServletContext().getAttribute("pageHits"));


            fileWriter.flush();

            printWriter.println((Integer) sce.getServletContext().getAttribute("pageHits"));

            printWriter.close();
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(ServletContextListenerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
