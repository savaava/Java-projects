package simulazionemia.classi;

public class Quaderno {
    private int pagine;
    private final String colore;
    private final boolean copertinaRigida;
    private final String proprietario;

    public Quaderno(int pagine, String colore, boolean copertinaRigida, String proprietario) {
        this.pagine = pagine;
        this.colore = colore;
        this.copertinaRigida = copertinaRigida;
        this.proprietario = proprietario;
    }

    public String getProprietario() {
        return proprietario;
    }

    public int getPagine() {
        return pagine;
    }

    public String getColore() {
        return colore;
    }

    public boolean getCopertinaRigida() {
        return copertinaRigida;
    }

    
    @Override
    public int hashCode(){
        int hash = 7;
        hash = 79 * hash + Integer.hashCode(pagine);
        hash = 79 * hash + colore.hashCode();
        return hash;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null)
            return false;
        if(obj == this)
            return true;
        if(obj.getClass() != this.getClass())
            return false;
        
        Quaderno quadObj = (Quaderno)obj;
        return ( quadObj.pagine==pagine 
                && quadObj.colore.equalsIgnoreCase(colore) );
    }
    
    @Override
    public String toString() {
        if(copertinaRigida)
            return "---Quaderno---\nproprietario: "+proprietario+"\nNumero pagine: "+pagine+"\nColore: "+colore+"\nCopertina rigida";
        return "---Quaderno---\nproprietario: "+proprietario+"\nNumero pagine: "+pagine+"\nColore: "+colore+"\nCopertina flessibile";
    }
}
