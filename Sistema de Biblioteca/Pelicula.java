public class Pelicula extends MaterialBibliografico {
    private String director;
    private int duracion; // Duración en minutos


    public Pelicula(String titulo, String autor, int anioPublicacion, String director, int duracion) {
        super(titulo, autor, anioPublicacion);
        this.director = director;
        this.duracion = duracion;
    }

    
    public String getDirector() {
        return director;
    }

    public int getDuracion() {
        return duracion;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Director: " + director);
        System.out.println("Duración: " + duracion + " minutos");
    }

    @Override
    public double calcularMultas(int diasRetraso) {
        // Película: 3 días de préstamo, $10000 por día de retraso
        if (diasRetraso <= 0) {
            return 0.0;
        }
        return 10000.0 * diasRetraso;
    }
    
    public int getDiasPrestamo() {
        return 3;
    }
    
    public double getMultaPorDia() {
        return 10000.0;
    }
}