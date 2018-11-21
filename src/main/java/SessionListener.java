
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Web application lifecycle listener.
 *
 * @author c
 */
public class SessionListener implements HttpSessionListener {
    
    private int nbJoueur=0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        nbJoueur++;
        se.getSession().getServletContext().setAttribute("nbJoueur", nbJoueur);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        nbJoueur--;
        se.getSession().getServletContext().setAttribute("nbJoueur", nbJoueur);
    }
}
