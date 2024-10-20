package prove;

public class MainWrapper {
    public static void main(String[] args) {
        String str = "Aa 77";
	char c;
	for(int i=0;  i<str.length();  i++) {
            c = str.charAt(i);
            System.out.println("\n'"+c+"':");
            System.out.println("isLetter -> "+Character.isLetter(c));
            System.out.println("isDigit -> "+Character.isDigit(c));
            System.out.println("isWhitespace -> "+Character.isWhitespace(c));
            System.out.println("isUpperCase -> "+Character.isUpperCase(c));
            System.out.println("NumericValue -> "+Character.getNumericValue(c));
	}
        
        System.out.println();
        
        String str2 = "0612707904";
        int n = Integer.parseInt(str2);
        System.out.println("parseInt -> "+n);
        Integer num = Integer.valueOf(str2);
        System.out.println("valueOf -> "+num);
        System.out.println("compare -> "+Integer.compare(8,3));
    }
}