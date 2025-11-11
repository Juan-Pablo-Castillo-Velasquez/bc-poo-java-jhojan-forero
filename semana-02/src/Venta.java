import java.util.ArrayList;
import java.util.Date;

/**
 * Clase Venta: Representa una transacción comercial en la Librería "Mundo del Libro".
 * Se relaciona con Cliente (quién compra) y Libro (qué se compra, a través de una lista).
 */
public class Venta {

    // 1. Atributos (Mínimo 4 atributos relevantes)
    private String numeroVenta;                // Identificador único de la transacción.
    private Date fechaVenta;                   // Fecha y hora en que se realiza la venta.
    private Cliente clienteAsociado;            // Relación lógica: Objeto Cliente que realiza la compra.
    private ArrayList<Libro> itemsComprados;   // Colección: Lista de los libros incluidos en esta venta.
    private double totalVenta;                 // El monto total de la venta (se calcula).

    /**
     * Constructor para inicializar una Venta.
     * @param numeroVenta El número único de identificación de la venta.
     * @param cliente El objeto Cliente que está realizando la compra.
     */
    public Venta(String numeroVenta, Cliente cliente) {
        this.numeroVenta = numeroVenta;
        this.clienteAsociado = cliente;
        this.fechaVenta = new Date(); // Asigna la fecha actual al crearse
        this.itemsComprados = new ArrayList<>(); // Inicializa la lista de libros vacía
        this.totalVenta = 0.0;
    }

    // 2. Métodos (Mínimo 3 métodos funcionales)

    /**
     * Método funcional: Agrega un libro a la lista de ítems comprados.
     * @param libro El objeto Libro a añadir a la venta.
     */
    public void agregarLibro(Libro libro) {
        this.itemsComprados.add(libro);
        System.out.println("-> Libro añadido: " + libro.getTitulo());

        // El total se actualizará al llamar a calcularTotal(), pero podemos hacer una llamada implícita
        this.totalVenta = calcularTotal();
    }

    /**
     * Método complejo: Itera sobre la lista de libros para calcular el total.
     * Demuestra la gestión de múltiples objetos y retorna un valor calculado.
     * @return El total acumulado de todos los precios de los libros en la lista.
     */
    public double calcularTotal() {
        double total = 0.0;
        // Recorremos la colección de objetos Libro
        for (Libro libro : itemsComprados) {
            // Usamos el método de Libro para obtener su precio real con descuento
            total += libro.calcularPrecioConDescuento();
        }
        return total;
    }

    /**
     * Método void: Imprime todos los detalles de la venta de forma clara.
     */
    public void mostrarDetalleVenta() {
        System.out.println("\n=== DETALLE DE VENTA N° " + numeroVenta + " ===");
        System.out.println("Fecha: " + fechaVenta);
        System.out.println("Cliente: " + clienteAsociado.getPuntosFidelidad());
        System.out.println("Ítems (" + itemsComprados.size() + " libros):");

        // Itera sobre los libros comprados
        for (int i = 0; i < itemsComprados.size(); i++) {
            Libro libro = itemsComprados.get(i);
            System.out.printf("  %d. %s ($%.2f)\n", (i + 1), libro.getTitulo(), libro.calcularPrecioConDescuento());
        }

        System.out.printf("TOTAL DE LA VENTA: $%.2f\n", totalVenta);
        System.out.println("========================================\n");
    }

    public String getNumeroVenta() {
        return numeroVenta;
    }

    // Método Getter adicional para el total (buena práctica)
    public double getTotalVenta() {
        return totalVenta;
    }
}



