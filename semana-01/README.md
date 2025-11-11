# Análisis Orientado a Objetos - Librería "Mundo del Libro"

## 1. Identificación del Dominio

**Nombre del negocio:** Mundo del Libro
**Tipo:** Librería y Papelería
**Descripción:** Librería ubicada en Bogotá que vende libros (académicos, literatura, infantiles), útiles escolares y material didáctico. El sistema busca modelar los artículos de venta (libros) y las entidades que los consumen (clientes).

---

## 2. Objetos Identificados

### Objeto Principal: Libro

**¿Qué es?:** Es el artículo central y principal que la librería ofrece para la venta.
**Clase Implementada:** `Libro.java`

**Atributos identificados:**
- **isbn:** String - Identificador único y estándar para el libro.
- **titulo:** String - Nombre formal de la obra.
- **autor:** String - Nombre del escritor o creador de la obra.
- **precioVenta:** double - Valor monetario de venta al público.
- **stockDisponible:** int - Cantidad de unidades físicas que hay en el inventario.
- **esNovedad:** boolean - Indica si el libro es un lanzamiento reciente (True/False).

**Métodos identificados:**
- **mostrarDetalles():** Muestra toda la información del libro en consola. (Método `void`)
- **calcularPrecioConDescuento():** Calcula y retorna el precio final del libro aplicando una promoción. (Método que retorna un valor calculado)
- **getTitulo():** Retorna el título del libro. (Método `getter`)
- **setEsNovedad(boolean esNovedad):** Permite cambiar el estado de novedad del libro. (Método `setter`)

---

### Objeto Secundario: Cliente

**¿Qué es?:** Es la persona que interactúa con la librería para adquirir los productos.
**Clase Implementada:** `Cliente.java`

**Atributos identificados:**
- **documentoIdentidad:** String - Número único de identificación del cliente.
- **nombreCompleto:** String - Nombre y apellido del cliente.
- **email:** String - Correo electrónico de contacto.
- **puntosFidelidad:** int - Puntos acumulados en el programa de fidelización de la librería.

**Métodos identificados:**
- **mostrarDatosCliente():** Imprime la información básica y los puntos del cliente. (Método `void`)
- **getPuntosFidelidad():** Retorna la cantidad actual de puntos del cliente. (Método que retorna un valor)
- **acumularPuntos(double cantidadGasto):** Actualiza el total de puntos del cliente basado en la cantidad de dinero gastada en la compra de un libro. (Método funcional)
- **comprarLibro(Libro libro):** Simula el proceso de compra, utilizando la información del libro para calcular la ganancia de puntos. (Método relacional/funcional)

---

## 3. Relación entre Objetos

**Tipo de relación:** Asociación (Unidireccional simple).

**Descripción:** Los objetos se relacionan mediante una asociación. El `Cliente` necesita conocer el objeto `Libro` para realizar la acción de **comprar**.

* La clase `Cliente` tiene un método (`comprarLibro(Libro libro)`) que recibe un objeto de tipo `Libro` como parámetro.
* Esto permite al cliente interactuar con los datos y la lógica del libro (ej. saber su título, obtener su precio con descuento para calcular los puntos) sin que el `Libro` necesite conocer al `Cliente`. En el contexto de la librería, **el Cliente es el actor que opera sobre el Libro**.

---

## 4. Justificación del Diseño

**¿Por qué elegí estos objetos?**
Elegí **Libro** y **Cliente** porque representan las dos entidades fundamentales en cualquier negocio de venta al por menor: el **producto** y el **consumidor**. Modelar estas dos clases es el primer paso lógico para simular cualquier transacción en la librería.

**¿Por qué estos atributos son importantes?**
* **Identificación (`isbn`, `documentoIdentidad`):** Permiten diferenciar un objeto de otro de forma única, esencial para cualquier sistema de gestión.
* **Información de Negocio (`precioVenta`, `stockDisponible`, `puntosFidelidad`):** Contienen los datos que son objeto de la lógica de negocio (inventario, precios, fidelización).
* **Características Descriptivas (`titulo`, `autor`, `esNovedad`, `nombreCompleto`, `email`):** Proveen la información necesaria para el usuario o para realizar búsquedas.

**¿Por qué estos métodos son necesarios?**
Los métodos modelan las acciones y responsabilidades de cada objeto:
* `Libro.calcularPrecioConDescuento()`: Es la **lógica de negocio** sobre el producto.
* `Libro.venderUnidades()`: Modifica el **estado** del objeto (reduce `stockDisponible`), reflejando una acción del mundo real.
* `Cliente.acumularPuntos()`: Modifica el **estado** del cliente, reflejando el programa de fidelidad de la librería.
* Los **Getters/Setters** permiten el acceso y modificación controlada de los atributos (Principio de Encapsulamiento).

---

## 5. Comparación: POO vs Programación Estructurada

**Sin POO (Estructurado):**
Para registrar y gestionar un libro, usaríamos variables sueltas (`isbn_libro1`, `titulo_libro1`, `precio_libro1`, etc.) y tendríamos funciones separadas (`calcular_descuento(precio, tasa)`, `mostrar_info(titulo, autor, precio)`). Si tuviéramos 100 libros, tendríamos que manejar 100 grupos de variables. La lógica y los datos estarían desvinculados, haciendo el código repetitivo y difícil de mantener.

**Con POO:**
Utilizamos la **clase `Libro`** como un molde. Cada libro (`libro1`, `libro2`) es un **objeto** que contiene sus propios datos (atributos) y conoce las acciones que puede realizar (`calcularPrecioConDescuento()`). Esto agrupa datos y lógica en una sola entidad cohesiva, haciendo el código modular y escalable.

**Ventajas específicas en mi dominio:**
1.  **Cohesión del Producto:** El objeto `Libro` asegura que el precio, el stock y el ISBN siempre viajen juntos, evitando errores al pasar datos sueltos entre funciones.
2.  **Modelado de la Acción:** La relación explícita entre `Cliente` y `Libro` a través del método `comprarLibro(Libro)` simula de manera directa y legible la transacción central del negocio.
3.  **Facilidad de Extensión:** Si el día de mañana se añade el objeto `Proveedor`, este solo necesita interactuar con el método `venderUnidades()` o `setPrecioVenta()`, sin alterar la lógica interna del `Libro`.

---

## 6. Diagrama de Clases (Opcional)

Este diagrama muestra la estructura de las dos clases y la asociación unidireccional.