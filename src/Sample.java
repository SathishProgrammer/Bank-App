
public class Sample {

	public static void main(String[] args) {
		
		String nameString = "Sathish";
		String name1 = "Sasi Kumar";
		
		while(name1.indexOf(nameString) != 0) {
			nameString = nameString.substring(0, nameString.length()-1);
		}
		
		System.out.println(nameString);
		
	}
}
