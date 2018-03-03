package biblioteca.socios;

import biblioteca.Libros.Ejemplar;

public class Prestamo {

    private Socio socio;
    private Ejemplar ejemplar;
    private String fechaPrestamo;
    private String fechaEntrega;
    private boolean devuelto;

    public Prestamo() {
    }

    public Prestamo(Socio socio, Ejemplar ejemplar, String fechaPrestamo, String fechaEntrega, boolean devuelto) {
        this.socio = socio;
        this.ejemplar = ejemplar;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
        this.devuelto = devuelto;
    }

    public Socio getSocio() {
        return socio;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
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

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
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
        return "Socio: " + socio + "\nEjemplar: " + ejemplar + "\nFecha del préstamo: "
                + fechaPrestamo + "\nFecha de entrega: " + fechaEntrega + "\nDevuelto: " + devuelto;
    }

}
