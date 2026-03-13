public class Revista extends MaterialBibliografico {
    private String periodicidad;
    private int numEdicion;
    

    public Revista(String titulo, String autor, int anioPublicacion, String periodicidad, int numEdicion) {
        super(titulo, autor, anioPublicacion);
        this.periodicidad = periodicidad;
        this.numEdicion = numEdicion;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public int getNumEdicion() {
        return numEdicion;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Periodicidad: " + periodicidad);
        System.out.println("Número de Edición: " + numEdicion);
    }

    @Override
    public double calcularMultas(int diasRetraso) {
        if (diasRetraso <= 0) {
            return 0.0;
        }
        return 3000.0 * diasRetraso;
    }
    
    public int getDiasPrestamo() {
        return 7;
    }
    
    public double getMultaPorDia() {
        return 3000.0;
    }
}