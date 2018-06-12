package fr.exemple.newservlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.ex.dao.MessageDao;
import fr.ex.dao.UserDao;
import fr.ex.entity.Message;
import fr.ex.entity.User;

@WebServlet("/messages")
public class MessageServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private MessageDao mdao = new MessageDao();

	public MessageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Message> messages = mdao.getAll();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//On récupère le message de l'utilisateur
		String msg = request.getParameter("user-message");
		Message m = new Message ();
		m.setText(msg);
		//On récupère sa session
		HttpSession session = request.getSession(true);
		//On demande s'il est connecté
		Boolean connected = (boolean) session.getAttribute("connected");
		//Si il est connecté, on récupère ses infos enregistrées dans la session
		if(connected != null && connected) {
			User user = (User) session.getAttribute("user");
			//On vérifie qu'il y ait bien un objet user dans la session
			if (user != null && user.getId() != 0) {
				m.setUserID(user.getId());
				java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
				m.setDate(sqlDate);
				//On sauvegarde le message
				mdao.save(m);
			}
			else {
				System.out.println("Déconnecté, retour vers login");
				response.sendRedirect(request.getContextPath()+"/login");
			}
		}
	}

}
