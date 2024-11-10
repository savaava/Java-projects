package prove;

import classi.gerarchia.ClasseFiglia1;
import classi.gerarchia.ClasseFiglia1Figlia;
import classi.gerarchia.ClasseMadre;
import classi.ComplexNumber;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class MainVettori {
    public static void main(String[] args) throws Exception {
        System.out.println("--------------------------------------------------\n");
        System.out.println(args);
        
        ClasseMadre provaClasse0[] = {new ClasseMadre(),new ClasseMadre()};
        ClasseMadre provaClasse[] = new ClasseMadre[4];
        provaClasse[0] = new ClasseMadre();
        provaClasse[1] = new ClasseMadre();
        
        System.out.println(provaClasse+"\n");
        System.out.println(provaClasse[0]);
        System.out.println(provaClasse[1]);
        System.out.println(provaClasse[2]);
        System.out.println(provaClasse[3]);
        
        System.out.println("\n--------------------------------------------------\n");
        
        String strVett[] = {"str0.","str1.","str2.","str3."};
        System.out.println("strVett len: "+strVett.length);
        char cVett[] = {'c','@'};
        System.out.println("cVett len: "+cVett.length);
        
        String strVett2[] = new String[3];
        strVett2[0] = "ciao";
        for(int i=0; i<strVett2.length; i++){
            System.out.println(strVett2[i]);
        }
        for(String si : strVett2){
            System.out.println(si);
        }
        
        Integer interiVett[] = new Integer[4];
        interiVett[0] = Integer.valueOf(333);
        interiVett[0] = 334;
        System.out.println("interiVett len: "+interiVett.length);
        
//        System.out.println("\n--------------------------------------------------\n");
//        
//        int i = 0;
//        for(String stri : strVett){
//            stri = "str"+((i++)+10); /* sto cambiando il riferimento di stri */
//            System.out.println(stri);
//        }
//        System.out.println("\n"+strVett[0]+"\n");
//        
//        
//        List<Integer> interi = new ArrayList();
//        interi.add(333);
//        interi.add(334);
//        interi.add(335);
//        System.out.println(interi.contains(333));
//        System.out.println(interi.indexOf(333));
//        System.out.println(interi.remove(new Integer(335)));
//        interi.add(335);
//        System.out.println("interi: "+interi);
//        for(Integer ii : interi){
//            System.out.println(interi.indexOf(ii)); /* stesso riferimento */
//            ii -= 300;
//            System.out.println(interi.indexOf(ii)); /* non più stesso riferimento */
//        }
//        System.out.println("interi: "+interi);
//        
//        Iterator<Integer> ii = interi.iterator(); 
//        Integer intTmp;
//        while(ii.hasNext()){
//            intTmp = ii.next();
//            System.out.println(interi.indexOf(intTmp)); /* stesso riferimento */
//            intTmp -= 300;
//            System.out.println(interi.indexOf(intTmp)); /* non più stesso riferimento */
//            System.out.println(intTmp);
//        }
//        System.out.println("interi: "+interi);
//        
//        List<ComplexNumber> complessi = new ArrayList();
//        complessi.add(new ComplexNumber(2,4));
//        complessi.add(new ComplexNumber(66,1));
//        complessi.add(new ComplexNumber(7,8));
//        System.out.println("complessi: "+complessi);
//        for(ComplexNumber zi : complessi){
//            System.out.println(complessi.indexOf(zi)); /* stesso riferimento */
//            zi.add(new ComplexNumber(300,100));
//        }
//        System.out.println("complessi: "+complessi);
//        
//        System.out.println("\n--------------------------------------------------\n");
    }
}
