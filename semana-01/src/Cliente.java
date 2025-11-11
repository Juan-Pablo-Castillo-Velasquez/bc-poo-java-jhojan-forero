public class Cliente {

    // 1. Atributos (Mínimo 4)
    private String documentoIdentidad; // Identificador único del cliente
    private String nombreCompleto;
    private String email;
    private int puntosFidelidad;       // Acumulación por compras (Relacionado con la librería)

    // 2. Constructor
    /**
     * Constructor para inicializar un nuevo objeto Cliente.
     * @param documentoIdentidad Cédula o número de identificación.
     * @param nombreCompleto Nombre del cliente.
     * @param email Correo electrónico.
     */
    public Cliente(String documentoIdentidad, String nombreCompleto, String email) {
        this.documentoIdentidad = documentoIdentidad;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.puntosFidelidad = 0; // Inicia sin puntos
    }

    // 3. Métodos (Mínimo 3)

    // Método 1: void que imprime la información del Cliente
    public void mostrarDatosCliente() {
        System.out.println("\n--- Datos del Cliente ---");
        System.out.println("Nombre: " + nombreCompleto);
        System.out.println("ID: " + documentoIdentidad);
        System.out.println("Email: " + email);
        System.out.println("Puntos Fidelidad: " + puntosFidelidad);
        System.out.println("-------------------------");
    }

    // Método 2: Retorna un valor (getter para los puntos)
    public int getPuntosFidelidad() {
        return puntosFidelidad;
    }

    // Método 3: Lógica funcional (interactúa con la acción de la librería)
    /**
     * Agrega puntos al cliente después de una compra.
     * @param cantidadGasto El total de la compra (simula el uso de Libro.precioVenta).
     */
    public void acumularPuntos(double cantidadGasto) {
        // Por cada $10.000 gastados, se gana 1 punto (lógica de ejemplo)
        int puntosGanados = (int) (cantidadGasto / 10000);
        this.puntosFidelidad += puntosGanados;
        System.out.println("🎉 ¡Felicidades, " + nombreCompleto + "! Has ganado " + puntosGanados + " puntos.");
    }

    // *OPCIONAL* Un método adicional para demostrar relación conceptual
    /**
     * Simula la compra de un libro, relacionando conceptualmente con la clase Libro.
     * @param libro El libro que el cliente está comprando.
     */
    public void comprarLibro(Libro libro) {
        System.out.println(nombreCompleto + " ha comprado el libro: " + libro.getTitulo());

        // El cliente acumula puntos basado en el precio de venta del libro
        this.acumularPuntos(libro.calcularPrecioConDescuento());

        // Lógica adicional que se implementaría en Libro (venderUnidades)
        // libro.venderUnidades(1);
    }
}