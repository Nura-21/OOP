
public class Word {
	private String s;
	private Type t;
	public Word() {}
	public Word(String s, Type t) {
		this.s = s;
		this.t = t;
	}
	void setWord(String s, Type t){
		this.s = s;
		this.t = t;
	}
	String getWord(){
		return s;
	}
	public int distance(Word b) {
		int aLen = s.length(); // first word size
		int bLen = b.s.length(); // second word size
		int[][] leva = new int[aLen+1][bLen+1]; // Initialize 2D array (лёва)
		for (int i = 0; i <= aLen; i++) // fill first vertical
	        leva[i][0] = i;
	    for (int k = 0; k <= bLen; k++) // fill first horizontal
	        leva[0][k] = k;

	    // recursive cases(actually dynamically programming):
	    for (int i = 1; i <= aLen; i++) 
	    {
	        for (int k = 1; k <= bLen; k++)
	        {
	            if (s.charAt(i-1) == b.s.charAt(k-1)) // Last chars are the same
	                leva[i][k] = leva[i - 1][k - 1];
	            else // Last chars are different - so we need to add or remove last in a or b.
	                leva[i][k] = Math.min(Math.min(leva[i - 1][k], leva[i][k - 1]), leva[i - 1][k - 1]) + 1;
	        }
	    }
	    return leva[aLen][bLen]; // last number in 2D array -> our answer
	}
	public boolean isSimilar(Word b) {
		int dist = this.distance(b);
		if (dist<=2 && this.t.equals(b.t))
			return true;
		return false;
	}
	
	
}
