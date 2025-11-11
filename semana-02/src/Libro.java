public class Libro {

    // 1. Atributos (Mínimo 5, con tipos variados: String, double/int, boolean)

    private String isbn;            // String: Identificador único del libro (Requerimiento String)
    private String titulo;          // String: Nombre del libro
    private String autor;           // String: Nombre del autor
    private double precioVenta;     // double: Precio de venta al público (Requerimiento int/double)
    private int stockDisponible;    // int: Cantidad de unidades en el inventario
    private boolean esNovedad;      // boolean: Indica si es un lanzamiento reciente (Requerimiento boolean)

    // 2. Constructor que inicializa atributos
    /**
     * Constructor para inicializar un nuevo objeto Libro.
     * @param isbn Identificador único del libro.
     * @param titulo Título del libro.
     * @param autor Autor del libro.
     * @param precioVenta Precio de venta al público.
     * @param stockInicial Stock inicial del libro.
     */
    public Libro(String isbn, String titulo, String autor, double precioVenta, int stockInicial) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.precioVenta = precioVenta;
        this.stockDisponible = stockInicial;
        this.esNovedad = true; // Por defecto, es una novedad al registrarlo.
    }

    // 3. Métodos (Mínimo 4)

    // Método void que imprima información
    public void mostrarDetalles() {
        System.out.println("=====================================");
        System.out.println("           FICHA DEL LIBRO           ");
        System.out.println("=====================================");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("ISBN: " + isbn);
        System.out.println("Precio: $" + precioVenta);
        System.out.println("Stock Actual: " + stockDisponible + " unidades");
        System.out.println("Novedad: " + (esNovedad ? "¡Sí!" : "No"));
        System.out.println("=====================================");
    }

    // Método que retorne un valor calculado
    /**
     * Calcula el precio del libro con un descuento del 15%.
     * @return El precio final con el descuento aplicado.
     */
    public double calcularPrecioConDescuento() {
        final double DESCUENTO = 0.15; // 15%
        return precioVenta * (1 - DESCUENTO);
    }

    // Método getter (ej. para obtener el título)
    public String getTitulo() {
        return titulo;
    }

    // Método setter (ej. para cambiar el estado de novedad)
    public void setEsNovedad(boolean esNovedad) {
        this.esNovedad = esNovedad;
        System.out.println("El estado de novedad de '" + titulo + "' ha sido actualizado a " + esNovedad);
    }

    // *OPCIONAL* Un método adicional para actualizar stock y demostrar más lógica
    public void venderUnidades(int cantidad) {
        if (stockDisponible >= cantidad) {
            stockDisponible -= cantidad;
            System.out.println(cantidad + " unidades vendidas de '" + titulo + "'. Nuevo stock: " + stockDisponible);
        } else {
            System.out.println("ERROR: No hay suficiente stock para vender " + cantidad + " unidades de '" + titulo + "'.");
        }
    }
}