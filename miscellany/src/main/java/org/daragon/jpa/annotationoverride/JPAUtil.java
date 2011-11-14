package org.daragon.jpa.annotationoverride;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class JPAUtil {
	private static Logger logger = Logger.getLogger(JPAUtil.class.getName());
	private Statement st;

	public JPAUtil() throws ClassNotFoundException, SQLException {

		Class.forName("org.hsqldb.jdbcDriver");
		logger.info("Driver loaded");
		String url = "jdbc:hsqldb:data/tutorial";
		Connection conn = DriverManager.getConnection(url, "sa", "");
		System.out.println("Connection established");
		st = conn.createStatement();
	}

	public void executeSqlCommand(String sql) throws SQLException {
		st.executeUpdate(sql);
	}

	public void checkData(String sql) throws SQLException {
		ResultSet rs = st.executeQuery(sql);
		ResultSetMetaData metadata = rs.getMetaData();
		for (int i = 0; i < metadata.getColumnCount(); i++) {
			System.out.println("\t" + metadata.getColumnLabel(i + 1));
		}
		System.out.println("\n---------------------------------");
		while (rs.next()) {

			for (int i = 0; i < metadata.getColumnCount(); i++) {
				Object value = rs.getObject(i + 1);
				if (value == null) {
					System.out.print("\t       ");
				} else {
					System.out.print("\t" + value.toString().trim());
				}
			}
			System.out.println("");
		}

	}
}
