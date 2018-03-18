package biblioteca.libros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import libreria.Biblioteca;

public class Ejemplar {

    private Libro libro;
    ArrayList <Libro> ejemplares = new ArrayList();
    File fichero;
    FileWriter escribir;
    Scanner sc;
    
    public ArrayList <Libro> leerFichero(){
        String linea;
        String [] elemento;
        String [] seccionLibro;
        fichero = new File("ejemplares.txt");
        try {
            sc =  new Scanner(fichero);
            while(sc.hasNextLine()){
                linea = sc.nextLine();
                elemento=linea.split(";");
                String seccionInfo = elemento[6];
                seccionLibro = seccionInfo.split(" - ");
                Seccion seccion = new Seccion(seccionLibro[0],seccionLibro[1]);
                libro = new Libro(elemento[0],elemento[1],elemento[2],Integer.parseInt(elemento[3]),elemento[4],elemento[5],seccion,Boolean.parseBoolean(elemento[7]),Integer.parseInt(elemento[8]));
                ejemplares.add(libro);
            }    
        } catch (FileNotFoundException ex) {
            Biblioteca.mostrarMensaje("No se ha encontrado el fichero solicitado");
        }
        finally{
            sc.close(); 
        }
        return ejemplares;
    }
    
    public void escribirFichero(ArrayList <Libro> ejemplares) throws IOException{
        try {
            fichero = new File("ejemplares.txt");
            escribir = new FileWriter(fichero, true);
            Iterator it = ejemplares.iterator();
            while(it.hasNext()){
                Libro ejemplar = (Libro) it.next();
                escribir.write(ejemplar.guardarEjemplar(ejemplar)+"\n");
            }      
        } catch (FileNotFoundException ex) {
            Biblioteca.mostrarMensaje("No se ha encontrado el fichero solicitado");
        }
        finally{
            escribir.close();
        }
    }
    
    public void añadirLibro(String titulo, String autor, String ISBN, int añoPublicacion, String editorial,String seccion,int numeroUnidades) throws IOException{
        String [] linea = seccion.split(" - ");
        Seccion seccionLibro = new Seccion(linea[0],linea[1]);
        for (int i=0; i<numeroUnidades;i++){
            String cod1 = titulo.substring(0, 2);
            String cod2 = autor.substring(0, 1);
            String codigo= cod1+cod2+añoPublicacion+"-"+i;
            boolean prestado=false;
            libro = new Libro(titulo,autor,ISBN,añoPublicacion,editorial,codigo,seccionLibro,prestado,numeroUnidades);
            ejemplares.add(libro);
        }
        escribirFichero(ejemplares);
    }

    public void eliminarLibro(String isbn) throws IOException{
        leerFichero();
        try {
            fichero = new File("ejemplares.txt");
            escribir = new FileWriter(fichero);
            Iterator it = ejemplares.iterator();
            while(it.hasNext()){
                Libro ejemplar = (Libro) it.next();
                if (!ejemplar.getISBN().equalsIgnoreCase(isbn)){
                    escribir.write(ejemplar.guardarEjemplar(ejemplar)+"\n");
                }
            }      
        } catch (FileNotFoundException ex) {
            Biblioteca.mostrarMensaje("No se ha encontrado el fichero solicitado");
        }
        finally{
            escribir.close();
        }
    }
    
    public ArrayList <Libro>  crearArrayISBN(String isbn){
        String linea;
        String [] elemento;
        String [] seccionLibro;
        fichero = new File("ejemplares.txt");
        ArrayList <Libro> ejemplaresISBN = new ArrayList();
        try {
            sc =  new Scanner(fichero);
            while(sc.hasNextLine()){
                linea = sc.nextLine();
                elemento=linea.split(";");
                String seccionInfo = elemento[6];
                seccionLibro = seccionInfo.split(" - ");
                Seccion seccion = new Seccion(seccionLibro[0],seccionLibro[1]);
                libro = new Libro(elemento[0],elemento[1],elemento[2],Integer.parseInt(elemento[3]),elemento[4],elemento[5],seccion,Boolean.parseBoolean(elemento[7]),Integer.parseInt(elemento[8]));
                if (libro.getISBN().equalsIgnoreCase(isbn)){
                    ejemplaresISBN.add(libro);
                }
            }    
        } catch (FileNotFoundException ex) {
            Biblioteca.mostrarMensaje("No se ha encontrado el fichero solicitado");
        }
        finally{
            sc.close(); 
        }
        return ejemplaresISBN;
    }
    
    public void cambiarUnidades(String isbn,int unidades) throws IOException{        
        ArrayList ejemplaresISBN = crearArrayISBN(isbn);
        Libro lib = (Libro)ejemplaresISBN.get(0);
        if (lib.getNumUnidades()<unidades){
            for (int i=lib.getNumUnidades(); i<unidades;i++){
                String cod1 = lib.getTitulo().substring(0, 2);
                String cod2 = lib.getAutor().substring(0, 1);
                String codigo= cod1+cod2+lib.getAñoPublicacion()+"-"+i;
                libro = new Libro(lib.getTitulo(),lib.getAutor(),lib.getISBN(),lib.getAñoPublicacion(),
                    lib.getEditorial(),codigo,lib.getSeccion(),lib.isPrestado(),unidades);
                ejemplaresISBN.add(libro);
            }
            Iterator it = ejemplaresISBN.iterator();
            while(it.hasNext()){
                Libro ejemplar = (Libro) it.next();
                ejemplar.setNumUnidades(unidades);
            }
        }else{
            int uniAhora = lib.getNumUnidades();
            int uniQuitar = uniAhora-unidades;
            int tamañoArray = ejemplaresISBN.size();
            for(int i=0;i<uniQuitar;i++){
                ejemplaresISBN.remove(ejemplaresISBN.size()-1);
            }
            Iterator it = ejemplaresISBN.iterator();
            while(it.hasNext()){
                Libro ejemplar = (Libro) it.next();
                ejemplar.setNumUnidades(unidades);
            }
        }
        eliminarLibro(isbn);  
        escribirFichero(ejemplaresISBN);
    }
    
    public ArrayList <Libro> visualizar(ArrayList <Libro> ejemplaresBiblio,String criterio, String valor){
        ArrayList <Libro> ejemplaresCriterio = new ArrayList();
        Iterator it = ejemplaresBiblio.iterator();
        while(it.hasNext()){
            Libro ejemplar = (Libro) it.next();
            switch (criterio){
                case "prestado": 
                    if (ejemplar.isPrestado()){
                        ejemplaresCriterio.add(ejemplar);
                    }
                case "Titulo":
                    if (ejemplar.getTitulo().equalsIgnoreCase(valor)){
                        ejemplaresCriterio.add(ejemplar);
                    }
                case "Autor": 
                    if (ejemplar.getAutor().equalsIgnoreCase(valor)){
                        ejemplaresCriterio.add(ejemplar);
                    }
                case "ISBN":
                    if (ejemplar.getISBN().equalsIgnoreCase(valor)){
                        ejemplaresCriterio.add(ejemplar);
                    }
            }      
        }
        return ejemplaresCriterio;
    }
}
