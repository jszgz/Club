package xueshe.com.dao;

import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;

public class BaseDao {
	DataSource dataSource;

	// 在构造方法中返回数据源对象
	public BaseDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/sampleDS");
		} catch (NamingException ne) {
			ne.printStackTrace();
		}
	}

	// 返回一个连接对象
	public Connection getConnection(){
		
		try{
			Connection connection=dataSource.getConnection();
			return connection;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
