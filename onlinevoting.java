
	import java.sql.*;

	public class onlinevoting {
	    // JDBC URL, username, and password
	    static final String JDBC_URL = "jdbc:mysql://localhost:3306/OnlineVoting";
	    static final String USERNAME = "root";
	    static final String PASSWORD = "kruthika@123";

	    // Establishing database connection
	    static Connection connection = null;

	    static {
	        try {
	            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Main method to start the application
	    public static void main(String[] args) {
	        try {
	            // Create tables if not exist
	            createTables();

	            // Your application logic goes here
	            // For example, you can provide options for user interaction
	            // such as registering, logging in, viewing candidates, casting votes, etc.
	            // You'll call appropriate DAO methods for database interactions.

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (connection != null) {
	                    connection.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    // Method to create database tables if not exist
	    static void createTables() throws SQLException {
	        String createUserTableQuery = "CREATE TABLE IF NOT EXISTS users (" +
	                "id INT AUTO_INCREMENT PRIMARY KEY," +
	                "username VARCHAR(50) UNIQUE," +
	                "password VARCHAR(50)," +
	                "email VARCHAR(100) UNIQUE)";
	        
	        String createCandidateTableQuery = "CREATE TABLE IF NOT EXISTS candidates (" +
	                "id INT AUTO_INCREMENT PRIMARY KEY," +
	                "name VARCHAR(100) UNIQUE," +
	                "party VARCHAR(100))";
	        
	        String createVoteTableQuery = "CREATE TABLE IF NOT EXISTS votes (" +
	                "id INT AUTO_INCREMENT PRIMARY KEY," +
	                "user_id INT," +
	                "candidate_id INT," +
	                "FOREIGN KEY (user_id) REFERENCES users(id)," +
	                "FOREIGN KEY (candidate_id) REFERENCES candidates(id))";

	        try (Statement statement = connection.createStatement()) {
	            statement.executeUpdate(createUserTableQuery);
	            statement.executeUpdate(createCandidateTableQuery);
	            statement.executeUpdate(createVoteTableQuery);
	        }
	    }
	}

	// You'll have separate classes for User, Candidate, and Vote entities.
	// You'll also have DAO classes for each entity to perform CRUD operations.
	// Below are just placeholder classes for demonstration purposes.

	class User {
	    private int id;
	    private String username;
	    private String password;
	    private String email;

	    // Constructor, getters, setters
	}

	class Candidate {
	    private int id;
	    private String name;
	    private String party;

	    // Constructor, getters, setters
	}

	class Vote {
	    private int id;
	    private int userId;
	    private int candidateId;

	    // Constructor, getters, setters
	}

	// DAO classes for User, Candidate, and Vote entities will interact with the database.
	// They will contain methods for CRUD operations.
	// Below are just placeholder classes for demonstration purposes.

	class UserDAO {
	    // CRUD methods for User entity
	}

	class CandidateDAO {
	    // CRUD methods for Candidate entity
	}

	class VoteDAO {
	    // CRUD methods for Vote entity
	}

	