package br.com.prova.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.prova.service.NoticiaService;

/**
 * Servlet responsável por fazer a chamada da service
 * para exclusão de uma noticia 
 */
@WebServlet("/excluirNoticia.do")
public class ExcluirNoticiaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final NoticiaService noticiaService = new NoticiaService();

	/**
	 * Método responsável por fazer a chamada da service
	 * para excluir uma noticia de acordo com o id
	 * passado pela pessoa
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer idNoticia = Integer.parseInt(request.getParameter("id"));
		
		noticiaService.excluir(idNoticia);
	}

}
