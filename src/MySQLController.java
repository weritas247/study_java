
import java.sql.Connection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Gabriel Hannason
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class MySQLController {
	
	public static final ExecutorService SQL_SERVICE = Executors.newSingleThreadExecutor();   
	
	public static void toggle() {
 
	}

	private static MySQLController CONTROLLER;
//	private static Store STORE = new Store();
	
	public static void init() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		CONTROLLER = new MySQLController();
	}

	public static MySQLController getController() {
		
//		System.out.println("MySQLController.getController: " + CONTROLLER);
		
		if (CONTROLLER == null) {
			CONTROLLER = new MySQLController();
		}
		
		return CONTROLLER;
	}

	public enum Database {
		HIGHSCORES,
		RECOVERY,
		GRAND_EXCHANGE;
	}

	/* NON STATIC CLASS START */

	private static MySQLDatabase[] DATABASES = new MySQLDatabase[2];

	public MySQLDatabase getDatabase(Database database) {
		return DATABASES[database.ordinal()];
	}

	
	public MySQLController() {
		/* DATABASES */
		
		DATABASES[0] = new MySQLDatabase("127.0.0.1", 3306, "LSH_DB", "root", "mysql");
		DATABASES[1] = new MySQLDatabase("127.0.0.1", 3306, "LSH_DB", "root", "mysql");
//		DATABASES[1] = new MySQLDatabase("127.0.0.1", 3306, "BBS", "root", "mysql");
		
		MySQLProcessor.process();
	}

	private static class MySQLProcessor {

		private static boolean running;
		
		private static void terminate() {
			running = false;
		}

		public static void process() {
			if(running) {
				return;
			}
			System.out.println("MySQLController.process()");
			
			running = true;
			SQL_SERVICE.submit(new Runnable() {
				public void run() {
					try {
						while(running) {
							for(MySQLDatabase database : DATABASES) {
								
								if(!database.active) {
									continue;
								}

								if(database.connectionAttempts >= 5) {
									database.active = false;
								}

								Connection connection = database.getConnection();
								try {
								System.out.println("ping");
									connection.createStatement().execute("/* ping */ SELECT 1");
								} catch (Exception e) {
									database.createConnection();
								}
							}
							Thread.sleep(25000);
						}
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
}
