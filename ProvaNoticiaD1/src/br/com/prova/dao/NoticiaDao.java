package br.com.prova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.prova.connection.factory.ConnectionFactory;
import br.com.prova.model.NoticiaModel;

/**
 * Classe responsável pela conexão com o banco de dados
 * 
 * @author João Vitor
 * @since 20/04/2020
 */
public class NoticiaDao {

	private Connection conect;

	/**
	 * ConnectionFactory serve para se comunicar com o banco de dados
	 * 
	 * @throws SQLException
	 */
	public NoticiaDao(){
		new ConnectionFactory();
		this.conect = ConnectionFactory.conectar();
	}

	/**
	 * Método responsável por inserir uma noticia no banco de dados
	 * 
	 * @param noticiaModel
	 */
	public void insereNoticia(NoticiaModel noticiaModel) {

		String insert = "INSERT INTO noticia (descricao,titulo,texto) " + "VALUES (?,?,?)";

		try (PreparedStatement preparedStatement = conect.prepareStatement(insert);) {

			preparedStatement.setString(1, noticiaModel.getDescricao());
			preparedStatement.setString(2, noticiaModel.getTitulo());
			preparedStatement.setString(3, noticiaModel.getTexto());
			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conect.rollback();
			} catch (SQLException ex) {
				System.out.println(ex.getStackTrace());
			}
		}
	}

	/**
	 * Método responsável por listar todas as noticias contidas no banco de dados
	 * 
	 * @return {@code - List<NoticiaModel>} - lista de noticias
	 */
	public List<NoticiaModel> listaNoticias() {

		String sqlSelect = "SELECT * FROM noticia";

		List<NoticiaModel> listaNoticiaModel = new ArrayList<>();

		try (PreparedStatement preparedStatement = conect.prepareStatement(sqlSelect);) {

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				NoticiaModel noticiaModel = new NoticiaModel();
				noticiaModel.setTitulo(resultSet.getString("titulo"));
				noticiaModel.setDescricao(resultSet.getString("descricao"));
				noticiaModel.setTexto(resultSet.getString("texto"));
				noticiaModel.setId(resultSet.getInt("id"));
				listaNoticiaModel.add(noticiaModel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaNoticiaModel;
	}

	/**
	 * Método responsável por fazer a alteração de uma noticia
	 * 
	 * @param idNoticiaModel
	 * @param noticiaModel
	 */
	public void alteraNoticiaModel(Integer idNoticiaModel, NoticiaModel noticiaModel) {

		String alteraNoticiaModel = "UPDATE noticia " + "SET titulo = ?, descricao = ?, texto = ? " + " WHERE id = ? ";

		try (PreparedStatement preparedStatement = conect.prepareStatement(alteraNoticiaModel)) {

			preparedStatement.setString(1, noticiaModel.getTitulo());
			preparedStatement.setString(2, noticiaModel.getDescricao());
			preparedStatement.setString(3, noticiaModel.getTexto());
			preparedStatement.setInt(4, idNoticiaModel);

			preparedStatement.execute();

		} catch (SQLException ex) {
			System.err.println("Não foi possivel modificar" + "a tabela Noticia.");
			ex.printStackTrace();
		}
	}

	/**
	 * Método responsável por excluir uma noticia de acordo com o Id passado 
	 * 
	 * @param idNoticiaModel
	 */
	public void excluir(Integer idNoticiaModel) {

		String excluir = "DELETE FROM noticia " + " WHERE id = ? ";

		try (PreparedStatement pst = conect.prepareStatement(excluir)) {

			pst.setInt(1, idNoticiaModel);
			pst.execute();

		} catch (SQLException ex) {
			System.err.println("Não foi possivel excluir " + "a noticia");
			ex.printStackTrace();
		}
	}

}