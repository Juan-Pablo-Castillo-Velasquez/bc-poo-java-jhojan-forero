public class Main {
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("  📚 PRUEBA DE DOMINIO: MUNDO DEL LIBRO 📚");
        System.out.println("==============================================");

        // 1. CREAR MÍNIMO 2 OBJETOS DE CADA CLASE

        // Objetos de la clase Libro (Principal)
        Libro libro1 = new Libro("978-958-42-1234-5", "Cien Años de Soledad", "G. García Márquez", 45000.00, 10);
        Libro libro2 = new Libro("978-607-12-3456-7", "El Principito", "A. de Saint-Exupéry", 32000.00, 5);

        // Objetos de la clase Cliente (Secundaria)
        Cliente cliente1 = new Cliente("1020304050", "Jhojan Forero Infante", "jhojan.f@mail.com");
        Cliente cliente2 = new Cliente("1098765432", "Laura Gómez Pérez", "laura.g@mail.com");

        System.out.println("\n--- 1. INFORMACIÓN INICIAL DE LIBROS ---");
        // Llamada al método void (mostrarDetalles) para el Libro 1
        libro1.mostrarDetalles();

        // Llamada al método getter (getTitulo) para el Libro 2
        System.out.println("\nTitulo del segundo libro (con Getter): " + libro2.getTitulo());

        System.out.println("\n--- 2. DEMOSTRACIÓN DE LÓGICA DE NEGOCIO ---");

        // Llamada al método que retorna un valor calculado para el Libro 1
        double precioDescuento1 = libro1.calcularPrecioConDescuento();
        System.out.println("El precio con descuento del libro: " + precioDescuento1);

        // Llamada al método setter (setEsNovedad) para el Libro 2
        libro2.setEsNovedad(false);
        libro2.mostrarDetalles(); // Mostramos los detalles para verificar el cambio

        // Llamada al método adicional (venderUnidades) para Libro 1
        libro1.venderUnidades(3);

        System.out.println("\n--- 3. INTERACCIÓN CLIENTE-LIBRO ---");

        // Llamada al método void (mostrarDatosCliente) para Cliente 1 (estado inicial)
        cliente1.mostrarDatosCliente();

        // Llamada al método relacional (comprarLibro) para simular la compra del Libro 1
        cliente1.comprarLibro(libro1);

        // Llamada al método relacional (comprarLibro) para simular la compra del Libro 2
        cliente1.comprarLibro(libro2);

        // Llamada al método getter (getPuntosFidelidad) y mostrarDatosCliente para Cliente 1
        System.out.println("Puntos de fidelidad de Jhojan: " + cliente1.getPuntosFidelidad());
        cliente1.mostrarDatosCliente(); // Muestra el estado final

        // Mostramos la información del Cliente 2 (para cumplir con el requisito de 2 objetos)
        cliente2.mostrarDatosCliente();
    }
}