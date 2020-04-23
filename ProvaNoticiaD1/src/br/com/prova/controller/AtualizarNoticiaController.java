package br.com.prova.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.prova.model.NoticiaModel;
import br.com.prova.service.NoticiaService;

/**
 * Servlet responsável por fazer a chamada
 * da service para atualizar uma noticia
 */
@WebServlet("/atualizarNoticiaController.do")
public class AtualizarNoticiaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final NoticiaService noticiaService = new NoticiaService();

	/**
	 * Método responsável por fazer a chamada da service
	 * para atualizar uma noticia
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		NoticiaModel noticiaModel = new NoticiaModel();
		noticiaModel.setDescricao(request.getParameter("descricao"));
		noticiaModel.setTitulo(request.getParameter("titulo"));
		noticiaModel.setTexto(request.getParameter("texto"));
		
		noticiaService.alterar(id, noticiaModel);
	}

}
