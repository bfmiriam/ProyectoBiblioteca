package biblioteca.socios;


public class Prestamo {

    private String dni;
    private String codigo;
    private String fechaPrestamo;
    private String fechaEntrega;
    private boolean devuelto;

    public Prestamo() {
    }

    public Prestamo(String dni, String codigo, String fechaPrestamo, String fechaEntrega, boolean devuelto) {
        this.dni = dni;
        this.codigo = codigo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
        this.devuelto = devuelto;
    }

    public String getDni() {
        return dni;
    }

    public String getCodigo() {
        return codigo;
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

    public void setSocio(String dni) {
        this.dni = dni;
    }

    public void setEjemplar(String codigo) {
        this.codigo = codigo;
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
        return "Socio: " + dni + "\nEjemplar: " + codigo + "\nFecha del préstamo: "
                + fechaPrestamo + "\nFecha de entrega: " + fechaEntrega + "\nDevuelto: " + devuelto;
    }
    
    public String guardarPrestamo(Prestamo nuevoPrestamo){
        return nuevoPrestamo.getDni()+";"+nuevoPrestamo.getCodigo()+";"+nuevoPrestamo.getFechaPrestamo()+
                ";"+nuevoPrestamo.getFechaEntrega()+";"+nuevoPrestamo.isDevuelto();
    }
}
