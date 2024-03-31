package org.CCristian.Java.JDBC;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Tarea Mantenedor de Usuarios JDBC");
        Repositorio<Usuario> usuarioRepositorio = new UsuarioRepositorioImpl();
        Usuario usuario_Update = new Usuario();

        int opcionIndice = 0;
        Map<String, Integer> operaciones = new HashMap<>();
        operaciones.put("Actualizar", 1);
        operaciones.put("Eliminar", 2);
        operaciones.put("Crear", 3);
        operaciones.put("Listar", 4);
        operaciones.put("Salir", 5);

        Object[] opArreglo = operaciones.keySet().toArray();

        while (opcionIndice != 5){
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
                        System.out.println("\n\t\tOpción 1 'Actualizar'");
                        mostrar_Antes(usuarioRepositorio, opcionIndice);
                        usuarioRepositorio.actualizar(usuario_Update);
                        mostrar_Despues(usuarioRepositorio, opcionIndice);
                        break;
                    case 2:
                        System.out.println("\n\t\tOpción 2 'Eliminar'");
                        mostrar_Antes(usuarioRepositorio, opcionIndice);
                        Long Id = (Long.valueOf(JOptionPane.showInputDialog("Ingrese el id del usuario que quiere eliminar")));
                        usuarioRepositorio.eliminar(Id);
                        mostrar_Despues(usuarioRepositorio, opcionIndice);
                        break;
                    case 3:
                        System.out.println("\n\t\tOpción 3 'Crear'");
                        mostrar_Antes(usuarioRepositorio, opcionIndice);
                        usuarioRepositorio.crear(usuario_Update);
                        mostrar_Despues(usuarioRepositorio, opcionIndice);
                        break;
                    case 4:
                        System.out.println("\n\t\tOpción 4 'Listar'");
                        System.out.println("id| username |  password  |    email");
                        usuarioRepositorio.listar().forEach(System.out::println);
                        break;
                    case 5:
                        System.out.println("\n\t\tOpción 5 'Salir'");
                        break;
                    default:
                        System.out.println("\nOpción no válida");
                        break;
                }
            }
        }
    }
    public static void mostrar_Antes(Repositorio<Usuario> usuarioRepositorio, int opcionIndice){
        String palabra = switch_palabra(opcionIndice);
        System.out.printf("\nAntes de %s\n", palabra);
        System.out.println("id| username |  password  |    email");
        usuarioRepositorio.listar().forEach(System.out::println);
    }

    public static void mostrar_Despues(Repositorio<Usuario> usuarioRepositorio, int opcionIndice){
        String palabra = switch_palabra(opcionIndice);
        System.out.printf("\nDespués de %s\n", palabra);
        System.out.println("id| username |  password  |    email");
        usuarioRepositorio.listar().forEach(System.out::println);
    }

    public static String switch_palabra(int opcionIndice){
        String palabra = null;
        switch (opcionIndice) {
            case 1:
                palabra = "'Actualizar'";
                break;
            case 2:
                palabra = "'Eliminar'";
                break;
            case 3:
                palabra = "'Crear'";
                break;
            default:
                break;
        }
        return palabra;
    }
}