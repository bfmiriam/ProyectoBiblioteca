package biblioteca.libros;

import biblioteca.socios.Socio;

public class Ejemplar extends Libro {

    private String codigo;
    private Socio socio;
    private boolean prestado;

    public Ejemplar() {

    }

    public Ejemplar(String codigo, Socio socio, String titulo, String autor, String ISBN, int añoPublicacion, String editorial, boolean prestado) {
        super(titulo, autor, ISBN, añoPublicacion, editorial);
        this.codigo = codigo;
        this.socio = socio;
        this.prestado = prestado;
    }

    public String getCodigo() {
        return codigo;
    }

    public Socio getSocio() {
        return socio;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    @Override
    public String toString() {
        return "Titulo: " + getTitulo() + "\nAutor: " + getAutor() + "\nISBN: "
                + getISBN() + "\nAñoPublicacion: " + getAñoPublicacion()
                + "\nEditorial: " + getEditorial() + "\ncodigo: " + codigo + "\nsocio: "
                + socio + "\nPrestado" + prestado;
    }

}
