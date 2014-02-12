package utils.dcase.database.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.dcase.database.pool.ConnectionPool;


/**
 * @author Jesse
 * @category
 * if your dao call the api java.sql.Connection directly,
 * it just need to extend this abstract dao ,
 * your dao can  call the method:
 *close ,  startTranscation , commitTranscation, rollbackTranscation directly
 *
 */
public abstract class DAO {
	
	/**
	 * 设置开始提交事务 开始执行更新语句之前执行 不让JAVA执行语句自动提交
	 * @param con
	 * @throws Exception
	 */
	public void startTranscation(Connection con) throws Exception {
			con.setAutoCommit(false);
	}

	/**
	 * 提交事务,设置已经提交事务的标志位
	 * 
	 * @param con
	 * @throws Exception
	 */
	public void commitTranscation(Connection con) throws Exception {
		con.commit();
		con.setAutoCommit(true);
	}

	/**
	 * 如果有提交事务的情况下,出错,需要回滚数据, 并且确保是提交事务的异常
	 * 
	 * @param con
	 * @param errorDesp
	 *            出现提交事务出现异常的错误描述
	 * @throws SQLException 
	 */
	public void rollbackTranscation(Connection con, String errorDesp) throws SQLException {
		if(con != null){
			con.setAutoCommit(false);
			con.rollback();
			con.setAutoCommit(true);
		}
			
		
	}
	
	public void free(ResultSet rs, Statement st, Connection conn, ConnectionPool pool){
			try {
				if(rs != null){
					rs.close();
				}
				if(st != null){
					st.close();
				}
				pool.returnConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				//setConTOAutoCommit(con);
			}
	}
	public void free(Statement st, Connection conn, ConnectionPool pool){
		try {
			if(st != null){
				st.close();
			}
			pool.returnConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//setConTOAutoCommit(con);
		}
	}
	
	public void close(ResultSet rs, Statement st, Connection conn){
		try {
			if(rs != null){
				rs.close();
			}
			if(st != null){
				st.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//setConTOAutoCommit(con);
		}
	}
	public void close(Statement st, Connection conn){
		try {
			if(st != null){
				st.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//setConTOAutoCommit(con);
		}
	}
	
	public void close(Connection conn){
		try {
			
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//setConTOAutoCommit(con);
		}
	}
	
	
	
}
