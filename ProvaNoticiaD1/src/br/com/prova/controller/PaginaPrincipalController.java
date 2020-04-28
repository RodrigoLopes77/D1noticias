package br.com.prova.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.prova.model.ComentarioModel;
import br.com.prova.model.NoticiaModel;
import br.com.prova.service.ComentarioService;
import br.com.prova.service.NoticiaService;

/**
 * Servlet responsavel por receber os comentarios e 
 * listar noticias e comentários
 */
@WebServlet("/paginaPrincipalController.do")
public class PaginaPrincipalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final NoticiaService noticiaService = new NoticiaService();

	/**
	 * Método responsavel por fazer as listagens 
	 * da página principal
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<NoticiaModel> listaNoticiaModel = noticiaService.listar();
		
		for(NoticiaModel noticiaModel : listaNoticiaModel) {
			
			response.getWriter().println("<h1>" + noticiaModel.getTitulo() + "</h1>" 
										+"<h3>" + noticiaModel.getDescricao() + "</h3>" 
										+"<p>" + noticiaModel.getTexto() + "</p>");
			
			ComentarioService comentarioService = new ComentarioService();
			List<ComentarioModel> listaComentarioModel = comentarioService.listar(noticiaModel.getId());
			HttpSession sessao= request.getSession();
			sessao.setAttribute("pk", noticiaModel.getId());
			for(ComentarioModel comentarioModel : listaComentarioModel) {
				
			response.getWriter().println("<hr/>"+"<h5> Nome: " + comentarioModel.getNome() + "</h5>"
										+"<p> Comentário: " + comentarioModel.getComentario() + "</p>"+"<hr/>");
				
			}
			
			response.getWriter().println("<form method=\"post\" action=\"cadastraComentario.do\">"
										+"<br/>"
										+"<br/>"
										+ "<small> <p> Adicionar comentário: </p> </small>"
										+"<p><small> Nome: <small></p>"
										+"<input type=\"text\" value=\"\" name=\"nome\" />"
									    +"<br/>"
									    +"<br/>"
										+"<input type=\"text\" value=\"\" name=\"comentario\" />"
									    +"<input type=\"submit\" value=\"Comentar\" />"
										+"</form>"+"<hr/>");
		}
		
	}

}
