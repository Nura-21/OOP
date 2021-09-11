package probOne;

public class Doge extends Animal {
		private String favToy;
		
		public Doge() {
			super();
			favToy = "Undefined";
		}
		public Doge(int age, String gender, String favToy) {
			super(age,gender);
			this.favToy = favToy;
		}
		public String getFavToy() {
			return favToy;
		}
		public String getVoice() {
			return "Gav ";
		}
		public String getVoice(int n) {
			String res = "";
			for(int i = 0; i < n; i++)
				res += "Gav ";
			return res;
		}
		public String toString() {
			return super.toString()
					+ "Favorite toy: " + favToy + "\n";
		}

}

