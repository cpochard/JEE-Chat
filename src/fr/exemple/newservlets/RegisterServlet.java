package fr.exemple.newservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ex.dao.UserDao;
import fr.ex.entity.User;

/**
 * Servlet implementation class RegisterServlet description = "Lié à
 * l'enregistrement des utilisateurs"
 */
// Veut dire ceci est une servlet, son url est /register.
@WebServlet(urlPatterns = { "/register" })
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserDao udao = new UserDao();

	public RegisterServlet() {
		super();
	}
	/**
	 * Affichage de la page register
	 * url : /register
	 * methode : get
	 */
	//Le doGet contient la requete faite par l'utilisateur et la réponse
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//on configure le requestdispatcher pour lui indiquer le chemin du fichier à récupérer avec le request
		RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/register.jsp");
		//on exécute le passage du servlet à la page register.jsp grace à forward
		rd.forward(request, response);
	}
	/**
	 * Création d'un compte
	 * url : /register
	 * methode : post
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//on récupère les infos de l'utilisateur qui sont transformées en requête http (pour s'enregistrer)
		String login = request.getParameter("champs_login");
		String password = request.getParameter("champs_password");
		
		User u = new User();
		u.setLogin(login);
		u.setPassword(password);
		//on sauvegarde l'utilisateur
		udao.save(u);
		
		System.out.println(u);
	}
}
