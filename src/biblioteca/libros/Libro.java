package biblioteca.libros;

public class Libro {
    
    private String titulo;
    private String autor;
    private String ISBN;
    private int añoPublicacion;
    public String editorial;
    private String codigo;
    private Seccion seccion;
    private boolean prestado;

    public Libro() {
    }

    public Libro(String titulo, String autor, String ISBN, int añoPublicacion, String editorial, String codigo, Seccion seccion, boolean prestado) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.añoPublicacion = añoPublicacion;
        this.editorial = editorial;
        this.codigo = codigo;
        this.seccion = seccion;
        this.prestado = prestado;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getCodigo() {
        return codigo;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setAñoPublicacion(int añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo + "\nAutor: " + autor + "\nISBN: " + ISBN + "\nAño de Publicacion: " + añoPublicacion + 
                "\nEditorial: " + editorial + "\nCodigo: " + codigo + "\nSeccion: " + seccion + "\nPrestado: " + prestado;
    }

    
}
