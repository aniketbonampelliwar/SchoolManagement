package com.techdenovo.app.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtils {
	
    final private String url ="jdbc:mysql://localhost:3306/studentDB";
    final private String dbUsername = "root";
    final private String password = "root";

    public Connection getDbConnection(){
    	
        Connection connection=null;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,dbUsername,password);
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}