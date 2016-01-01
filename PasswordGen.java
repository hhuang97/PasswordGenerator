import java.util.Scanner;

public class PasswordGen {
	private static final String DIGITS = "0123456789";
	private static final char[] digit = DIGITS.toCharArray();
	private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
	private static final char[] lower = LOWERCASE.toCharArray();
	private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final char[] upper = UPPERCASE.toCharArray();
	private static final String SYMBOLS = "!@#$%^&*()-_+=/.,?";
	private static final char[] symbol = SYMBOLS.toCharArray();

	public static String generate(int length) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int chooseType = (int) (Math.random() * 4);
			switch (chooseType) {
			case 0: // lowercase
				sb.append(lower[randomRange(0, 25)]);
				break;
			case 1: // uppercase
				sb.append(upper[randomRange(0, 25)]);
				break;
			case 2: // digits
				sb.append(digit[randomRange(0, 9)]);
				break;
			case 3: // symbols
				sb.append(symbol[randomRange(0, 17)]);
				break;
			}
		}
		return sb.toString();
	}
	
	// returns integer within min and max range inclusive
	private static int randomRange (int min, int max){
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}
	
	// for testing purposes only
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Number of characters for password: ");
		int x = sc.nextInt();
		String password = generate(x);
		System.out.println(password);
		sc.close();
	}
}
