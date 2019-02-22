package br.com.guacom.lembrete.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LembretesServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = String.valueOf(req.getParameter("title"));
		PrintWriter out = resp.getWriter();
		
		out.println("<html><body>");
		out.println("<p>O título " + title+ " foi cadastrado!</p>");
		out.println("</body></html>");
		System.out.println(title);
	}
}
