
import java.util.ArrayList;

public class Asignatura {
    String nombre;
    public ArrayList <Clase> clases = new ArrayList<Clase>();
    
    Asignatura(String n){
        nombre=n;
    }
    
    void Clase(int dia, int ini, int fin){
        clases.add(new Clase(nombre,dia,ini,fin));
    }
    
    void add(Clase c){
        clases.add(c);
    }
}
