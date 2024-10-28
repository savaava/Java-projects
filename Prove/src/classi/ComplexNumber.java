package classi;

import exceptions.ParteRealeNegativaException;
import exceptions.ParteImmaginariaNegativaException;
import exceptions.NumeriComplessiException;

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
    
    public double getParteReale(){
        return parteReale;
    }    
    public double getParteImmaginaria(){
        return parteImmaginaria;
    }    
    public static int getConteggioNumeri(){
        return conteggioNumeri;
    }
    
    public void add(ComplexNumber z) throws ParteRealeNegativaException {
        if(z.parteReale<0) 
            throw new ParteRealeNegativaException("ECCEZIONE: il parametro passato al metodo add ha parte Re < 0");
        this.parteReale+=z.parteReale;
        this.parteImmaginaria+=z.parteImmaginaria;
    }
    
    private String formaCartesiana(){
        return parteReale+" + "+parteImmaginaria+"j";
    }
    private String formaPolare(){
        double rho = Math.sqrt(Math.pow(parteReale,2) + Math.pow(parteImmaginaria,2));
        double theta = Math.atan(parteImmaginaria/parteReale);
        
        if(parteReale<0)
            theta = theta + Math.PI;
        
        rho = Math.round(rho*1000)/1000.0;
        theta = Math.round(theta*1000)/1000.0;
        
        return rho+" e^(j"+theta+")";
    }
    
    @Override
    public String toString(){
        return "\nNumero complesso:\nForma Cartesiana: "+formaCartesiana()+"\nForma Polare: "+formaPolare();
    }
}