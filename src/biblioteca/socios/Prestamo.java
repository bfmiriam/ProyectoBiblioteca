package biblioteca.socios;


public class Prestamo {

    private String dni;
    private String codigo;
    private String fechaPrestamo;
    private String fechaEntrega;
    private boolean prestado;

    public Prestamo() {
    }

    public Prestamo(String dni, String codigo, String fechaPrestamo, String fechaEntrega, boolean devuelto) {
        this.dni = dni;
        this.codigo = codigo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
        this.prestado = devuelto;
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

    public boolean isPrestado() {
        return prestado;
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

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    @Override
    public String toString() {
        return "Socio: " + dni + "\nEjemplar: " + codigo + "\nFecha del préstamo: "
                + fechaPrestamo + "\nFecha de entrega: " + fechaEntrega + "\nPrestado: " + prestado;
    }
    
    public String guardarPrestamo(Prestamo nuevoPrestamo){
        return nuevoPrestamo.getDni()+";"+nuevoPrestamo.getCodigo()+";"+nuevoPrestamo.getFechaPrestamo()+
                ";"+nuevoPrestamo.getFechaEntrega()+";"+nuevoPrestamo.isPrestado();
    }
}
