package br.com.prova.service;

import java.util.List;

import br.com.prova.dao.NoticiaDao;
import br.com.prova.model.NoticiaModel;

/**
 * M�todo respons�vel por fazer a comunica��o
 * com a dao
 *  
 * @author Jo�o Vitor
 * @since 20/04/2020
 *
 */
public class NoticiaService {
	
	private NoticiaDao noticiaDao =  new NoticiaDao();
	
	/**
	 * M�todo respons�vel por fazer a comunica��o
	 * com a dao para inserir uma noticia  
	 * @param noticiaModel
	 */
	public void inserir(NoticiaModel noticiaModel) {
		noticiaDao.insereNoticia(noticiaModel);
	}
	
	/**
	 * M�todo respons�vel receber as noticias 
	 * que vem da dao
	 * 
	 * @return {@code - List<NoticiaModel>} -  listaNoticiaModel
	 */
	public List<NoticiaModel> listar(){
		
		return noticiaDao.listaNoticias();
	}
	
	/**
	 * M�todo respons�vel por alterar uma noticia 
	 * 
	 * @param idNoticia
	 * @param noticiaModel
	 */
	public void alterar(Integer idNoticia, NoticiaModel noticiaModel) {
		
		noticiaDao.alteraNoticiaModel(idNoticia, noticiaModel);
	}
	
	/**
	 * M�todo respons�vel por excluir uma noticia 
	 * 
	 * @param idNoticia
	 */
	public void excluir(Integer idNoticia) {
		
		noticiaDao.excluir(idNoticia);
	}
}

