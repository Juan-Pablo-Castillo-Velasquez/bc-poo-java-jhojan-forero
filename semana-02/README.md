# Análisis OO - Semana 02: Librería "Mundo del Libro"

## 1. Evolución del Modelo

El modelo ha pasado de ser una simple representación de entidades a un **sistema de gestión funcional**, incorporando la lógica de transacción y la centralización de datos.

### Semana 01 (Recap)
- **Clase 1: Libro** - Modelaba el producto principal de la librería (atributos, precio con descuento, stock).
- **Clase 2: Cliente** - Modelaba al consumidor (atributos, lógica de puntos de fidelidad).

### Semana 02 (Nuevas Adiciones)
- **Clase 3: Venta** - Modela la transacción comercial, uniendo al Cliente con los productos comprados. **Justificación:** Era necesaria para pasar de entidades estáticas a un proceso de negocio dinámico. Resuelve el problema de rastrear qué se compró, por quién y a qué precio final.
- **Clase Sistema: SistemaLibreria** - Clase gestora central que almacena y administra colecciones de todos los objetos de dominio. **Justificación:** Resuelve el problema de la persistencia (simulada con arrays) y la gestión de la lógica global del sistema (búsqueda, listado, procesamiento de transacciones).

---

## 2. Nueva Clase: Venta

### Justificación
La clase `Venta` es esencial porque:
* **Problema que Resuelve:** Permite registrar los eventos de compra de forma atómica. Sin esta clase, la compra de múltiples libros por un cliente sería difícil de auditar o de calcular de forma integrada.
* **Modelo Transaccional:** Actúa como el **Registro** de la lógica de negocio, capturando la fecha, el cliente y la lista de ítems en el momento exacto de la compra.

### Atributos
- **numeroVenta:** String - Identificador único de la transacción. Es vital para rastrear la venta.
- **clienteAsociado:** Cliente - Objeto `Cliente` relacionado. Justificación: Necesario para saber quién compró y actualizar sus puntos.
- **itemsComprados:** ArrayList`<Libro>` - Colección de objetos `Libro`. Justificación: Permite modelar que una sola venta puede contener múltiples productos (requisito de **gestión de múltiples objetos**).
- **totalVenta:** double - El costo final de la venta. Justificación: Necesario para imprimir el recibo y para el cálculo de puntos del cliente.

### Métodos
- **agregarLibro(Libro libro):** Añade un objeto `Libro` a la colección `itemsComprados`. Justificación: Método fundamental para construir la venta ítem por ítem.
- **calcularTotal():** Recorre el `ArrayList` de libros, llama a `Libro.calcularPrecioConDescuento()` en cada uno y suma el resultado. Justificación: Contiene la lógica compleja del cálculo de negocio.
- **mostrarDetalleVenta():** Muestra toda la información de la venta, incluyendo los ítems individuales. Justificación: Cumple con el requisito de salida y proporciona un resumen de la transacción.

### Relaciones
- **Con Libro:** Relación de **Agregación/Composición** (1 a Muchos). Una `Venta` **contiene** múltiples objetos `Libro` en su `ArrayList`.
- **Con Cliente:** Relación de **Asociación** (1 a 1). La `Venta` está asociada a un único `Cliente` a través del atributo `clienteAsociado`.

---

## 3. Clase Sistema/Gestor (SistemaLibreria)

### Responsabilidades
1.  **Almacenamiento (Persistencia simulada):** Almacenar y mantener el inventario de `Libro`s, el registro de `Cliente`s y las `Venta`s procesadas.
2.  **Consulta:** Ofrecer métodos para buscar (`buscarLibroPorTitulo`) y listar (`listarClientes`) los objetos almacenados.
3.  **Orquestación de Procesos:** Unir la lógica de varias clases en un único método de negocio, como en `procesarVenta()`.

### Decisiones de Diseño
- **¿Por qué usar arrays? (vs otras estructuras):** Se eligió usar arrays (de tamaño fijo) y contadores (ej: `contadorLibros`) para **cumplir los requisitos de la semana** de gestionar arrays. Si el proyecto evolucionara, se migraría a `ArrayList<T>` para una gestión dinámica más eficiente.
- **¿Qué capacidad máxima definiste y por qué?:** Se definieron capacidades como `MAX_LIBROS = 100`, `MAX_CLIENTES = 50`, etc. Estas capacidades fijas simulan una restricción de capacidad del sistema y obligan a manejar el contador para prevenir errores de desbordamiento de array.
- **¿Cómo manejas las búsquedas?:** El método `buscarLibroPorTitulo()` utiliza un **bucle `for`** tradicional para iterar desde el índice 0 hasta el valor del contador (`contadorLibros`), comparando el título del libro con el criterio de búsqueda.

### Métodos Clave
- **agregarLibro():** Verifica que el array no esté lleno y luego inserta el nuevo objeto `Libro` en la posición indicada por el contador, incrementando dicho contador.
- **buscarLibroPorTitulo():** Devuelve el objeto `Libro` encontrado o `null` si la búsqueda no tiene éxito, permitiendo que el `Main` o el gestor manejen el caso de "no encontrado".
- **procesarVenta():** Este método orquesta la lógica: recibe la venta y el cliente, registra ambos en sus respectivos arrays, y crucialmente, llama a `cliente.acumularPuntos(venta.getTotalVenta())`, demostrando la **interacción compleja** entre las tres clases.