package server;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Сервлет, предназначенный для отправки сообщений, использует бин emailBean.
 * Также осуществляет проверку наличия нужных параметров в сессии, 
 * что исключает случайное обращение к данному сервлету и отправку некорректного сообщения.
 */

@WebServlet("/Email")
public class EmailServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	// Бин для отправки сообщений
	@EJB EmailBean emailBean;
    
    public EmailServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		
		try{
			// Получение сессии из запроса и получение оценки клиента и его номера
			HttpSession session = request.getSession();
			String clientNumber = (String) session.getAttribute("clientNumber");
			String clientMark = request.getParameter("clientMark");
			
			//При отсутствии номера клиента (некорректное обращение к сервлету)  переход на страницу ошибки.
			if (clientNumber == null){
				response.sendRedirect("error.html");
				return;
			}
			//Отправка сообщения с текстом clientMark и темой clientNumber
			emailBean.send(clientNumber, clientMark);
			
			//удаление текущей сессии и отправка на страницу успеха 
			request.getSession().invalidate();
			response.sendRedirect("success.html");
		}
		catch(Exception e){
			e.printStackTrace();
			try {
				response.sendRedirect("error.html");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
