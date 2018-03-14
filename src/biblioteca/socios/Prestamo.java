package biblioteca.socios;

import biblioteca.libros.Libro;

public class Prestamo {

    private Socio socio;
    private Libro libro;
    private String fechaPrestamo;
    private String fechaEntrega;
    private boolean devuelto;

    public Prestamo() {
    }

    public Prestamo(Socio socio, Libro libro, String fechaPrestamo, String fechaEntrega, boolean devuelto) {
        this.socio = socio;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
        this.devuelto = devuelto;
    }

    public Socio getSocio() {
        return socio;
    }

    public Libro getEjemplar() {
        return libro;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public void setEjemplar(Libro libro) {
        this.libro = libro;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

    @Override
    public String toString() {
        return "Socio: " + socio + "\nEjemplar: " + libro + "\nFecha del préstamo: "
                + fechaPrestamo + "\nFecha de entrega: " + fechaEntrega + "\nDevuelto: " + devuelto;
    }

}
