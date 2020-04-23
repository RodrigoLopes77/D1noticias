package br.com.prova.service;

import java.util.List;

import br.com.prova.dao.NoticiaDao;
import br.com.prova.model.NoticiaModel;

/**
 * Método responsável por fazer a comunicação
 * com a dao
 *  
 * @author João Vitor
 * @since 20/04/2020
 *
 */
public class NoticiaService {
	
	private NoticiaDao noticiaDao =  new NoticiaDao();
	
	/**
	 * Método responsável por fazer a comunicação
	 * com a dao para inserir uma noticia  
	 * @param noticiaModel
	 */
	public void inserir(NoticiaModel noticiaModel) {
		noticiaDao.insereNoticia(noticiaModel);
	}
	
	/**
	 * Método responsável receber as noticias 
	 * que vem da dao
	 * 
	 * @return {@code - List<NoticiaModel>} -  listaNoticiaModel
	 */
	public List<NoticiaModel> listar(){
		
		return noticiaDao.listaNoticias();
	}
	
	/**
	 * Método responsável por alterar uma noticia 
	 * 
	 * @param idNoticia
	 * @param noticiaModel
	 */
	public void alterar(Integer idNoticia, NoticiaModel noticiaModel) {
		
		noticiaDao.alteraNoticiaModel(idNoticia, noticiaModel);
	}
	
	/**
	 * Método responsável por excluir uma noticia 
	 * 
	 * @param idNoticia
	 */
	public void excluir(Integer idNoticia) {
		
		noticiaDao.excluir(idNoticia);
	}
}

