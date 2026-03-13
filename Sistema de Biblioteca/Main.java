import java.util.Scanner;

public class Main {
    private static Biblioteca biblioteca = new Biblioteca();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        cargarMaterialesIniciales();
        mostrarMenuPrincipal();
        scanner.close();
    }
    
    // Cargar algunos materiales iniciales para demostración
    private static void cargarMaterialesIniciales() {
        biblioteca.agregarMaterial(new Libro("El Quijote", "Miguel de Cervantes", 1605, "Novela", 863));
        biblioteca.agregarMaterial(new Libro("Cien años de soledad", "Gabriel García Márquez", 1967, "Realismo Mágico", 417));
        biblioteca.agregarMaterial(new Revista("National Geographic", "Varios autores", 2024, "Mensual", 156));
        biblioteca.agregarMaterial(new Revista("Muy Interesante", "Varios autores", 2005, "Mensual", 89));
        biblioteca.agregarMaterial(new Pelicula("Inception", "Christopher Nolan", 2010, "Christopher Nolan", 148));
        biblioteca.agregarMaterial(new Pelicula("Nosferatu", "F.W. Murnau", 1922, "F.W. Murnau", 81));
    }
    
    // Menú principal interactivo
    private static void mostrarMenuPrincipal() {
        boolean salir = false;
        
        while (!salir) {
            System.out.println("=== MENU PRINCIPAL ===");
            System.out.println("1. Agregar Material");
            System.out.println("2. Listar Materiales");
            System.out.println("3. Simular prestamo y calcular multas");
            System.out.println("4. Salir");
            System.out.println("=====================");
            System.out.print("Selecciona una opción: ");
            
            int opcion = obtenerOpcion();
            
            switch (opcion) {
                case 1:
                    agregarMaterial();
                    break;
                case 2:
                    biblioteca.listarMateriales();
                    break;
                case 3:
                    simularPrestamo();
                    break;
                case 4:
                    salir = true;
                    System.out.println("¡Gracias por usar el sistema de biblioteca!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.\n");
            }
        }
    }
    
    // Obtener opción válida del usuario
    private static int obtenerOpcion() {
        try {
            return scanner.nextInt();
            
        } catch (java.util.InputMismatchException e) {
            scanner.nextLine(); // Limpiar buffer
            return -1;
        }
    }
    
    // Opción 1: Agregar material
    private static void agregarMaterial() {
        System.out.println("\n=== AGREGAR MATERIAL ===");
        System.out.println("Tipo de material:");
        System.out.println("1. Libro");
        System.out.println("2. Revista");
        System.out.println("3. Película");
        System.out.print("Selecciona tipo: ");
        
        int tipo = obtenerOpcion();
        scanner.nextLine(); // Limpiar buffer
        
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        
        System.out.print("Año de Publicación: ");
        int ano;
        try {
            ano = scanner.nextInt();
            scanner.nextLine();
        } catch (java.util.InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Año no válido.\n");
            return;
        }
        
        switch (tipo) {
            case 1:
                agregarLibro(titulo, autor, ano);
                break;
            case 2:
                agregarRevista(titulo, autor, ano);
                break;
            case 3:
                agregarPelicula(titulo, autor, ano);
                break;
            default:
                System.out.println("Tipo no válido.\n");
        }
    }
    
    // Agregar libro
    private static void agregarLibro(String titulo, String autor, int ano) {
        System.out.print("Género: ");
        String genero = scanner.nextLine();
        
        System.out.print("Número de Páginas: ");
        try {
            int numPaginas = scanner.nextInt();
            scanner.nextLine();
            biblioteca.agregarMaterial(new Libro(titulo, autor, ano, genero, numPaginas));
        } catch (java.util.InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Número de páginas no válido.\n");
        }
    }
    
    private static void agregarRevista(String titulo, String autor, int ano) {
        System.out.print("Periodicidad: ");
        String periodicidad = scanner.nextLine();
        
        System.out.print("Número de Edición: ");
        try {
            int numEdicion = scanner.nextInt();
            scanner.nextLine();
            biblioteca.agregarMaterial(new Revista(titulo, autor, ano, periodicidad, numEdicion));
        } catch (java.util.InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Número de edición no válido.\n");
        }
    }
    
    private static void agregarPelicula(String titulo, String autor, int ano) {
        System.out.print("Director: ");
        String director = scanner.nextLine();
        
        System.out.print("Duración (minutos): ");
        try {
            int duracion = scanner.nextInt();
            scanner.nextLine();
            biblioteca.agregarMaterial(new Pelicula(titulo, autor, ano, director, duracion));
        } catch (java.util.InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Duración no válida.\n");
        }
    }
    
    private static void simularPrestamo() {
        System.out.println("\n=== SIMULAR PRÉSTAMO ===");
        
        if (biblioteca.getCantidadMateriales() == 0) {
            System.out.println("No hay materiales en la biblioteca.\n");
            return;
        }
        
        biblioteca.listarMateriales();
        
        System.out.print("Selecciona el número del material (0 para todos): ");
        int seleccion;
        try {
            seleccion = scanner.nextInt();
            scanner.nextLine();
        } catch (java.util.InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Opción no válida.\n");
            return;
        }
        
        System.out.print("Días de retraso: ");
        int diasRetraso;
        try {
            diasRetraso = scanner.nextInt();
            scanner.nextLine();
        } catch (java.util.InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Días no válidos.\n");
            return;
        }
        
        if (seleccion == 0) {
            biblioteca.calcularMultasTodos(diasRetraso);
        } else if (seleccion > 0 && seleccion <= biblioteca.getCantidadMateriales()) {
            biblioteca.calcularMultaMaterial(seleccion - 1, diasRetraso);
        } else {
            System.out.println("Material no encontrado.\n");
        }
    }
}