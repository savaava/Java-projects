package prove;

public class MainStringhe {
    public static void main(String[] args) {
        
        String str1 = "allora benvenuti";
        String str2 = "zitto ciao";
        System.out.println("str1: "+str1+"\nstr2: "+str2);
        
        System.out.println(str1.compareTo(str2));
        if(str1.compareTo(str2) >0)
            System.out.println("str1 > str2 in ordine lessicografico");
        else if(str1.compareTo(str2) <0)
            System.out.println("str1 < str2 in ordine lessicografico");
        
        
        str1 = "  Zitto ciao  ";
        System.out.println("\nstr1: "+str1+"\nstr2: "+str2);
        System.out.println(str1.compareTo(str2));
        
        System.out.println(str1.equals(str2));        
        System.out.println(str1.equalsIgnoreCase(str2));   
        
        str1 = str1.trim();
        System.out.println(str1);
        System.out.println(str1.equalsIgnoreCase(str2));
        
        
        System.out.println();
        String str = "andreasavastano4388@gmail.com";
        String regex = "^[a-z0-9]+@[a-z]{2,}\\.[a-zA-Z]{2,}$";
        System.out.println("str: "+str+"\nregex: \""+regex+"\"\n"+str.matches(regex));
        
        System.out.println("GL181SY".matches("^[a-zA-Z]{2}\\d{3}[a-zA-Z]{2}$"));
    }
}
