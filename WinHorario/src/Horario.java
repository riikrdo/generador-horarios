

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author monkey
 */
public class Horario implements Comparable <Horario> {
    Clase[] clases;
    Dia[] dias;
    int totaldias;
    int peso;
    int horasmuertas;
    
    Horario (Clase[] c){
        clases=c;
        totaldias=0;
        peso=0;
        horasmuertas=0;
        
        dias = new Dia[7];
        for (int i=0; i<7;i++) dias[i]=new Dia();
        
        for (int i=0; i < clases.length; i++)
        {
            dias[clases[i].dia-1].Clase(c[i]);
        }
        
        for (int i=0; i<7;i++)
        {
            if (dias[i].horas != 0)
            {
                peso+=dias[i].tiempo;
                totaldias++;
            }
            
            int init=Dia.hora(dias[i].ini),
                 fin=Dia.hora(dias[i].fin);
            
            for (int j=init; j <fin; j++){
                if (!dias[i].ocupado[j]){
                    dias[i].horasmuertas++;
                    horasmuertas++;
                }
            }
        }
        
        
    }

    @Override
    public int compareTo(Horario h) 
    { 
        int res = horasmuertas - h.horasmuertas;
        
        
        if (res == 0) res = peso - h.peso;
        
        if (res == 0) res = totaldias - h.totaldias;
        
        return res;
    }
    
}
