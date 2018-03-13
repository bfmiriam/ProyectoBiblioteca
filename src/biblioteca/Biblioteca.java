package biblioteca;

import biblioteca.aplicacion.*;
import biblioteca.libros.Ejemplar;

public class Biblioteca {

    public static void main(String[] args){
        //PaginaPrincipal pagPrincipal = new PaginaPrincipal();
        
        Ejemplar ej = new Ejemplar();
        ej.cambiarUnidades("112233", 4);
    }
}
