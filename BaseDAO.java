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
    private Connection con;
    PreparedStatement preparedStatement;
    Statement statement;
    ResultSet rs;
    Person p;
    
    public Connection getConnection() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
        Class.forName("com.mysql.jdbc.Driver");
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
     
     public int removePersonByEmail(String email) throws InstantiationException, IllegalAccessException
    {int count = 0;
        //Login l;
        try {
            con = getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sql1 = "SELECT type FROM e_health.person where email ='"+email+"'";
       
        try {
            statement = (Statement) con.createStatement();
            rs = statement.executeQuery(sql1);
            if(rs.next()){
                System.out.println("Its not null");
            }
            System.out.println(rs);
            String type = rs.getString("type");
             System.out.println(type);
            if(type.equals("Patient"))
        {
            String sql3="delete from e_health.patient where email = ?";
        try {
            preparedStatement= con.prepareStatement(sql3);
          
             preparedStatement.setString(1,email);
                count = preparedStatement.executeUpdate();
                 if(count>0)
                {
                    System.out.println("Successfully Deleted");
                }else{
                    System.out.println("Deletion failed");
                }
                
             
        } catch (SQLException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
            
           else if(type.equals("Doctor"))
        {
            String sql4="delete from e_health.doctor where email = ?";
        try {
            preparedStatement= con.prepareStatement(sql4);
          
             preparedStatement.setString(1,email);
                count = preparedStatement.executeUpdate();
                 if(count>0)
                {
                    System.out.println("Successfully Deleted");
                }else{
                    System.out.println("Deletion failed");
                }
                
             
        } catch (SQLException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
            
            else if(type.equals("Pathologist"))
        {
            String sql5="delete from e_health.pathologist where email = ?";
        try {
            preparedStatement= con.prepareStatement(sql5);
          
             preparedStatement.setString(1,email);
                count = preparedStatement.executeUpdate();
                 if(count>0)
                {
                    System.out.println("Successfully Deleted");
                }else{
                    System.out.println("Deletion failed");
                }
                
             
        } catch (SQLException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
            
            else if(type.equals("Pharmacist"))
        {
            String sql6="delete from e_health.pharmacist where email = ?";
        try {
            preparedStatement= con.prepareStatement(sql6);
          
             preparedStatement.setString(1,email);
                count = preparedStatement.executeUpdate();
                 if(count>0)
                {
                    System.out.println("Successfully Deleted");
                }else{
                    System.out.println("Deletion failed");
                }
                
             
        } catch (SQLException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
                
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sql="delete from e_health.person where email = ?";
        try {
            preparedStatement= con.prepareStatement(sql);
          
             preparedStatement.setString(1,email);
                count = preparedStatement.executeUpdate();
                 if(count>0)
                {
                    System.out.println("Successfully Deleted");
                }else{
                    System.out.println("Deletion failed");
                }
                
             
        } catch (SQLException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sql2="delete from e_health.registration where email = ?";
        try {
            preparedStatement= con.prepareStatement(sql2);
          
             preparedStatement.setString(1,email);
                count = preparedStatement.executeUpdate();
                 if(count>0)
                {
                    System.out.println("Successfully Deleted");
                }else{
                    System.out.println("Deletion failed");
                }
                
             
        } catch (SQLException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
              return count;
    }
     
    public Person setProfile(Login l) {
        Person p=new Person();
        Connection connection=null;
        
        try {
            connection = getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sql = "select * from e_health.person where email='"+l.getUserName()+"'";
            
        try {
            
            statement = (Statement) connection.createStatement();
			
            rs = statement.executeQuery(sql);
			
            System.out.println("in person query is set");
            
             //if(rs.next())
            //   return true;
		
			while(rs.next()){
				//rs.getString()
				p.setFirstName(rs.getString(1));
				
				p.setLastName(rs.getString(2));
				
				p.setStreet(rs.getString(3));
				
				p.setApartmentNumber(rs.getString(4));
				
				p.setCity(rs.getString(5));
				
				p.setZipCode(rs.getString(6));
				
				p.setPhone(rs.getString(7));
				
				p.setSex(rs.getString(8));
				
				p.setEmail(rs.getString(9));
                                String email = rs.getString(9);
				
				p.setDob(rs.getString(10));
				
				p.setType(rs.getString(11));
				
				
				
				//return p;
			}
        }
        catch(SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 

        
        
        return p;
    } 
     
     
    public String generateOTP(){
       String otp = Long.toString(Math.round(Math.random()*20000));
       return otp;
        
    }
     
    public void storeOTP(String otp, String email) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
        
        con = getConnection();
        
        
        System.out.println(email);
        System.out.println(otp);
        //15 ?
        //person
        String sql = "insert into e_health.registration values(?,?)";
        //id,fname,lname,street,aptno,city,zip,phone,sex,email,dob,type,labname,labaddr,labid
        try {
            preparedStatement = con.prepareStatement(sql);
         
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, otp);
            

            //preparedStatement.setString(1, c.getAadhar_no());
            //preparedStatement.setString(3, c.getBlood_group());

            int count = preparedStatement.executeUpdate();

            if (count > 0) {
                System.out.println("Successfully Inserted");
            } else {
                System.out.println("insertion failed");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
       

    }

    }
     
     
     
