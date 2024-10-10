/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.oop.spazi;

/**
 *
 * @author andre
 */

/*posso specializzare ulteriormente l'eccezione*/
public class AulaPienaException extends AccessibileException {
    public AulaPienaException() {}
    public AulaPienaException(String msg) {
        super(msg);
    }
}
