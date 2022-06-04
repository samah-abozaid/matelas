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
@WebServlet(name = "PanierServlet", urlPatterns = {"/panier"})
public class PanierServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PannierServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PannierServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
         
     HttpSession session = request.getSession();
        
        
        ArrayList<PanierItem> panier = (ArrayList<PanierItem>)session.getAttribute("panier");
        if(panier == null) {
           panier = new ArrayList<>();
        }
        request.setAttribute("panier", panier);
        
        int totalAPayer = 0;
        Stock stock = (Stock)session.getAttribute("stock");
        
        for(PanierItem item: panier){
            Long id = item.getMatelasId();
            int quantite = item.getQuantite();
            
            
            for(Matelas matelas: stock.stock){
                if(matelas.getId().equals(id)){
                    totalAPayer += matelas.getPrix() * quantite;
                }
            }
        }
        
        
        
        request.setAttribute("totalAPayer", totalAPayer);
        
        
        
        request.getServletContext().getRequestDispatcher("/WEB-INF/panier.jsp")
              .forward(request, response);
     
     }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   Long matelasId = Long.parseLong(request.getParameter("matelasId"));
       System.out.println("ID: "+matelasId);

       HttpSession session = request.getSession();
       
       ArrayList<PanierItem> panier = (ArrayList<PanierItem>)session.getAttribute("panier");
       if(panier == null) {
           panier = new ArrayList<>();
       }
       
       boolean produitExistantDansPanier = false;
       /*
        for(PanierItem item: panier){
           if(item.getMatelasId().equals(matelasId)){
               item.setQuantite(item.getQuantite()+1);
               produitExistantDansPanier = true;
           }
       }*/
       // On optimise la boucle pour arreter le parcours du Panier 
       // si on a trouvé l'élément qu'on cherchait
       // On choisit donc un while avec une double condition
       int i = 0;
       while(i<panier.size() && !produitExistantDansPanier) {
           PanierItem item = panier.get(i);
           if(item.getMatelasId().equals(matelasId)){
               item.setQuantite(item.getQuantite()+1);
               produitExistantDansPanier = true;
           }
           i++;
       }
       if(! produitExistantDansPanier){
           panier.add(new PanierItem(matelasId, 1));
       }

       session.setAttribute("panier", panier);
       
       // afficher la page Panier
       doGet(request, response);
    }

    

}

