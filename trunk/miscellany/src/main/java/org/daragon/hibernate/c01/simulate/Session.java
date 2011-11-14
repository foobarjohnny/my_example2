package org.daragon.hibernate.c01.simulate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.daragon.hibernate.c01.Student;

public class Session {

	private Map<String, String> propsMap = new HashMap<String, String>();
	private String tableName = "student";
	private String[] methodNames;

	public Session() {
		propsMap.put("id", "id");
		propsMap.put("name", "name");
		propsMap.put("age", "age");
		methodNames = new String[propsMap.size()];
		 methodNames = new String[propsMap.size()];
		int i = 0;
		for (String s : propsMap.keySet()) {
			String val = propsMap.get(s);
			methodNames[i] = "get" + Character.toUpperCase(val.charAt(0))
					+ val.substring(1);
			System.out.println(methodNames[i]);
			i++;
		}
	}

	public void save(Student o) throws SQLException, ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		// join the sql
		String sql = createSQL();
		// execute the sql
		// 注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 建立链接
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/hibernate", "root", "q1w2e3r4");
		java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);
		
		for(int i=0;i<methodNames.length;i++){
			Method m = o.getClass().getMethod(methodNames[i]);
			Class retType = m.getReturnType();
			String name = retType.getName();
			if(name.equals("java.lang.String")){
				String retVal = (String) m.invoke(o);
				pstmt.setString(i+1, retVal);
			}

			if(name.equals("int")){
				Integer retVal = (Integer) m.invoke(o);
				pstmt.setInt(i+1, retVal);
			}
			
		}
		// 根据链接来执行SQL
		pstmt.execute();
	}


	private String createSQL() {
		String sql = "insert into %s(%s) values(%s)";
		Set<String> keySet = propsMap.keySet();
		String s1 = keySet.toString().replaceAll("\\[|\\]", "");
		String s2 = s1.replaceAll("\\w+", "?");
		sql = String.format(sql, tableName, s1, s2);
		return sql;
	}

	public static void main(String[] args) throws SQLException,
			ClassNotFoundException, SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		Session s = new Session();
		Student stud = new Student();
		stud.setId(11);
//		stud.setAge(22);
		stud.setName("david");
		s.save(stud);
	}
}
