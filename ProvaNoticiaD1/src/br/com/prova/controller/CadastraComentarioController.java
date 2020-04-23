package br.com.prova.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.prova.model.ComentarioModel;
import br.com.prova.service.ComentarioService;

/**
 * Servlet reponsável por cadastrar um comentário
 */
@WebServlet("/cadastraComentario.do")
public class CadastraComentarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	private final ComentarioService comentarioService = new ComentarioService();
	/**
	 * Método responsável por cadastrar um comentário
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao= request.getSession();
		Integer pk = (Integer) sessao.getAttribute("pk");
		
		ComentarioModel comentarioModel =  new ComentarioModel();
		comentarioModel.setNome(request.getParameter("nome"));
		comentarioModel.setComentario(request.getParameter("comentario"));	
		comentarioModel.setPk(pk);

		comentarioService.inserir(comentarioModel);
	}

}
