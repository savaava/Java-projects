package oop2019.prova.gruppo77;

public interface NetworkInterface {
    /* interfaccia di rete che consente ai device di scambiare messaggi */
    public void accept(NetworkInterface sourceInterface, int sourceAddress, int destAddress, String message);
    public void connect(NetworkInterface other);
}
