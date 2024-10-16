package it.unisa.diem.oop.persone;

public interface Clonabile<T> { //T -> TInfo = tipo generico
    /*implementa un metodo che restituisce una copia dell'oggetto*/
    T clona(); /*restituisce gli stessi identici attributi*/
    /*clonabile per persona, per spazio, per veicolo,... molte interfacce
    -> voglio parametrizzare il tipo (uso un tipo generico) -> clonabile
    è un interfaccia che dipende dalla classe dell'oggetto su cui è chiamato */
    
    /*
    Meglio così anzichè usare Object perchè se avessi usato Object allora dovevo fare 
    il cast e faccio meno lavoro*/
}
