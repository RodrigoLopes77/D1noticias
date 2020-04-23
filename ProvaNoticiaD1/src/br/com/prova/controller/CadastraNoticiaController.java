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
 * Servlet responsável por conter o método post
 * para receber os dados vindos do html
 * e mandar para o cadastro no banco
 */
@WebServlet("/cadastraNoticiaController")
public class CadastraNoticiaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final NoticiaService noticiaService = new NoticiaService();

	/**
	 * Método responsável pela chamada da service
	 * para cadastro no banco de dados
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NoticiaModel noticiaModel = new NoticiaModel();
		noticiaModel.setDescricao(request.getParameter("descricao"));
		noticiaModel.setTitulo(request.getParameter("titulo"));
		noticiaModel.setTexto(request.getParameter("texto"));
		
		noticiaService.inserir(noticiaModel);
	}

}
