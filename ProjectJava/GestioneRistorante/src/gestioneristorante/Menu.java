package gestioneristorante;

import java.util.LinkedList;

/**
 *
 * @author leonardorundo
 */
public class Menu {
    
    LinkedList<String> menu;

    public Menu() {
        menu = new LinkedList<>();
        menu.add("Pasta al pomodoro");
        menu.add("Fagioli alla messicana");
        menu.add("Pesce spada arrostito");
        menu.add("Filetto di maiale");
        menu.add("Risotto alla pescatora");
        menu.add("Tortellini in brodo");
        menu.add("Calamari alla brace");
        menu.add("Tiramisu");
    }

    public String getPiatto() {
        int r = (int) Math.round((menu.size() - 1) * Math.random());
        return menu.get(r);
    }
    
}
