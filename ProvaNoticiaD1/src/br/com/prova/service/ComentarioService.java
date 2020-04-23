package br.com.prova.service;

import java.util.List;

import br.com.prova.dao.ComentarioDao;
import br.com.prova.model.ComentarioModel;

/**
 * Método responsável por fazer a comunicação
 * com a dao
 *  
 * @author João Vitor
 * @since 20/04/2020
 *
 */
public class ComentarioService {

private ComentarioDao comentarioDao;
	
	public ComentarioService() {
		this.comentarioDao = new ComentarioDao();
	}
	
	/**
	 * Método responsável por listar um comentario
	 * @param idNoticia
	 * @return {@code List<ComentarioModel>} - lista de comentários
	 * 
	 */
	public List<ComentarioModel> listar(Integer idNoticia){
		return comentarioDao.listaComentarios(idNoticia);	
	}

	/**
	 * Método responsável por cadastrar um comentário 
	 * 
	 * @param comentarioModel
	 */
	public void inserir(ComentarioModel comentarioModel) {
		comentarioDao.insereComentario(comentarioModel);
	}
}
