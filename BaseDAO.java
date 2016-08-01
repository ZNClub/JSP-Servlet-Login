/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import controller.RegisterServlet;

/**
 *
 * @author universe
 */
public class BaseDAO {
	// for database connection using jdbc jar
    private Connection con;
	
	// for SQL query which is to be executed
    PreparedStatement preparedStatement;
    Statement statement;
	
	// for result to be stored after fetching from database
    ResultSet rs;
	
	// model object to store database table data
    Person p;
    
    public Connection getConnection() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
        Class.forName("com.mysql.jdbc.Driver");
											//jdbc:mysql://localhost:3306/database_name,username,password					
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_health","root","root");
        return con;
    }
    
     public void closeConnection() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    
    }
     
     
     
