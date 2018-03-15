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
    private int numUnidades;

    public Libro() {
    }

    public Libro(String titulo, String autor, String ISBN, int añoPublicacion, String editorial, String codigo, Seccion seccion, boolean prestado, int numUnidades) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.añoPublicacion = añoPublicacion;
        this.editorial = editorial;
        this.codigo = codigo;
        this.seccion = seccion;
        this.prestado = prestado;
        this.numUnidades= numUnidades;
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

    public int getNumUnidades() {
        return numUnidades;
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

    public void setNumUnidades(int numUnidades) {
        this.numUnidades = numUnidades;
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo + "\nAutor: " + autor + "\nISBN: " + ISBN + "\nAño de Publicacion: " + añoPublicacion + 
                "\nEditorial: " + editorial + "\nCodigo: " + codigo + "\nSeccion: " + seccion + "\nPrestado: " + prestado+"\nUnidades totales: "+numUnidades;
    }

    public String guardarEjemplar(Libro libro){
        return libro.getTitulo()+";"+libro.getAutor()+";"+libro.getISBN()+";"+libro.getAñoPublicacion()+";"+libro.getEditorial()
                +";"+libro.getCodigo()+";"+libro.getSeccion()+";"+libro.isPrestado()+";"+libro.getNumUnidades();
    }
    
    public String mostrarLista(){
        return codigo +"   -   "+ titulo +"   -   "+ autor +"   -   "+ ISBN +"   -   "+ añoPublicacion 
              +"   -   "+ editorial +"   -   "+ seccion;
    }
    
    public String mostrar(){
        String prestamo;
        if (prestado){
            prestamo = "El ejemplar esta prestado";
        }else{
            prestamo = "El ejemplar esta disponible";
        }
        return codigo +"   -   "+ titulo +"   -   "+ autor +"   -   "+ ISBN +"   -   "+ añoPublicacion 
              +"   -   "+ editorial +"   -   "+seccion+"   -   "+prestamo;
    }
}
