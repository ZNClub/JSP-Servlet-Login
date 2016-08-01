/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;

/**
 *
 * @author ?
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            
                Login l = new Login();      //classify types
            
             LoginDAO cdao = new LoginDAO();  //classify types
             boolean b;
             
            l.setUserName(request.getParameter("userName"));
            l.setPassWord(request.getParameter("passWord"));
            System.out.println("In LoginServlet....");
            String name=request.getParameter("email");  
            b = cdao.checkLogin(l);
            if(b)
            {	
                System.out.println("in if");
                
				// get details from BaseDAO 
				BaseDAO bdao=new BaseDAO();
				
				//Person p = new Person();
				
				Person p = bdao.setProfile(l);
				//set Person as sessionScope
				
				
				//set Person as requestScope
				
				
				
				//request.setAttribute("Person",p);
                
				HttpSession session=request.getSession();  
                                session.setAttribute("Person",p);  
				session.setAttribute("userName",p.getEmail());  
                

                RequestDispatcher rd;
                if(l.getType().equals("p"))
                rd = request.getRequestDispatcher("profile.jsp");
                else
                    rd = request.getRequestDispatcher("adminprofile.jsp");
                rd.forward(request, response);
            }                
            else
            {
                System.out.println("in else");
               response.sendRedirect("login.jsp");
            }   
            /*
                HttpSession session = request.getSession(false);// don't create if it doesn't exist
        if(session != null && !session.isNew()) {
                RequestDispatcher rd;
                rd = request.getRequestDispatcher("profile.jsp");               
                rd.forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }*/
            }
        
            
                
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
