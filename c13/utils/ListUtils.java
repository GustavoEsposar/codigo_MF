package c13.utils;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ListUtils {
    
    public static <T> List<T> dentroDeLista(T objeto){
        var lista = new ArrayList<T>();
        lista.add(objeto);
        return lista;
    }

    public static <T> List<T> paraLista(Enumeration<T> objetos){
        var lista = new ArrayList<T>();

        while (objetos.hasMoreElements()) {
            lista.add(objetos.nextElement());
        }

        return lista;
    }
}
