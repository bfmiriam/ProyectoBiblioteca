package biblioteca.socios;

import biblioteca.libros.Libro;
import biblioteca.libros.Seccion;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Scanner;
import libreria.Biblioteca;

public class Metodos {

    static File fichero;
    static FileWriter escribir;
    static Scanner sc;
    static PrintWriter esc;
    static private Libro libro;
    static ArrayList <Libro> ejemplares = new ArrayList();

    public static void añadirSocio(Socio nuevoSocio) throws IOException {
        try {
            fichero = new File("socios.txt");
            escribir = new FileWriter(fichero, true);
            escribir.write(nuevoSocio.guardarSocio(nuevoSocio) + "\n");
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR! " + ex.getMessage());
        } finally {
            escribir.close();
        }
    }

    public static void borrarSocio(String dni) throws IOException {
        String linea;
        File fichero2 = new File("aux.txt");
        fichero = new File("socios.txt");
        try {
            esc = new PrintWriter(fichero2);
            sc = new Scanner(fichero);
            while (sc.hasNextLine()) {
                linea = sc.nextLine();
                String[] lista = linea.split(";");
                if (!lista[2].equalsIgnoreCase(dni)) {
                    Socio nuevoSocio = new Socio(lista[0], lista[1], lista[2], lista[3], lista[4]);
                    esc.write(nuevoSocio.guardarSocio(nuevoSocio) + "\n");
                }
            }
            boolean flag = fichero2.renameTo(fichero);
            if (flag) {
                libreria.Biblioteca.mostrarMensaje("El socio ha sido eliminado con éxito");

            } else {
                libreria.Biblioteca.mostrarMensaje("Se ha producido un error. No se ha podido eliminar el socio.");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR! " + ex.getMessage());
        } finally {
            esc.close();
            sc.close();
        }
    }

    public static void anhadirPrestamo(Prestamo nuevoPrestamo,String codigo) throws IOException {
        
        try {
            fichero = new File("prestamos.txt");
            escribir = new FileWriter(fichero, true);
            escribir.write(nuevoPrestamo.guardarPrestamo(nuevoPrestamo) + "\n");
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR! " + ex.getMessage());
        } finally {
            escribir.close();
      }
        String linea;
        String [] lista;
        String [] seccionLibro;
        fichero = new File("ejemplares.txt");
        try {
            sc =  new Scanner(fichero);
            while(sc.hasNextLine()){
                linea = sc.nextLine();
                lista=linea.split(";");
                String seccionInfo = lista[6];
                seccionLibro = seccionInfo.split(" - ");
                Seccion seccion = new Seccion(seccionLibro[0],seccionLibro[1]);
                libro = new Libro(lista[0],lista[1],lista[2],Integer.parseInt(lista[3]),lista[4],lista[5],seccion,Boolean.parseBoolean(lista[7]),Integer.parseInt(lista[8]));
                ejemplares.add(libro);
            }    
        } catch (FileNotFoundException ex) {
            Biblioteca.mostrarMensaje("No se ha encontrado el fichero solicitado");
        }
        finally{
            sc.close(); 
        }
        
        Iterator it = ejemplares.iterator();
        while(it.hasNext()){
            Libro l = (Libro)it.next();
            if(l.getCodigo().equalsIgnoreCase(codigo)){
                l.setPrestado(true);
            }
        }
        try {
            fichero = new File("ejemplares.txt");
            escribir = new FileWriter(fichero);
            Iterator it2 = ejemplares.iterator();
            while(it2.hasNext()){
                Libro ejemplar = (Libro) it2.next();
                escribir.write(ejemplar.guardarEjemplar(ejemplar)+"\n");
            }      
        } catch (FileNotFoundException ex) {
            Biblioteca.mostrarMensaje("No se ha encontrado el fichero solicitado");
        }
        finally{
            escribir.close();
        }
    }

    public static ArrayList<String> escogerDni() {
        String linea;
        String[] lista;
        ArrayList<String> opciones = new ArrayList();

        try {
            sc = new Scanner(new File("socios.txt"));
            while (sc.hasNextLine()) {
                linea = sc.nextLine();
                lista = linea.split(";");

                opciones.add(lista[2]);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR! " + ex.getMessage());
        }
        return opciones;
    }

    public static ArrayList<String> escogerCodigos() {
        String linea;
        String[] lista;
        ArrayList<String> opcion = new ArrayList();

        try {
            sc = new Scanner(new File("ejemplares.txt"));
            while (sc.hasNextLine()) {
                linea = sc.nextLine();
                lista = linea.split(";");

                opcion.add(lista[5]);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR! " + ex.getMessage());
        }
        return opcion;
    }

    public static String fechaPrestamo() {

        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        String fechaP = dia + "/" + mes + "/" + año;
        return fechaP;
    }

    public static String entregarLibro() {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 15);
        Format formatter = new SimpleDateFormat("dd/MM/yyyy");
        String fechaD = formatter.format(calendar.getTime());
        return fechaD;
    }   
}
