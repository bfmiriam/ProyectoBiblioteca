package biblioteca.libros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Ejemplar {

    private Libro libro;
    ArrayList <Libro> ejemplares = new ArrayList();
    File ficheiro;
    FileWriter escribir;
    
    public void añadirLibro(String titulo, String autor, String ISBN, int añoPublicacion, String editorial,String seccion,int numeroUnidades) throws IOException{
        String [] linea = seccion.split(" - ");
        Seccion seccionLibro = new Seccion(linea[0],linea[1]);
        for (int i=0; i<numeroUnidades;i++){
            String cod1 = titulo.substring(0, 2);
            String cod2 = autor.substring(0, 1);
            String codigo= cod1+cod2+añoPublicacion+"-"+i;
            boolean prestado=false;
            libro = new Libro(titulo,autor,ISBN,añoPublicacion,editorial,codigo,seccionLibro,prestado);
            ejemplares.add(libro);
        }
        
        try {
            ficheiro = new File("ejemplares"+titulo+".txt");
            escribir = new FileWriter(ficheiro, true);
            Iterator it = ejemplares.iterator();
            while(it.hasNext()){
                Libro ejemplar = (Libro) it.next();
                escribir.write(ejemplar.getTitulo()+";"+ejemplar.getAutor()+";"+ejemplar.getISBN()
                        +";"+ejemplar.getAñoPublicacion()+";"+ejemplar.getEditorial()
                        +";"+ejemplar.getCodigo()+";"+ejemplar.getSeccion()+";"+ejemplar.isPrestado()+"\n");
            }      
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR! "+ex.getMessage());
        }
        finally{
            escribir.close();
        }
    }
}
