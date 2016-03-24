package server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * Главный сервлет, проверяет корректность параметров. 
 * Выкидывает на страницу с ошибкой и записывает в лог ошибку при возниакновении последней.
 * Если все в порядке, перенаправляет запрос на страницу с выбором картинки. 
*/

@WebServlet("/Dispatcher")
public class DispatcherServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public DispatcherServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		
		try{
			//Полуаем номер пользователя. По умолчанию "a".
			String clientNumber = request.getParameter("a");     
			
			//Проверка на наличие данного параметра и его непустоту
			// в противном случае, перенапавляет на страницу с ошибкой
			if (clientNumber == null || clientNumber.isEmpty()){
				response.sendRedirect("error.html");
				return;
			}
			/*
			 * Записываем номер клиента в сессию запроса, для 
			 * дальнейшей аутентификации пользователя. 
			 */
			HttpSession session =  request.getSession(true);
			session.setAttribute("clientNumber", clientNumber);
			
			//Переходим на страницу с картинками.
			getServletContext().getRequestDispatcher("/RecallPage.jsp").forward(request, response);
		}
		/*
		 * При возникновении ошибки переход на страницу ошибки 
		 * стэктрейс записывается в лог сервера.
		 */
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
