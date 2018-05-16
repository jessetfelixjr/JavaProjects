package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import classes.Livro;

public class ConsultaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Livro> livros = new ArrayList<Livro>();
		
		livros.add(new Livro("Harry Potter", "J. K. Rowling", "Drama"));
		livros.add(new Livro("A Menina que Roubava Livros", "Markus Zusak", "Romance"));
		livros.add(new Livro("A Cabana", "William P. Young", "Drama"));
		livros.add(new Livro("Coluna de Fogo", "Ken Follet", "Romance"));
		
		
		JSONArray arrayLivros = new JSONArray(livros);
		response.getWriter().write(arrayLivros.toString());
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}
	
	

}
