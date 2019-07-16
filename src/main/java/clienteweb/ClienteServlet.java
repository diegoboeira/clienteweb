package clienteweb;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetofinal.model.Cliente;

@WebServlet(urlPatterns = {"/cliente", "/clientServlet", "/clienteController"})
public class ClienteServlet extends HttpServlet{
	
	List<Cliente> lista = new ArrayList<>();
	
	public ClienteServlet() {
		System.out.println("Construindo Servlet...");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("Inicializando Servlet...");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Chamando o service...");
		super.service(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp");
		req.setAttribute("lista", lista);
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// recebendo email
		String email = req.getParameter("email");
		
		//colocando email em um objeto cliente
		Cliente cli = new Cliente();
		cli.setEmail(email);
		
		//adicionando o objeto cliente na lista de cliente
		
		lista.add(cli);
		 
		resp.sendRedirect("cliente");
		//resp.setCharacterEncoding("UTF-8");
		//resp.getWriter().print("confirme email cadastrado: "+ email);
		//System.out.println("Chamou pelo método POST");
	}
	
	@Override
	public void destroy() {
		System.out.println("Servlet esta sendo destruido");
		super.destroy();
	}
	
}
