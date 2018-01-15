package dbconect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {
	//JDBC�h���C�o�̓o�^
    String driver;
    // �f�[�^�x�[�X�̎w��
    String server, dbname, url, user, password;
    Connection con;
    Statement stmt;
    ResultSet rs;
    
	public MySQL() {
		this.driver = "org.gjt.mm.mysql.Driver";
		this.server = "ms000.sist.ac.jp";
		this.dbname =  "java2017";
		this.url =  "jdbc:mysql://" + server + "/" + dbname + "?useUnicode=true&characterEncoding=UTF-8";
		this.user =  "java2017";
		this.password = "java2017";         
		try {
			this.con = DriverManager.getConnection(url, user, password);
		    this.stmt = con.createStatement ();
		} catch(SQLException e) {
			
		e.printStackTrace();		
		}
		try {
			Class.forName (driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ResultSet selectAll(){
		String sql = "SELECT * FROM `50616030`";
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery (sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  //try catch�ň͂�
		return rs;

	}
	
	public void close() {
		try {
			rs.close();
			stmt.close();
			con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}
}
