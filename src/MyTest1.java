import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MyTest1 {

	public static void main(String[] args) {
		System.out.println("MyTest1.main()");

		MySQLDatabase highscores = MySQLController.getController().getDatabase(MySQLController.Database.HIGHSCORES);

		try {
 
			Thread.sleep(1000);
			Connection connection = highscores.getConnection();
			PreparedStatement pstmt = connection.prepareStatement("\nSELECT * from account WHERE id=?");
			
			pstmt.setInt(1, 2);

			ResultSet rs = pstmt.executeQuery();

			System.out.println("rs : " + rs);
			while (rs.first()) {
				System.out.println("while");
				
				System.out.println(rs.getInt("id"));
				String email = rs.getString("email");
				System.out.println(email);
				String password = rs.getString("password");
				System.out.println(password);
				
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
