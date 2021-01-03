import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDAPI {
	
    public BDAPI(String fileName){
		
		String url = "jdbc:sqlite:sqlite/" + fileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
		}
	}

}
