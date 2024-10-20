package classi;

public class ComplexNumber {
    private double parteReale;
    private double parteImmaginaria;
    private static int conteggioNumeri = 0;
    
    public ComplexNumber(){
        this(0.0,0.0);
    }
    
    public ComplexNumber(double parteReale, double parteImmaginaria){ 
        this.parteReale = parteReale;
        this.parteImmaginaria = parteImmaginaria;
        conteggioNumeri++;
    }
    
    public void setParteReale(double parteReale){        
        this.parteReale = parteReale;
    }
    
    public void setParteImmaginaria(double parteImmaginaria){
        this.parteImmaginaria = parteImmaginaria;
    }
    
    public double getParteReale(){
        return parteReale;
    }
    
    public double getParteImmaginaria(){
        return parteImmaginaria;
    }
    
    public void stampaComplexNumberCartesiana(){
        System.out.println("Forma Cartesiana: "+parteReale+" + "+parteImmaginaria+"j");
    }
    
    public void stampaComplexNumberPolare(){
        double rho = Math.sqrt(Math.pow(parteReale,2) + Math.pow(parteImmaginaria,2));
        double theta = Math.atan(parteImmaginaria/parteReale);
        
        if(parteReale<0)
            theta = theta + Math.PI;
        
        rho = Math.round(rho*1000)/1000.0;
        theta = Math.round(theta*1000)/1000.0;
        
        System.out.println("Forma Polare:     "+rho+" e^j"+theta);
    }
    
    public static int getConteggioNumeri(){
        return conteggioNumeri;
    }
}