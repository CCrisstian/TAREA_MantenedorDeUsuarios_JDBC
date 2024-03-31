package org.CCristian.Java.JDBC;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Tarea Mantenedor de Usuarios JDBC");

        Repositorio<Usuario> usuarioRepositorio = new UsuarioRepositorioImpl();

        Usuario usuario_Update = new Usuario();

        int opcionIndice;
        Map<String, Integer> operaciones = new HashMap<>();
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

            switch (opcionIndice) {
                case 1:
                    System.out.println("\t\tOpción 2 'Actualizar'");
                    System.out.println("Antes de 'Actualizar'");
                    usuarioRepositorio.listar().forEach(System.out::println);
                    usuarioRepositorio.actualizar(usuario_Update);
                    System.out.println("Después de 'Actualizar'");
                    usuarioRepositorio.listar().forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("\t\tOpción 2 'Eliminar'");
                    System.out.println("Antes de 'Eliminar'");
                    usuarioRepositorio.listar().forEach(System.out::println);
                    Long Id = (Long.valueOf(JOptionPane.showInputDialog("Ingrese el id del usuario que quiere eliminar")));
                    usuarioRepositorio.eliminar(Id);
                    System.out.println("Después de 'Eliminar'");
                    usuarioRepositorio.listar().forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("\t\tOpción 3 'Agregar'");
                    System.out.println("Antes de 'Agregar'");
                    usuarioRepositorio.listar().forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("\t\tOpción 4 'Listar'");
                    usuarioRepositorio.listar().forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("\t\tOpción 5 'Salir'");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }
}