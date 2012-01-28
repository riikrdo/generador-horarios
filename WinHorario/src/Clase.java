public class Clase implements Comparable <Clase> {
    public String asig;
    int dia; //1-7 (en realidad entre 1-5)
    double horaini, horafin, duracion; //si empieza a las 17:30 -> horaini=17.5
   
    
    Clase (String as, int d, double i, double f) {
        asig=as;
        dia=d;
        horaini=i;
        horafin=f;
        duracion=horafin-horaini;
    }
    
    boolean Coincide(Clase c){
            return (dia==c.dia && 
                  ((horaini <= c.horaini && (duracion + c.duracion)> (c.horafin - horaini)) ||
                   (c.horaini <= horaini && (duracion + c.duracion)> (horafin - c.horaini))));
    }

    @Override      
    public String toString(){
        String res=asig;
        switch (dia){
            case 1: res+=" L ";
                    break;
            case 2: res+=" M ";
                    break;
            case 3: res+=" X ";
                    break;
            case 4: res+=" J ";
                    break;
            case 5: res+=" V ";
                    break;
            case 6: res+=" S ";
                    break;
            case 7: res+=" D ";
                    break;
        }
        res+=horaini+" "+horafin;
                
        return res;
    }


    @Override
    public int compareTo(Clase c) {
                
        return  asig.compareTo(c.asig);
    }
}
    