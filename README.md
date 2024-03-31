<h1 align="center">Tarea Mantenedor de Usuarios JDBC</h1>
<p>Para la tarea se requiere crear un proyecto llamado <b>ProyectoMantenedorUsuariosJDBC</b> para administrar a los usuarios de la Base de Datos, con las operaciones:</p>

-  <b>actualizar</b>
-  <b>eliminar</b>
-  <b>crear</b>
-  <b>listar</b>
-  <b>salir</b>

La tabla usuarios la pueden crear a partir del siguiente esquema DDL:
```sql
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(12) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB
```

<p>Se pide crear e implementar las clases:</p>

-  modelo <b>Usuario</b>
-  de conexión a la BBDD <b>ConexionBaseDatos</b>
-  <b>UsuarioRepositorioImpl</b> implementada a partir de la interface <b>Repositorio</b> (con generic).

<p>Para la clase de aplicación con el método main vamos a contar con un menú para poder seleccionar el tipo de operación, puede ser con la clase Scanner indicando una lista con las opciones, cada opción con un numero.</p>
<p>O bien! otra forma seria usando la clase <b>JOptionPane</b> para un menú con interfaces graficas de la siguiente forma:</p>

```java
int opcionIndice = 0;
...
 
Map<String, Integer> operaciones = new HashMap();
operaciones.put("Actualizar", 1);
operaciones.put("Eliminar", 2);
operaciones.put("Agregar", 3);
operaciones.put("Listar", 4);
operaciones.put("Salir", 5);
 
Object[] opArreglo = operaciones.keySet().toArray();
 
Object opcion = JOptionPane.showInputDialog(null,
                    "Seleccione un Operación", 
                     "Mantenedor de Usuarios", 
                     JOptionPane.INFORMATION_MESSAGE, null, opArreglo, opArreglo[0]);
 
if (opcion == null) {
    JOptionPane.showMessageDialog(null, "Debe seleccionar una operación");
} else {
    opcionIndice = operaciones.get(opcion.toString());
	
   // aca un if o switch para las distintas operaciones.
}
```

<p>Según el numero ingresado usar un if o switch para implementar cada una de las 4 operaciones y 5 para salir.</p>
<p>Todos los datos se deben ingresar mediante el teclado como parámetros.</p>
<p>Usar un do while para iterar hasta que la operación sea salir, cada vez que se selecciona una operación distinta a salir, al finalizar con dicha operación debe volver al menú para continuar con otra, al finalizar con la opción salir (5) se debe cerrar la conexión a la base de datos y finalizar el programa.</p>
