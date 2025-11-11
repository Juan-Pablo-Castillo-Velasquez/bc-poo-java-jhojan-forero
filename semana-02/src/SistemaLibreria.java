
public class SistemaLibreria {
Cliente cliente;
    // Constantes para definir el tamaño máximo de los arrays
    private static final int MAX_LIBROS = 100;
    private static final int MAX_CLIENTES = 50;
    private static final int MAX_VENTAS = 100;

    // Arrays para almacenar los objetos del dominio
    private Libro[] inventarioLibros;
    private Cliente[] registroClientes;
    private Venta[] registroVentas;

    // Contadores para llevar el registro de objetos almacenados
    private int contadorLibros;
    private int contadorClientes;
    private int contadorVentas;

    /**
     * Constructor: Inicializa los arrays y los contadores.
     */
    public SistemaLibreria() {
        this.inventarioLibros = new Libro[MAX_LIBROS];
        this.registroClientes = new Cliente[MAX_CLIENTES];
        this.registroVentas = new Venta[MAX_VENTAS];
        this.contadorLibros = 0;
        this.contadorClientes = 0;
        this.contadorVentas = 0;
        System.out.println("✅ Sistema Librería inicializado.");
    }

    // ===============================================
    // MÉTODOS REQUERIDOS
    // ===============================================

    // Método 1: Agregar objeto (Libro)
    public boolean agregarLibro(Libro libro) {
        if (contadorLibros < MAX_LIBROS) {
            inventarioLibros[contadorLibros] = libro;
            contadorLibros++;
            return true;
        }
        System.out.println("❌ No hay espacio en el inventario para más libros.");
        return false;
    }

    // Método 2: Buscar por algún criterio (Libro por Título)
    /**
     * Busca un libro en el inventario por su título.
     * @param titulo El título del libro a buscar.
     * @return El objeto Libro encontrado o null si no existe.
     */
    public Libro buscarLibroPorTitulo(String titulo) {
        // Recorre solo hasta donde hay objetos registrados (contadorLibros)
        for (int i = 0; i < contadorLibros; i++) {
            // Se usa el getter getTitulo() de la clase Libro
            if (inventarioLibros[i].getTitulo().equalsIgnoreCase(titulo)) {
                return inventarioLibros[i];
            }
        }
        return null;
    }

    // Método 3: Listar todos (Clientes)
    public void listarClientes() {
        System.out.println("\n=== REGISTRO DE CLIENTES (" + contadorClientes + " Clientes) ===");
        if (contadorClientes == 0) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        for (int i = 0; i < contadorClientes; i++) {
            Cliente cliente = registroClientes[i];
            System.out.println("ID: " + cliente.getDocumentoIdentidad() + " | Nombre: " + cliente.getNombreCompleto() + " | Puntos: " + cliente.getPuntosFidelidad());
        }
        System.out.println("==============================================");
    }

    // Método 4: Contar objetos (Libros)
    public int contarLibrosRegistrados() {
        return contadorLibros;
    }

    // Método 5: Método personalizado (Procesar Venta y registrar Cliente)
    /**
     * Procesa una venta completa y registra el cliente si es nuevo.
     * Demuestra la interacción entre Libro, Cliente y Venta.
     * @param venta Objeto Venta a procesar.
     * @param cliente Objeto Cliente asociado a la venta.
     */
    public boolean procesarVenta(Venta venta, Cliente cliente) {
        // A) Lógica: Registrar Cliente si no existe (simplificado)
        if (contadorClientes < MAX_CLIENTES) {
            // Solo agregamos si aún no lo hemos hecho (por ejemplo, al crear el objeto Cliente)
            // Para esta demostración, lo agregamos directamente al array de clientes.
            registroClientes[contadorClientes] = cliente;
            contadorClientes++;
            System.out.println("✓ Cliente " + cliente.getNombreCompleto() + " registrado en el sistema.");
        }

        // B) Lógica: Registrar la Venta
        if (contadorVentas < MAX_VENTAS) {
            registroVentas[contadorVentas] = venta;
            contadorVentas++;

            // C) Lógica: Actualizar puntos del cliente
            cliente.acumularPuntos(venta.getTotalVenta());

            System.out.println("✓ Venta N°" + venta.getNumeroVenta() + " procesada exitosamente.");
            return true;
        }
        System.out.println("❌ Error al registrar la venta. Límite alcanzado.");
        return false;
    }

    // ===============================================
    // GETTERS ADICIONALES (Para manejo de contadores)
    // ===============================================

    public int getTotalVentas() {
        return contadorVentas;
    }

    public int getTotalClientes() {
        return contadorClientes;
    }
}