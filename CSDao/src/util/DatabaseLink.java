package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseLink {
	
	private static DatabaseLink instance;
	private Connection conn;

    private static String url="jdbc:mysql://localhost:3306/csdb?useUnicode=true&characterEncoding=UTF-8";


    private static String user="root";
    private static String password="";
	
	private DatabaseLink(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
    public static DatabaseLink getInstance() {
        if (instance == null) {
            instance = new DatabaseLink();
        }
        return instance;
    }
	
    public Connection getConn() {
        return conn;
    }
	
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        conn.close();
    }
}
