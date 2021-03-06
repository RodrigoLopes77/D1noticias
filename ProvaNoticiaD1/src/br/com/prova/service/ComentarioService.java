package br.com.prova.service;

import java.util.List;

import br.com.prova.dao.ComentarioDao;
import br.com.prova.model.ComentarioModel;

/**
 * M�todo respons�vel por fazer a comunica��o
 * com a dao
 *  
 * @author Jo�o Vitor
 * @since 20/04/2020
 *
 */
public class ComentarioService {

private ComentarioDao comentarioDao;
	
	public ComentarioService() {
		this.comentarioDao = new ComentarioDao();
	}
	
	/**
	 * M�todo respons�vel por listar um comentario
	 * @param idNoticia
	 * @return {@code List<ComentarioModel>} - lista de coment�rios
	 * 
	 */
	public List<ComentarioModel> listar(Integer idNoticia){
		return comentarioDao.listaComentarios(idNoticia);	
	}

	/**
	 * M�todo respons�vel por cadastrar um coment�rio 
	 * 
	 * @param comentarioModel
	 */
	public void inserir(ComentarioModel comentarioModel) {
		comentarioDao.insereComentario(comentarioModel);
	}
}
