package com.sdzee.tp.servlets;

import com.sdzee.tp.beans.Utilisateur;
import com.sdzee.tp.forms.ConnexionForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Connexion")
public class Connexion extends HttpServlet {
    public static final String view = "/connexion.jsp";
    public static final String userSession = "sessionUtilisateur";

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(view).forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ConnexionForm connexionForm = new ConnexionForm();
        Utilisateur utilisateur = connexionForm.connecterUtilisateur(req);
        HttpSession session = req.getSession();
        //get error si pas -> setsessionattribute sinon =null // set attribut requête

        if(connexionForm.getErreurs().isEmpty()){
            session.setAttribute("sessionUtilisateur",utilisateur);
        }else {
            session.setAttribute("sessionUtilisateur", null);
        }

        req.setAttribute("form",connexionForm);
        req.setAttribute("utilisateur", utilisateur);
        this.getServletContext().getRequestDispatcher(view).forward(req, resp);
    }
}




