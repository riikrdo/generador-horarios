
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author monkey
 */
public class Data {
    ArrayList<Asignatura> Asignaturas = new ArrayList<Asignatura>();
    int maxTurnos=0;
    int[] solucion;
    public ArrayList <Horario> soluciones = new ArrayList <Horario>  ();
    
    Data (ArrayList <Clase> c){
        String aux="/&@FC7)VYclëÎ=ñO?¿OL*";
        int mt=0;
        for (int i=0; i<c.size(); i++){
            if (!aux.equals(c.get(i).asig))
            {
                Asignaturas.add(new Asignatura(c.get(i).asig));
                Asignaturas.get(Asignaturas.size()-1).add(c.get(i));
                mt=1;
                if (mt>maxTurnos){
                    maxTurnos=mt;
                }
            }
            else
            {
                Asignaturas.get(Asignaturas.size()-1).add(c.get(i));
                mt++;
                if (mt>maxTurnos){
                    maxTurnos=mt;
                }
            }
            aux=c.get(i).asig;
        }
        
        solucion = new int[Asignaturas.size()];
        
        
//        for (int i=0; i< Asignaturas.size(); i++){
//            for (int j=0; j< Asignaturas.get(i).clases.size(); j++){
//                System.out.println(Asignaturas.get(i).clases.get(j));
//            }
//            System.out.println();
//        }
    }
    
    Data (BufferedReader br) throws IOException{
        String linea, a1, aux;
        int dia, i;
        double horaini,horafin;
        
        int mt=0;
        
        while ( (linea = br.readLine()) != null) {
            i=0; 
            a1="";
            
            while (i < linea.length() && linea.charAt(i)!=' '){
                a1+=linea.charAt(i);
                i++;
            }
            while (i < linea.length() && linea.charAt(i)==' ') i++;
            
            if (i == linea.length()){
                
                if (!a1.equals("")){
                    Asignaturas.add(new Asignatura(a1));
                    mt=0;
                }
                
            }
            else
            {
                aux="";
                while (i < linea.length() && linea.charAt(i)!=' '){
                    aux+=linea.charAt(i);
                    i++;
                }
                while (i < linea.length() && linea.charAt(i)==' ') i++;
                horaini=Double.parseDouble(aux);
                
                aux="";
                while (i < linea.length() && linea.charAt(i)!=' '){
                    aux+=linea.charAt(i);
                    i++;
                }
                horafin=Double.parseDouble(aux);
                
                if      (a1.equals("L")) dia=1;
                else if (a1.equals("M")) dia=2;
                else if (a1.equals("X")) dia=3;
                else if (a1.equals("J")) dia=4;
                else if (a1.equals("V")) dia=5;
                else if (a1.equals("S")) dia=6;
                else                     dia=7;
                
                Asignaturas.get(Asignaturas.size()-1).Clase(dia,horaini,horafin);
                mt++;
                if (mt>maxTurnos){
                    maxTurnos=mt;
                }
                
            }    
        }
        
        solucion = new int[Asignaturas.size()];
    }
    
    
    
    void IncluyeEnSoluciones() {
        
        Clase [] temp = new Clase[Asignaturas.size()];
        
        for (int i=0; i < Asignaturas.size(); i++){
           temp[i]=Asignaturas.get(i).clases.get(solucion[i]);
        } 
        
        
        
        soluciones.add(new Horario(temp));
    }
   
    boolean Coincide(Clase c, int k){
        
        for (int j=0; j<k; j++){
            if (c.Coincide(Asignaturas.get(j).clases.get(solucion[j]))){
                return true;
            }
        }
        
        return false;
    }
    
    public void backtrack(int k) {
        for (int i = 0; i <= maxTurnos; i++) {
            if (i< Asignaturas.get(k).clases.size() && !Coincide(Asignaturas.get(k).clases.get(i),k)) {
                
                solucion[k]=i;
                
                if (k == Asignaturas.size()-1) {
                      IncluyeEnSoluciones();
                } else {
                    backtrack(k + 1);
                }
            }
        }
    }
    

}
