package br.com.prova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.prova.connection.factory.ConnectionFactory;
import br.com.prova.model.ComentarioModel;

/**
 * Classe responsável pela conexão com o banco de dados
 * 
 * @author João Vitor
 * @since 20/04/2020
 */
public class ComentarioDao {

	private Connection conect;

	/**
	 * ConnectionFactory serve para se comunicar com o banco de dados
	 * 
	 * @throws SQLException
	 */
	public ComentarioDao() {
		new ConnectionFactory();
		this.conect = ConnectionFactory.conectar();
	}
	
	/**
	 * Método responsável por inserir um comentário no banco de dados
	 * 
	 * @param comentarioModel
	 */
	public void insereComentario(ComentarioModel comentarioModel) {

		String insert = "INSERT INTO comentario (nome,texto, fk_noticia_id) " + "VALUES (?,?,?)";

		try (PreparedStatement preparedStatement = conect.prepareStatement(insert);) {

			preparedStatement.setString(1, comentarioModel.getNome());
			preparedStatement.setString(2, comentarioModel.getComentario());
			preparedStatement.setInt(3, comentarioModel.getPk());
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
	 * Método responsável por listar todos os comentarios contidos no banco de dados
	 * de acordo com o id da noticia
	 * 
	 * @return {@code - List<ComentarioModel>} - lista de comentario
	 */
	public List<ComentarioModel> listaComentarios(Integer idNoticia) {

		String sqlSelect = "SELECT * FROM comentario WHERE fk_noticia_id = ?";

		List<ComentarioModel> listaComentarioModel = new ArrayList<>();

		try (PreparedStatement preparedStatement = conect.prepareStatement(sqlSelect);) {
			
			preparedStatement.setInt(1, idNoticia);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ComentarioModel comentarioModel = new ComentarioModel();
				comentarioModel.setNome(resultSet.getString("nome"));
				comentarioModel.setComentario(resultSet.getString("texto"));
				listaComentarioModel.add(comentarioModel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaComentarioModel;
	}
}