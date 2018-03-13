package biblioteca.socios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;
import libreria.Biblioteca;

public class Metodos {

    static File fichero;
    static FileWriter escribir;
    static Scanner sc;
    static PrintWriter esc;

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
                Biblioteca.mostrarMensaje("El renombrado ha sido correcto");

            } else {
                Biblioteca.mostrarMensaje("El renombrado no se ha podido realizar");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR! " + ex.getMessage());
        } finally {
            escribir.close();
            sc.close();
        }
    }
}