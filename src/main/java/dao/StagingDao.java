package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Palavra;
import model.Staging;

public class StagingDao {
	
	public void inserirStaging(Staging staging) {
		String sql = "INSERT INTO STAGING VALUES (nextval('staging_id_staging_seq'), ?, ?)";
		PreparedStatement pStatement = null;
		Connection conn = null;
		
		try {
			conn = new SqlConnection().getSqlConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, staging.getPalavra());
			pStatement.setString(2, staging.getDoc().toString());
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
