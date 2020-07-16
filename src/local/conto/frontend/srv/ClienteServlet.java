package local.conto.frontend.srv;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.annotation.Resource;

import local.conto.backend.bean.ClienteB;
import local.conto.backend.ejb.ClienteEjbRemote;

/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(mappedName = "java:jboss/exported/local.conto.backend/ClienteEJB!local.conto.backend.ejb.ClienteEjbRemote")
	private ClienteEjbRemote clienteEjb;
    /**
     * Default constructor. 
     */
    public ClienteServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("entra doGet");
		
		System.out.println(clienteEjb.insertCliente(Optional.of(new ClienteB("jefry","serrano"))));
		System.out.println("doGet dopo insert");
		System.out.println(clienteEjb.getClientebyId(5).toString());
		System.out.println("doGet dopo get");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
