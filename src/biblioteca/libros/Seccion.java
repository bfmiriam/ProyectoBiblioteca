package biblioteca.libros;

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
        return "Nombre: " + nombre + "\nLocalizacion: " + localizacion;
    }

}
