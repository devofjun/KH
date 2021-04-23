package number.puzzle;

public class ScoreVo {
	String uid;
	Long score;
	public ScoreVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ScoreVo(String uid, Long score) {
		super();
		this.uid = uid;
		this.score = score;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Long getScore() {
		return score;
	}
	public void setScore(Long score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "ScoreVo [uid=" + uid + ", score=" + score + "]";
	}
	
	
}
