package servlets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import classes.Livro;

@WebServlet(name="/livrariaServlet")
public class LivrariaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = request.getReader();
		String reqData = null;
        while ((reqData = br.readLine()) != null) {
            sb.append(reqData);
        }
        
        JSONObject jObj = new JSONObject(sb.toString());
        
        //TODO: Transformar em um objeto e mandar para o banco de dados
        Livro livro = new Livro(jObj.getString("nome"), jObj.getString("autor"),jObj.getString("genero"));
        
	}
	
	
	

}
