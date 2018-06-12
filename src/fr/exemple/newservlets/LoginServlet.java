package fr.exemple.newservlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.ex.dao.UserDao;
import fr.ex.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao udao = new UserDao();

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// on récupère le pseudo et le mot de passe
		String login = request.getParameter("pseudo");
		String password = request.getParameter("mdp");
		System.out.println("login : " + login + " Password : " + password);
		
		User u = udao.getByLoginPassword(login, password);
		//Si on a un utilisateur correspondant
		if (u != null) {
			//On créé une session dans laquelle on enregistre l'utilisateur et on dit qu'il est connecté
			HttpSession session = request.getSession(true);
			session.setAttribute("user", u);
			session.setAttribute("connected", new Boolean(true));
			// et on affiche la page de chat
			System.out.println("Bien connecté, on redirige vers le  chat");
			response.sendRedirect(request.getContextPath()+"/chat");
		} else {
			// Sinon on réaffiche la page login + messageur erreur
			System.out.println("erreur, on redirige vers la page de login");
			response.sendRedirect(request.getContextPath()+"/login");
		}
	}
	// .Pas utile dans notre cas,service, ça fait tout, doget, dopost. Il fait
	// toujours service en premier, prioritaire.

}
