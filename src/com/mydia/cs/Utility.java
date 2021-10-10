/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mydia.cs;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utility {
    
        public static String dbpassword;
        public static String dbusername;
        public static String dbport;
    
        public static boolean createNewDb (String databaseName ,String pw, String pt, String uname)
{
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:"+pt+"/", uname,pw);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE DATABASE " + databaseName);
            conn.close();
            return true;
        } catch (Exception e) {
            return false;
        }
}
        
       public static boolean setSeedDatabase(String databaseName ,String pw, String pt, String uname)
{       
       Connection connection = null;
       boolean result = false;
       try {
           
            connection = DriverManager.getConnection("jdbc:mysql://localhost:"+pt+"/"+ databaseName, uname,pw);
            Statement stmt = connection.createStatement();
            String employeetbl = 
                    "CREATE TABLE `employee` (\n" +
                         "     `employeeid` int NOT NULL AUTO_INCREMENT,\n" +
                         "     `role` varchar(50) NOT NULL,\n" +
                         "     `fullname` varchar(50) NOT NULL,\n" +
                         "     `email` varchar(100) NOT NULL,\n" +
                         "     `phonenumber` varchar(10) NOT NULL,\n" +
                         "     `salary` double NOT NULL,\n" +
                         "     `username` varchar(50) NOT NULL,\n" +
                         "     `password` varchar(50) NOT NULL,\n" +
                         "     PRIMARY KEY (`employeeid`)\n" +
                         "     ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";
            stmt.executeUpdate(employeetbl);
            String logintrackertbl = 
                    "CREATE TABLE `logintracker` (\n" +
                         "     `logintrackerid` int NOT NULL AUTO_INCREMENT,\n" +
                         "     `username` varchar(45) NOT NULL,\n" +
                         "      PRIMARY KEY (`logintrackerid`)\n" +
                         "     ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";
            stmt.executeUpdate(logintrackertbl);
            String managertbl = 
                    "CREATE TABLE `manager` (\n" +
                         "     `managerid` int NOT NULL AUTO_INCREMENT,\n" +
                         "     `fullname` varchar(50) NOT NULL,\n" +
                         "     `email` varchar(100) NOT NULL,\n" +
                         "     `phonenumber` varchar(10) NOT NULL,\n" +
                         "     `username` varchar(50) NOT NULL,\n" +
                         "     `password` varchar(50) NOT NULL,\n" +
                         "      PRIMARY KEY (`managerid`)\n" +
                         "     ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";
            stmt.executeUpdate(managertbl);
            String studenttbl = 
                    "CREATE TABLE `student` (\n" +
                         "     `studentid` int NOT NULL AUTO_INCREMENT,\n" +
                         "     `fullname` varchar(50) NOT NULL,\n" +
                         "     `email` varchar(100) NOT NULL,\n" +
                         "     `dob` date NOT NULL,\n" +
                         "     `phonenumber` varchar(10) NOT NULL,\n" +
                         "     `username` varchar(50) NOT NULL,\n" +
                         "     `password` varchar(50) NOT NULL,\n" +
                         "     PRIMARY KEY (`studentid`)\n" +                    
                         "     ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";
            stmt.executeUpdate(studenttbl);
                        String transactiontbl = 
                    "CREATE TABLE `transaction` (\n" +
                         "   `transactionid` int NOT NULL AUTO_INCREMENT,\n" +
                         "   `name` varchar(50) NOT NULL,\n" +
                         "   `inflow` tinyint NOT NULL,\n" +
                         "   `date` date NOT NULL,\n" +
                         "   `totalamount` decimal(10,0) NOT NULL,\n" +
                         "    PRIMARY KEY (`transactionid`)\n" +
                         "  ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";
            stmt.executeUpdate(transactiontbl);
                                    String classtbl = 
                    "CREATE TABLE `class` (\n" +
                         "     `classid` int NOT NULL AUTO_INCREMENT,\n" +
                         "     `employeeid` int DEFAULT NULL,\n" +
                         "     `date` date NOT NULL,\n" +
                         "     `starttime` time NOT NULL,\n" +
                         "     `endtime` time NOT NULL,\n" +
                         "     PRIMARY KEY (`classid`),\n" +
                         "     KEY `employeeid_idx` (`employeeid`),\n" +
                         "     CONSTRAINT `employeeid` FOREIGN KEY (`employeeid`) REFERENCES `employee` (`employeeid`)\n" +
                         "     ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";
            stmt.executeUpdate(classtbl);
            String classstudenttbl = 
                    "CREATE TABLE `class_student` (\n" +
                         "     `enrollmentid` int NOT NULL AUTO_INCREMENT,\n" +
                         "       `classid` int NOT NULL,\n" +
                         "       `studentid` int NOT NULL,\n" +
                         "     PRIMARY KEY (`enrollmentid`),\n" +
                         "     KEY `classid_idx` (`classid`),\n" +
                         "     KEY `studentid_idx` (`studentid`),\n" +
                         "     CONSTRAINT `classid` FOREIGN KEY (`classid`) REFERENCES `class` (`classid`),\n" +
                         "       CONSTRAINT `studentid` FOREIGN KEY (`studentid`) REFERENCES `student` (`studentid`)\n" +
                         "     ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";
            stmt.executeUpdate(classstudenttbl);
            String paymenttbl = 
                    "CREATE TABLE `payment` (\n" +
                         "       `paymentid` int NOT NULL AUTO_INCREMENT,\n" +
                         "       `studentid` int NOT NULL,\n" +
                         "       `date` date NOT NULL,\n" +
                         "     `totalamount` decimal(10,0) NOT NULL,\n" +
                         "     `paid` tinyint NOT NULL,\n" +
                         "     PRIMARY KEY (`paymentid`),\n" +
                         "     KEY `studentid_fk1_idx` (`studentid`),\n" +
                         "     CONSTRAINT `studentid_fk1` FOREIGN KEY (`studentid`) REFERENCES `student` (`studentid`)\n" +
                         "     ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";
            stmt.executeUpdate(paymenttbl);
            String progresstbl = 
                    "CREATE TABLE `progress` (\n" +
                         "  `progressid` int NOT NULL AUTO_INCREMENT,\n" +
                         "  `studentid` int NOT NULL,\n" +
                         "  `employeeid` int NOT NULL,\n" +
                         "  `matchesplayed` int NOT NULL,\n" +
                         "  `wins` int NOT NULL,\n" +
                         "  `tournamentvictories` int NOT NULL,\n" +
                         "  `pointsplayed` int NOT NULL,\n" +
                         "  `pointswon` int NOT NULL,\n" +
                         "  `gamesplayed` int NOT NULL,\n" +
                         "  `gameswon` int NOT NULL,\n" +
                         "  `serves` int NOT NULL,\n" +
                         "  `serveswon` int NOT NULL,\n" +
                         "  `aces` int NOT NULL,\n" +
                         "  `doublefaults` int NOT NULL,\n" +
                         "  `breakpointsplayed` int NOT NULL,\n" +
                         "  `breakpointswon` int NOT NULL,\n" +
                         "   PRIMARY KEY (`progressid`),\n" +
                         "   KEY `studentid_fk2_idx` (`studentid`),\n" +
                         "   KEY `employeeid_fk2_idx` (`employeeid`),\n" +
                         "   CONSTRAINT `employeeid_fk2` FOREIGN KEY (`employeeid`) REFERENCES `employee` (`employeeid`),\n" +
                         "   CONSTRAINT `studentid_fk2` FOREIGN KEY (`studentid`) REFERENCES `student` (`studentid`)\n" +
                         "   ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";
            stmt.executeUpdate(progresstbl);
            String remindertbl = 
                    "CREATE TABLE `reminder` (\n" +
                         "     `reminderid` int NOT NULL AUTO_INCREMENT,\n" +
                         "     `date` date NOT NULL,\n" +
                         "     `time` time NOT NULL,\n" +
                         "     `studentid` int NOT NULL,\n" +
                         "     PRIMARY KEY (`reminderid`),\n" +
                         "     KEY `studentid_idx` (`studentid`),\n" +
                         "     CONSTRAINT `studentid_fk` FOREIGN KEY (`studentid`) REFERENCES `student` (`studentid`)\n" +
                         "     ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";
            stmt.executeUpdate(remindertbl);
            String tournamenttbl = 
                    "CREATE TABLE `tournament` (\n" +
                         "     `tournamentid` int NOT NULL AUTO_INCREMENT,\n" +
                         "     `tournamenttype` varchar(45) NOT NULL,\n" +
                         "     `completed` tinyint NOT NULL,\n" +
                         "     `numberofplayers` int NOT NULL,\n" +
                         "     `date` date NOT NULL,\n" +
                         "     `starttime` time NOT NULL,\n" +
                         "     `endtime` time NOT NULL,\n" +
                         "     `employeeid` int NOT NULL,\n" +   
                         "     `winner_studentid` int DEFAULT NULL,\n" +   
                         "     PRIMARY KEY (`tournamentid`),\n" + 
                         "     KEY `employeeid_fk3_idx` (`employeeid`),\n" +
                         "     KEY `studentid_fk3_idx` (`winner_studentid`),\n" +
                         "     CONSTRAINT `employeeid_fk3` FOREIGN KEY (`employeeid`) REFERENCES `employee` (`employeeid`),\n" +
                         "     CONSTRAINT `studentid_fk3` FOREIGN KEY (`winner_studentid`) REFERENCES `student` (`studentid`)\n" +
                         "     ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";
            stmt.executeUpdate(tournamenttbl);
            result =  true;
        } 
        catch (Exception e) {
            result =  false;
        }
        finally{
           try {
               if (connection!=null){
                connection.close();
               }
           } catch (SQLException ex) {}
            return result;
       }
    }
    
}
