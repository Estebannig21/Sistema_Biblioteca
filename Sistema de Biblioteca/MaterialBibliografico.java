public class MaterialBibliografico {
    private String titulo;
    private String autor;
    private int anioPublicacion;

    public MaterialBibliografico(String titulo, String autor, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public double calcularMultas(int diasRetraso) {
        if (diasRetraso <= 0) {
            return 0.0;
        }
        return 0.0;
    }
    
    public int getDiasPrestamo() {
        return 0;
    }
    
    public double getMultaPorDia() {
        return 0.0;
    }

    public void  mostrarInformacion() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año de Publicación: " + anioPublicacion);
    }

}