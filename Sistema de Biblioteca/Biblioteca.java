import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<MaterialBibliografico> materiales;
    
    public Biblioteca() {
        this.materiales = new ArrayList<>();
    }
    
    // en esta seccion se agrega material a la biblioteca
    public void agregarMaterial(MaterialBibliografico material) {
        materiales.add(material);
        System.out.println("Material agregado de forma correcta.\n");
    }
    
    public void listarMateriales() {
        if (materiales.isEmpty()) {
            System.out.println("La biblioteca no tiene materiales registrados.\n");
            return;
        }
        
        System.out.println("=== CATALOGO DE LA BIBLIOTECA ===\n");
        for (int i = 0; i < materiales.size(); i++) {
            System.out.println("--- Material " + (i + 1) + " ---");
            materiales.get(i).mostrarInformacion();
            System.out.println("dias de préstamo: " + materiales.get(i).getDiasPrestamo());
            System.out.println("Multa por día de retraso: $" + String.format("%.0f", materiales.get(i).getMultaPorDia()));
            System.out.println();
        }
    }
    
    public void calcularMultaMaterial(int indice, int diasRetraso) {
        if (indice < 0 || indice >= materiales.size()) {
            System.out.println("Material no encontrado.\n");
            return;
        }
        
        MaterialBibliografico material = materiales.get(indice);
        double multa = material.calcularMultas(diasRetraso);
        
        System.out.println("\n--- CÁLCULO DE MULTA ---");
        System.out.println("Material: " + material.getTitulo());
        System.out.println("dias de prestamo permitidos: " + material.getDiasPrestamo());
        System.out.println("Dias de retraso: " + diasRetraso);
        System.out.println("Multa por dia de retraso: $" + String.format("%.0f", material.getMultaPorDia()));
        System.out.println("Multa total: $" + String.format("%.0f", multa) + "\n");
    }
    
    public void calcularMultasTodos(int diasRetraso) {
        if (materiales.isEmpty()) {
            System.out.println("No hay materiales en la biblioteca.\n");
            return;
        }
        
        System.out.println("\n=== CaLCULO DE MULTAS (" + diasRetraso + " dias de retraso) ===");
        double multaTotal = 0;
        
        for (MaterialBibliografico material : materiales) {
            double multa = material.calcularMultas(diasRetraso);
            System.out.println("Material: " + material.getTitulo());
            System.out.println("Multa por dia: $" + String.format("%.0f", material.getMultaPorDia()) + "×" + diasRetraso + " dias");
            System.out.println("Multa: $" + String.format("%.0f", multa));
            multaTotal += multa;
            System.out.println();
        }
        
        System.out.println("Total de multas: $" + String.format("%.0f", multaTotal) + "\n");
    }

    public int getCantidadMateriales() {
        return materiales.size();
    }
}
