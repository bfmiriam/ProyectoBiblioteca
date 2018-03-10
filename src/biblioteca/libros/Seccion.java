package biblioteca.libros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Seccion {

    private String nombre;
    private String localizacion;

    public Seccion() {
    }

    public Seccion(String nombre, String localizacion) {
        this.nombre = nombre;
        this.localizacion = localizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    @Override
    public String toString() {
        return nombre + " - " + localizacion;
    }
    
    public static ArrayList <Seccion> cargarSecciones(){
        Scanner sc;
        String linea;
        String [] lista;
        ArrayList <Seccion> secciones = new ArrayList();
        try {
            sc =  new Scanner(new File("secciones.txt"));
            while(sc.hasNextLine()){
                linea = sc.nextLine();
                lista=linea.split(";");
                Seccion item =new Seccion(lista[0],lista[1]);
                secciones.add(item);
            }    
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR! "+ex.getMessage());
        }
        return secciones;
    }
}