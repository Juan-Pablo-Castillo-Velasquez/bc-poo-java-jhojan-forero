public class Main {
    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════╗");
        System.out.println("║  📚 SISTEMA DE GESTIÓN: MUNDO DEL LIBRO 📚 ║");
        System.out.println("╚═══════════════════════════════════════════╝\n");

        // 1. INICIALIZAR EL SISTEMA GESTOR
        SistemaLibreria sistema = new SistemaLibreria();

        // 2. CREAR Y AGREGAR OBJETOS AL SISTEMA

        // A) 3 objetos de tipo 1: Libro
        Libro libro1 = new Libro("978-958-42-1234-5", "Cien Años de Soledad", "G. García Márquez", 45000.00, 10);
        Libro libro2 = new Libro("978-607-12-3456-7", "El Principito", "A. de Saint-Exupéry", 32000.00, 5);
        Libro libro3 = new Libro("978-84-376-5432-1", "Don Quijote", "M. de Cervantes", 58000.00, 7);

        System.out.println("=== AÑADIENDO LIBROS AL INVENTARIO ===");
        sistema.agregarLibro(libro1);
        sistema.agregarLibro(libro2);
        sistema.agregarLibro(libro3);

        // B) 3 objetos de tipo 2: Cliente (Se deben crear e implícitamente se agregarán al procesar la venta)
        Cliente cliente1 = new Cliente("1020304050", "Jhojan Forero", "jhojan.f@mail.com");
        Cliente cliente2 = new Cliente("1098765432", "Laura Gómez", "laura.g@mail.com");
        Cliente cliente3 = new Cliente("2010203040", "Carlos Ruiz", "carlos.r@mail.com");

        // C) 2 objetos de tipo 3: Venta (Demostración de INTERACCIÓN entre objetos)

        // Venta 1: Cliente Jhojan compra dos libros
        Venta venta1 = new Venta("V001", cliente1);
        venta1.agregarLibro(libro1);
        venta1.agregarLibro(libro2);

        // Venta 2: Cliente Laura compra un libro
        Venta venta2 = new Venta("V002", cliente2);
        venta2.agregarLibro(libro3);

        // 3. DEMOSTRACIÓN DE FUNCIONALIDADES DEL GESTOR

        // Procesar las ventas (Método Personalizado del Sistema)
        System.out.println("\n=== PROCESANDO VENTAS ===");
        sistema.procesarVenta(venta1, cliente1);
        sistema.procesarVenta(venta2, cliente2);

        // 4. DEMOSTRAR BÚSQUEDAS Y LISTADOS

        // Demostrar Listar objetos (Clientes)
        sistema.listarClientes();

        // Demostrar Buscar objetos (Libro)
        System.out.println("\n=== BUSCANDO LIBRO ===");
        Libro encontrado = sistema.buscarLibroPorTitulo("El Principito");
        if (encontrado != null) {
            System.out.println("✓ Libro encontrado por título:");
            encontrado.mostrarDetalles(); // Usamos el método void del Libro
        } else {
            System.out.println("❌ Libro no encontrado.");
        }


        // 5. DEMOSTRAR ESTADÍSTICAS Y CONTADORES
        System.out.println("\n=== ESTADÍSTICAS DEL DÍA ===");
        System.out.println("Total de libros en inventario: " + sistema.contarLibrosRegistrados());
        System.out.println("Total de clientes registrados: " + sistema.getTotalClientes());
        System.out.println("Total de ventas procesadas: " + sistema.getTotalVentas());

        // Verificamos los puntos acumulados por el Cliente 1 (Jhojan)
        System.out.println("\nPuntos de fidelidad de Jhojan Forero (después de 2 compras): " + cliente1.getPuntosFidelidad());

        System.out.println("\n✓ Programa de demostración finalizado exitosamente.");
    }
}