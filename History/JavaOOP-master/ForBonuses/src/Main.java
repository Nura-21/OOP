public class Main {

	
	public static void main(String[] args) {
		Word a = new Word("hello",Type.VERB);
		Word b = new Word("hell",Type.NOUN);
		System.out.println(a.getWord()+" and "+b.getWord()+" distance is: "+a.distance(b));
		System.out.println(a.getWord()+" and "+b.getWord()+" is similar?: "+a.isSimilar(b));
	}
	
}
