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
/**
 *
 * @author universe
 */
public class LoginDAO extends BaseDAO {
    
        
    Connection connection;
    PreparedStatement preparedStatement;
    Statement statement;
    ResultSet rs;
           
    public boolean checkLogin(Login l) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {               
        connection = getConnection();
        String sql = "SELECT * FROM e_health.registration WHERE email='"+l.getUserName()+"' AND password='"+l.getPassWord()+"'";
        try {
            statement = (Statement) connection.createStatement();
            rs = statement.executeQuery(sql);
            if(rs.next()){
                l.setType("p");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      System.out.println("after registration table");
        String sql1 = "SELECT * FROM e_health.admin WHERE ad_username='"+l.getUserName()+"' AND ad_pass='"+l.getPassWord()+"'";
        try {
            statement = (Statement) connection.createStatement();
            rs = statement.executeQuery(sql1);
            System.out.println("in admin table");
            if(rs.next()){
                l.setType("a");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        System.out.println("not admin");    
        return false;
    }
}
