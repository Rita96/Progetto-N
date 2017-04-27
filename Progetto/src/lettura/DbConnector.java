package lettura;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import lettura.PreferenceHandler;

/**
 *
 * @author luby
 */
public class DbConnector {

    Connection dbConnection;
    private static DbConnector singleton;
    
    String dbServer = "";
    String catalog = "";

    public String getDbServer() {
        return dbServer;
    }
    
    public static DbConnector getInstance(){
	if (singleton==null){
		singleton = new DbConnector();
	}
	return singleton;
    }

    Connection dbConnection;
    private static DbConnector singleton;
    
    String dbServer = "";
    String catalog = "";

    public String getDbServer() {
        return dbServer;
    }
    
    public static DbConnector getInstance(){
		if (singleton==null){
			singleton = new DbConnector();
		}
		return singleton;
	}


	private DbConnector(){		
		if (!testDBConnection()){
			throw new IllegalStateException("Impossible to connect to the DB");			
		}
		dbConnection =this.openDBConnection();
	}


	/**
	 * Test the DB connection according to the user preference
	 * @return true if a connection to the DB could be opened 
	 */
	private  boolean testDBConnection() {
		Connection con = openDBConnection();
		if (con==null){
			return false;
		}else{
			closeDBConnection(con);			
			return true;
		}
	}


	public void close(){
		closeDBConnection(this.dbConnection);
	}

	
	public void openConnection(){
		this.dbConnection = this.openDBConnection();
	}

	
	/**
	 * @return db connection status
	 */
	public boolean isConnectionOpen(){
		try {
			return ((this.dbConnection!=null)&&
					!this.dbConnection.isClosed());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	private  Connection openDBConnection(){
		Connection res= null;
		String connectionString="";
		String DBuser ="";
		String DBpass="";


		connectionString= PreferenceHandler.getJDBCConnection(); 
		DBuser = "user";
		DBpass = "password";

		try {
			res = DriverManager.getConnection(connectionString, DBuser, DBpass);
			res.setAutoCommit(false);
			if(!res.isClosed()){
				System.out.println("Successfully connected to MySql server using TCP/IP...");				
			}
		} catch(Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}
		return res;
	}

	
	private  void  closeDBConnection(Connection conn) {
		try {
			if (!conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public static String printSQLException(SQLException ex) {
		String res="";
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				if (ignoreSQLException(((SQLException)e).getSQLState()) == false) {
					e.printStackTrace(System.err);
					res+="SQLState: " + ((SQLException)e).getSQLState();
					res+="Error Code: " + ((SQLException)e).getErrorCode();
					res+="Message: " + e.getMessage();
					Throwable t = ex.getCause();
					while(t != null) {
						res="Cause: " + t;
						t = t.getCause();
					}
				}
			}
		}
		return res;
	}


	private static boolean ignoreSQLException(String sqlState) {
		if (sqlState == null) {
			System.out.println("The SQL state is not defined!");
			return false;
		}
		// X0Y32: Jar file already exists in schema
		if (sqlState.equalsIgnoreCase("X0Y32"))
			return true;
		// 42Y55: Table already exists in schema
		if (sqlState.equalsIgnoreCase("42Y55"))
			return true;
		return false;
	}


	public Connection getConnection() {
		return this.dbConnection;
	}

	
	public static void closeConn() {
		if (singleton ==null) return;
		if (singleton.isConnectionOpen())
			singleton.close();

	}
        
        public void createTableMenu(Connection conn ,String dbName) throws SQLException{
                      
                Statement stmt = null;
                String query = "CREATE TABLE [dbo].[Menu]("+
                                "[Nome] [text] NOT NULL,\n" +
                                "	[TipoPortata] [text] NOT NULL,\n" +
                                "	[Ingredienti] [text] NULL\n" +
                                ") ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]";

                try{
                    stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(query);
                }catch (SQLException e ) {
                    printSQLException(e);
                } finally {
                    if (stmt != null) { stmt.close(); }
                }
        }
        
        public void createTablePrenotazione(Connection conn ,String dbName) throws SQLException{
                      
                Statement stmt = null;
                String query = "CREATE TABLE [dbo].[Prenotazione](\n" +
                                "[Cliente] [text] NOT NULL,\n" +
                                "[Menu] [text] NOT NULL,\n" +
                                "[Pasto] [text] NOT NULL,\n" +
                                "[Sala] [text] NULL,\n" +
                                "[nAdulti] [int] NULL,\n" +
                                "[nBambini] [int] NULL,\n" +
                                "[DataPrenotazione] [date] NOT NULL,\n" +
                                "[TipoEvento] [text] NOT NULL,\n" +
                                "[Note] [text] NULL\n" +
                                ") ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]";

                try{
                    stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(query);
                }catch (SQLException e ) {
                    printSQLException(e);
                } finally {
                    if (stmt != null) { stmt.close(); }
                }
        }
        

      

    private DbConnector(){		
	if (!testDBConnection()){
            throw new IllegalStateException("Impossible to connect to the DB");			
	}
	dbConnection =this.openDBConnection();
	}


	/**
	 * Test the DB connection according to the user preference
	 * @return true if a connection to the DB could be opened 
	 */
    private  boolean testDBConnection() {
	Connection con = openDBConnection();
	if (con==null){
            return false;
	}else{
            closeDBConnection(con);			
            return true;
	}
    }


    public void close(){
        closeDBConnection(this.dbConnection);
    }

	
    public void openConnection(){
        this.dbConnection = this.openDBConnection();
    }

	
	/**
	 * @return db connection status
	 */
    public boolean isConnectionOpen(){
        try {
            return ((this.dbConnection!=null)&&
                !this.dbConnection.isClosed());
	} catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

	
    private  Connection openDBConnection(){
      	Connection res= null;
            String connectionString="";
            String DBuser ="";
            String DBpass="";


            connectionString= PreferenceHandler.getJDBCConnection(); 
            DBuser = "user";
            DBpass = "password";

            try {
		res = DriverManager.getConnection(connectionString, DBuser, DBpass);
		res.setAutoCommit(false);
		if(!res.isClosed()){
                    System.out.println("Successfully connected to MySql server using TCP/IP...");				
		}
            } catch(Exception e) {
                    System.err.println("Exception: " + e.getMessage());
            }
            return res;
	}

	
	private  void  closeDBConnection(Connection conn) {
		try {
			if (!conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public static String printSQLException(SQLException ex) {
		String res="";
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				if (ignoreSQLException(((SQLException)e).getSQLState()) == false) {
					e.printStackTrace(System.err);
					res+="SQLState: " + ((SQLException)e).getSQLState();
					res+="Error Code: " + ((SQLException)e).getErrorCode();
					res+="Message: " + e.getMessage();
					Throwable t = ex.getCause();
					while(t != null) {
						res="Cause: " + t;
						t = t.getCause();
					}
				}
			}
		}
		return res;
	}


	private static boolean ignoreSQLException(String sqlState) {
		if (sqlState == null) {
			System.out.println("The SQL state is not defined!");
			return false;
		}
		// X0Y32: Jar file already exists in schema
		if (sqlState.equalsIgnoreCase("X0Y32"))
			return true;
		// 42Y55: Table already exists in schema
		if (sqlState.equalsIgnoreCase("42Y55"))
			return true;
		return false;
	}


	public Connection getConnection() {
		return this.dbConnection;
	}

	
	public static void closeConn() {
		if (singleton ==null) return;
		if (singleton.isConnectionOpen())
			singleton.close();

	}
        
        public void createTableMenu(Connection conn ,String dbName) throws SQLException{
                      
                Statement stmt = null;
                String query = "CREATE TABLE [dbo].[Menu]("+
                                "[Nome] [text] NOT NULL,\n" +
                                "	[TipoPortata] [text] NOT NULL,\n" +
                                "	[Ingredienti] [text] NULL\n" +
                                ") ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]";

                try{
                    stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(query);
                }catch (SQLException e ) {
                    printSQLException(e);
                } finally {
                    if (stmt != null) { stmt.close(); }
                }
        }
        
        public void createTablePrenotazione(Connection conn ,String dbName) throws SQLException{
                      
                Statement stmt = null;
                String query = "CREATE TABLE [dbo].[Prenotazione](\n" +
                                "[Cliente] [text] NOT NULL,\n" +
                                "[Menu] [text] NOT NULL,\n" +
                                "[Pasto] [text] NOT NULL,\n" +
                                "[Sala] [text] NULL,\n" +
                                "[nAdulti] [int] NULL,\n" +
                                "[nBambini] [int] NULL,\n" +
                                "[DataPrenotazione] [date] NOT NULL,\n" +
                                "[TipoEvento] [text] NOT NULL,\n" +
                                "[Note] [text] NULL\n" +
                                ") ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]";

                try{
                    stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(query);
                }catch (SQLException e ) {
                    printSQLException(e);
                } finally {
                    if (stmt != null) { stmt.close(); }
                }
        }
        

        
       
}
