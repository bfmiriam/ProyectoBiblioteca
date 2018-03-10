package biblioteca.libros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ejemplar {

    private Libro libro;
    ArrayList <Libro> ejemplares = new ArrayList();
    File ficheiro;
    FileWriter escribir;
    Scanner sc;
    
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
            ficheiro = new File("ejemplares.txt");
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
    
    public void eliminarLibro(String isbn){
        String linea;
        String [] elemento;
        String [] seccionLibro;
        try {
            sc =  new Scanner(new File("ejemplares.txt"));
            while(sc.hasNextLine()){
                linea = sc.nextLine();
                System.out.println(linea);
                elemento=linea.split(";");
                //String seccionInfo = elemento[6];
                //seccionLibro = seccionInfo.split(" - ");
                //Seccion seccion = new Seccion(seccionLibro[0],seccionLibro[1]);
                for (int i=0;i<elemento.length;i++){
                    System.out.println(i+"- "+elemento[i]);
                }
                
                //libro = new Libro(elemento[0],elemento[1],elemento[2],Integer.parseInt(elemento[3]),elemento[4],elemento[5],seccion,Boolean.parseBoolean(elemento[7]));
                //System.out.println(libro);
                //ejemplares.add(libro);
            }    
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR! "+ex.getMessage());
        }
        finally{
            sc.close();
        }
    }
}
