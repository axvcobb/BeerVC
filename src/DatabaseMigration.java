import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseMigration {

    private static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:database.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS recipes (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	version integer,\n"
                + "	type text,\n"
                + "	brewer text\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args){

        createNewTable();
    }
}
