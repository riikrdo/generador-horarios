
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author monkey
 */
public class Dia {
    double ini;
    double fin;
    public double horas;
    public double tiempo; //fin -ini
    public double mediainifin;
    int numasignaturas;
    
    boolean [] ocupado = new boolean[30];
    int horasmuertas;
    
    Dia(){
        ini=30;
        fin=0;
        horas=0;
        tiempo=0;
        horasmuertas=0;
        mediainifin=0;
        numasignaturas=0;
        for (int i=0; i<30; i++) ocupado[i]=false;
    }
    
    //Esta función tiene traca. 
    // Las horas tienen un rango de [8,23], donde pueden haber valores medios (8:30)
    // Si lo desplazamos -8, el rango es [0-15], 
    // Pero cada hora puede ser en punto, o y media, es decir, 2 valores
    // Entonces, lo que devuelve esta en el rango [0-30]
    // Donde 8->0, 8:30->1, 9->2, 9:30->3 ... 23:00->30
    public static int hora(double h){
        
        h= (h-8)*2;
        
        int res= (int) h;
        
        if (h == res) return res;
        else          return res+1;
        
    }
    
    void Clase(Clase c){
                
        int inic=hora(c.horaini);
        int fina=hora(c.horafin);
        numasignaturas++;
        
        for (int i=inic; i < fina; i++){
            ocupado[i]=true;
        }
        
        
        if ((c.horaini < ini) && (c.horafin > fin))
        {
            ini=c.horaini;
            fin=c.horafin;
            horas += c.duracion;
            tiempo = fin-ini;
        }
        else if (c.horaini < ini)
        {
            ini=c.horaini;
            horas += c.duracion;
            tiempo = fin-ini;
        }
        else if (c.horafin > fin)
        {
            fin=c.horafin;
            horas += c.duracion;
            tiempo = fin-ini;
        }
        
    }
    
}
