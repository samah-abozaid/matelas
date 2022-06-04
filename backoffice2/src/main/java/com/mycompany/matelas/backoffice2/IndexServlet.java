/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.matelas.backoffice2;

import com.company.matelas.core.entity.Matelas;
import com.company.matelas.core.entity.PanierItem;
import com.company.matelas.core.entity.Stock;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrateur
 */
@WebServlet(name = "IndexServlet", urlPatterns = {"/index"})
public class IndexServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
          
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet IndexServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet IndexServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      
        HttpSession session = request.getSession();
        Stock stock = (Stock)session.getAttribute("stock");
        if(stock == null) {
            stock = new Stock();
            session.setAttribute("stock",stock);
        }

      // La classe Stock contient un attribut qui s'appelle  stock
      // Et ici la variable qui contient l'objet Stock s'appelle aussi stock
      request.setAttribute("stock", stock.stock);
      
      
      
     
       ArrayList<PanierItem> panier = (ArrayList<PanierItem>)session.getAttribute("panier");
       if(panier == null) {
           panier = new ArrayList<>();
       }
       int nombreArticles = 0;
       for (PanierItem item : panier){
           //nombreArticles += item.getQuantite();
           nombreArticles = nombreArticles + item.getQuantite();
       }
      request.setAttribute("quantite", nombreArticles);
        
      request.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp")
              .forward(request, response);
    }
    

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Matelas newMatelas = new Matelas();
        newMatelas.setName(request.getParameter("nom"));
        newMatelas.setPrix(Integer.parseInt(request.getParameter("prix")));
        
        HttpSession session = request.getSession();
        Stock stock = (Stock)session.getAttribute("stock");
        stock.stock.add(newMatelas);
        
        doGet(request, response);
    }
}

    
 


