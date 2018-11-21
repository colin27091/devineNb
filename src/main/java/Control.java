/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name= "Control", urlPatterns = {"/Control"})
public class Control extends HttpServlet {

    playerDevine player;
    playerDevine bestPlayer;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name");
        String action = request.getParameter("action");
        String proposition = request.getParameter("proposition");
        
        
        if("Connexion".equals(action)){
            if(name.length() == 0){
                request.setAttribute("message", "Vous n'avez pas choisi de nom");
                request.getRequestDispatcher("connexion.jsp").forward(request, response);
            }else{
                player = new playerDevine(name);
                System.out.println(player.nbAlea);
                request.setAttribute("name", name);
                request.getRequestDispatcher("devine.jsp").forward(request, response);
            }
            
        } else if("Deviner".equals(action)){
            int prop = Integer.valueOf(proposition);
            player.essai ++;
            if(prop == player.nbAlea){
                if(bestPlayer == null || bestPlayer.essai < player.essai){
                    bestPlayer = player;
                }
                
                request.setAttribute("essai", player.essai);
                request.getRequestDispatcher("winPage.jsp").forward(request, response);
            } else {

               request.setAttribute("choix", prop);
               request.setAttribute("essai", player.essai);
               if(prop > player.nbAlea){
                   request.setAttribute("bas", 1);
               } else {
                   request.setAttribute("haut", 1);
               }
        
               
               request.getRequestDispatcher("devine.jsp").forward(request, response);
            }
        } else if("Rejouer".equals(action)){
            if(bestPlayer != null){
                   request.setAttribute("bestEssai", bestPlayer.essai);
                   request.setAttribute("bestName", bestPlayer.name);
               }
            player = new playerDevine(player.name);
            request.getRequestDispatcher("devine.jsp").forward(request, response);
        }
        request.getRequestDispatcher("connexion.jsp").forward(request, response);
        
        
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
        processRequest(request, response);
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
        processRequest(request, response);
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
