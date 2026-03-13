public class Libro extends MaterialBibliografico {
    private String genero;
    private int numPaginas;

    public Libro(String titulo, String autor, int anioPublicacion, String genero, int numPaginas) {
        super(titulo, autor, anioPublicacion);
        this.genero = genero;
        this.numPaginas = numPaginas;
    }

    public String getGenero() {
        return genero;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Género: " + genero);
        System.out.println("Número de Páginas: " + numPaginas);
    }

    @Override
    public double calcularMultas(int diasRetraso) {
        // Libro: 14 días de préstamo, $5000 por día de retraso
        if (diasRetraso <= 0) {
            return 0.0;
        }
        return 5000.0 * diasRetraso;
    }
    
    public int getDiasPrestamo() {
        return 14;
    }
    
    public double getMultaPorDia() {
        return 5000.0;
    }
}