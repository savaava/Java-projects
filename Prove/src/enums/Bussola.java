package enums;

import interfacce.BussolaInterfaccia;

public enum Bussola implements BussolaInterfaccia {
    NORD{
        @Override
        public void stampaMessaggio(){
            System.out.println("stai andando bene");
        }
    },
    SUD{
        @Override
        public void stampaMessaggio(){
            System.out.println("stai andando una chiavica");
        }
    },
    EST{
        @Override
        public void stampaMessaggio(){
            System.out.println("sistema la rotta");
        }
    },
    OVEST{
        @Override
        public void stampaMessaggio(){
            System.out.println("sistema la rotta");
        }
    }
}
