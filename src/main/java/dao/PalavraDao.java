package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Palavra;

public class PalavraDao {
	
	public void inserirPalavra(Palavra palavra) {
		String sql = "INSERT INTO PALAVRA VALUES (nextval('palavra_id_palavra_seq'), ?)";
		PreparedStatement pStatement = null;
		Connection conn = null;
		
		try {
			conn = new SqlConnection().getSqlConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, palavra.getPalavra());
			pStatement.execute();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pStatement != null) {
					pStatement.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
