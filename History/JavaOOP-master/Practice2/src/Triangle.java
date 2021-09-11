
public class Triangle {
	public int n;
	Triangle(int n) {
		this.n = n;
    }
	
	public String toString() {
		String result = "";
        for (int i = 0; i < n; i++) {
			for(int j = 0; j<=i;j++) {
				result+="[*]";
			}
			result+="\n";
		}
        return result;
    }
}
