package number.puzzle;

public class ScoreDao {
	private static ScoreDao instance = null;
	private ScoreDao() {}
	public static ScoreDao getInstance() {
		if(instance == null) {
			instance = new ScoreDao();
		}
		return instance; 
	}
	
	
	
}
