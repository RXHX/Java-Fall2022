
public class Lecture01 {

	public static void main(String[] args) {

		int i = 10;
		char ch = 'G' + 1;
//		String str = "\n";
		
//		i = (int) l;
		
		// String instructor = "Ivan Wong"; //// i = 10;
		//		
		//		i = 20;
		
		System.out.println("Hello World!");
		System.out.println("i = " + i);
//		System.out.println("l = " + l);
		System.out.println("ch = " + ch);
		
		ch = 'A';
		for(i = 0; i < 26; i++) {
			char result = (char) (ch + i);
			System.out.println(result);
		}
	}

}
