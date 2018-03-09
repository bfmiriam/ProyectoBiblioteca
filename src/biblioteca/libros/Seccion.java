package biblioteca.libros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
    
    public static Seccion[] cargarSecciones(){
        Scanner sc;
        String linea;
        String [] lista;
        Seccion [] secciones =  new Seccion[7];
        try {
            sc =  new Scanner(new File("secciones.txt"));
            while(sc.hasNextLine()){
                linea = sc.nextLine();
                lista=linea.split(";");
                for(int i=0;i<secciones.length;i++){
                    secciones[i]=new Seccion(lista[0],lista[1]);
                    System.out.println(secciones[0]+" "+secciones[1]);
                }
            }    
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR! "+ex.getMessage());
        }
        return secciones;
    }
}