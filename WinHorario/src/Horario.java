

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
    int totaldias,tiempoEnLaUni,horasmuertas;
    int diasconlahoradelacomidalibre;
    double mediaEntrada,desviacionHoraEntrada,mediasig,desvasig;
    
    Horario (Clase[] c){
        clases=c;
        totaldias=0;
        tiempoEnLaUni=0;
        horasmuertas=0;
        
        mediaEntrada=0; //sumatorio(dia[i].horafin-dia[i].horaini)/totaldias
        desviacionHoraEntrada=0;
        mediasig=0;
        desvasig=0;
        diasconlahoradelacomidalibre=0;
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
                tiempoEnLaUni+=dias[i].tiempoEnLaUni;
                totaldias++;
                mediaEntrada+=dias[i].ini;
                mediasig+=dias[i].numasignaturas;
            }
            
            for (int j=dias[i].ini; j <dias[i].fin; j++){
                if (!dias[i].ocupado[j]){
                    dias[i].horasmuertas++;
                    horasmuertas++;
                }
                
                for (int k=10; k <= 15; k++){
                    if (!dias[i].ocupado[k]) dias[i].horapacomer=true;
                }
                
            }
        }
        
        mediaEntrada/=totaldias;
        mediasig/=totaldias;
        for (int i=0; i<7; i++){
            if (dias[i].horasDeClase!=0){
                desviacionHoraEntrada += (dias[i].ini-mediaEntrada)*(dias[i].ini-mediaEntrada);
                desvasig += (dias[i].numasignaturas-mediasig)*(dias[i].numasignaturas-mediasig);
                if (dias[i].horapacomer) diasconlahoradelacomidalibre++;
            }
        }
        desviacionHoraEntrada/= totaldias-1;
        desviacionHoraEntrada=Math.sqrt(desviacionHoraEntrada);
        desvasig/= totaldias-1;
        desvasig=Math.sqrt(desvasig);
    }

    @Override
    public int compareTo(Horario h) 
    { 
        int res = totaldias - h.totaldias;
                
        if (res==0) res= h.diasconlahoradelacomidalibre - diasconlahoradelacomidalibre;
        
        if (res != 0) return res;
        else
        {
            double aux = desviacionHoraEntrada - h.desviacionHoraEntrada;
            
             if (aux < 0) return -1;
             else if (aux > 0) return 1;
             else{
                
        
                res = horasmuertas - h.horasmuertas;
        
                
                if (res == 0) res = tiempoEnLaUni - h.tiempoEnLaUni;  
                if (res == 0){
                    aux=desvasig-h.desvasig;
                    if      (aux < 0) return -1;
                    else if (aux > 0) return 1;
                    else return 0;
                }
                     
            
                return res;
             }
        }
    }
    
}
