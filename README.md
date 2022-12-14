-----ENTREGA DE TRABAJO PRÁCTICO DE MÁQUINA-----
REALIZADO POR:
CELSO FERNANDEZ, TOBIAS BURGER Y ALEJANDRO JAITA.

ADJUNTO:
- Informe.pdf con artefactos creados durante el desarrollo.
- PracticoDeMáquina.rar contiene el codigo fuente y dentro de la carpeta 'target' el ejecutable .jar

CONSIDERACIONES PARA EJECUTAR EL PROGRAMA.

- El programa fue desarrollado y corre en el SO Windows 10.
- Si para el informe algún modelo no se puede visualizar correctamente,
  puede presionar el hipervínculo "Original" para ver el archivo original.
- Previo a la ejecución del programa, se requiere la creación de una base de datos, en
  esta versión, debe ser el sistema de gestión de base de datos PostgreSQL,
  y debe tener el siguiente nombre: 'DataBase_IngSW2'.
- En la base de datos debe estar creado el usuario llamado 'postgres' y su contraseña
  debe ser 'admin'. Sin embargo, esto y el nombre de la bd puede ser cambiado manualmente en
  el código fuente en el archivo llamado "DatosBase.java".
- Los logs son guardados en el directorio: /src/main/resources/log ,
  y en la carpeta old, se guardan logs de anteriores ejecuciones.
- Como no se pidieron los casos de uso de todas las ABM, están precargados algunos valores para tablas
  como se indica en el método "DB_Init.initTables()", el resumen de estos valores es el siguiente:
  Proveedores: (NombreFirma, CUIT)
  - La Serenita, 20438404334.
  - Miniconsumo, 20438404335.
  - Palili, 20438404336.
  Empleados: (Nombre de Usuario, Contraseña, Permisos)
  - (vacio), (vacio), Vendedor.
  - admin, 123, Administrador.
  - tobias, 123, Vendedor.
  - celso, 123, Administrador.
  - alejandro, 123, Administrador.
  Clientes: (DNI, Nombre, Moroso)
  - 12121212, Juanio, TRUE.
  - 12345678, Tobias, FALSE.
  Productos: Leche, Galletas de Chocolate, Galletas de Coco, Aceite, Chocolate, Ositos de Goma, Gomitas, Galletas de Animales.

FUNCIONALIDADES DE INTERÉS:

Se recomienda que se prueben las siguientes funcionalidades para ver lo que le podemos ofrecer al cliente:

- Crear una venta, con la situación de varios pagos en mente y comprobar que
  se puede seguir el rastro de la operación en Mostrar Venta sin ambigüedades sobre quién hizo qué pago o fiado.
- Crear un pedido, con el mínimo esfuerzo posible (solamente con productos sugeridos) a cualquier proveedor.
- Modificar el pedido, asignar fecha de entrega a hoy, para que el stock de los productos sea actualizado.
