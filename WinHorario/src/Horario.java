

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
    int totaldias,peso,horasmuertas;
    
    double media,desviacion,mediasig,desvasig;
    
    Horario (Clase[] c){
        clases=c;
        totaldias=0;
        peso=0;
        horasmuertas=0;
        
        media=0; //sumatorio(dia[i].horafin-dia[i].horaini)/totaldias
        desviacion=0;
        mediasig=0;
        desvasig=0;
        
        dias = new Dia[7];
        for (int i=0; i<7;i++) dias[i]=new Dia();
        
        for (int i=0; i < clases.length; i++)
        {
            dias[clases[i].dia-1].Clase(c[i]);
        }
        
        for (int i=0; i<7;i++)
        {
            if (dias[i].horasDeClase != 0)
            {
                peso+=dias[i].tiempoEnLaUni;
                totaldias++;
                media+=dias[i].fin-dias[i].ini;
                mediasig+=dias[i].numasignaturas;
            }
            
            for (int j=dias[i].ini; j <dias[i].fin; j++){
                if (!dias[i].ocupado[j]){
                    dias[i].horasmuertas++;
                    horasmuertas++;
                }
            }
        }
        
        media/=totaldias;
        mediasig/=totaldias;
        for (int i=0; i<7; i++){
            if (dias[i].horasDeClase!=0){
                desviacion += (dias[i].fin-dias[i].ini-media)*(dias[i].fin-dias[i].ini-media);
                desvasig += (dias[i].numasignaturas-mediasig)*(dias[i].numasignaturas-mediasig);
            }
        }
        desviacion/= totaldias-1;
        desviacion=Math.sqrt(desviacion);
        desvasig/= totaldias-1;
        desvasig=Math.sqrt(desvasig);
    }

    @Override
    public int compareTo(Horario h) 
    { 
        int res = totaldias - h.totaldias;
        
        if (res == 0) res = horasmuertas - h.horasmuertas;
        
        if (res == 0) res = peso - h.peso;
        
        
        return res;
//        double res = desviacion - h.desviacion;
        
//        if      (res < 0) return -1;
//        else if (res > 0) return  1;
//        else {
//            
//            int r = horasmuertas - h.horasmuertas;
//            
//             if (r == 0) r = peso - h.peso;
//        
//             if (r == 0) r = totaldias - h.totaldias;
//        
//             return r;         
//        }
        
    }
    
}
