import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {

	public ConnectDB() {

		Connection conn;
		Statement stmt;
		ResultSet rs;
		String sql;

		try {
			Class.forName("com.mysql.jdbc.Driver");// 드라이버 로딩: DriverManager에 등록
		} catch (ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
		}
		System.out.println("1. 데이터베이스 연");

		try {
			String jdbcUrl = "jdbc:mysql://211.199.232.249:3306/eboard";// 사용하는
			// 데이터베이스명을
			// 포함한 url
			String userId = "root";// 사용자계정
			String userPass = "dksgytkd";// 사용자 패스워드

			conn = DriverManager.getConnection(jdbcUrl, userId, userPass);// Connection
																			// 객체를
																			// 얻어냄

			stmt = conn.createStatement();// Statement 객체를 얻어냄
			// stmt.executeUpdate("use test"); // DB에 연결

			System.out.println("2. 제대로 연결되었습니다");// 성공시 화면에 표시됨

			// 데이터 베이스 처리문
			sql = "insert into test(name) value('dkssud')";
			for (int i = 0; i < 10; i++)
				stmt.executeUpdate(sql);

			System.out.println("3. 데이터베이스에 입력 완료.");
			// 데이터베이스 처리문 종료

			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}
}