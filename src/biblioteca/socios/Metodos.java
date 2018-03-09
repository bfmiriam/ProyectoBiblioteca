package biblioteca.socios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Metodos {
    
    File ficheiro;
    FileWriter escribir;
    
    public void añadirSocio(Seccion nuevoSocio) throws IOException{
        try {
            ficheiro = new File("socios.txt");
            escribir = new FileWriter(ficheiro, true);
            escribir.write(nuevoSocio.guardarSocio(nuevoSocio)+"\n");
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR! "+ex.getMessage());
        }
        finally{
            escribir.close();
        }
    }
    
}
