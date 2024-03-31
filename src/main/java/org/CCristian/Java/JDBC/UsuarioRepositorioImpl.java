package org.CCristian.Java.JDBC;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsuarioRepositorioImpl implements Repositorio<Usuario>{

/*------------------MÉTODOS------------------*/
    public Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    @Override
    public void actualizar(Usuario usuario) {
        int update;
        Map<String, Integer> opciones_Update = new HashMap();
        opciones_Update.put("username", 1);
        opciones_Update.put("password", 2);
        opciones_Update.put("email", 4);
        Object[] opArreglo_Update = opciones_Update.keySet().toArray();
        Object opcion_Update;
        usuario.setId(Long.valueOf(JOptionPane.showInputDialog("Ingrese el id del usuario que quiere actualizar")));
        opcion_Update = JOptionPane.showInputDialog(null, "Update", "Actualizar Usuarios", JOptionPane.INFORMATION_MESSAGE, null, opArreglo_Update, opArreglo_Update[0]);
        update = opciones_Update.get(opcion_Update.toString());
        switch (update) {
            case 1:
                try (Connection connection = getConnection();
                     PreparedStatement preparedSt = connection.prepareStatement("UPDATE usuarios SET username=? WHERE id=?"))
                {
                    preparedSt.setLong(2, usuario.getId());
                    usuario.setUsername(JOptionPane.showInputDialog("Ingrese el 'username'"));
                    preparedSt.setString(1, usuario.getUsername());
                    preparedSt.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 2:
                try (Connection connection = getConnection();
                     PreparedStatement preparedSt = connection.prepareStatement("UPDATE usuarios SET password=? WHERE id=?"))
                {
                    preparedSt.setLong(2, usuario.getId());
                    usuario.setPassword(JOptionPane.showInputDialog("Ingrese el 'password'"));
                    preparedSt.setString(1, usuario.getPassword());
                    preparedSt.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 3:
                try (Connection connection = getConnection();
                     PreparedStatement preparedSt = connection.prepareStatement("UPDATE usuarios SET email=? WHERE id=?"))
                {
                    preparedSt.setLong(2, usuario.getId());
                    usuario.setEmail(JOptionPane.showInputDialog("Ingrese el 'email'"));
                    preparedSt.setString(1, usuario.getEmail());
                    preparedSt.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    @Override
    public void eliminar(Long id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedSt = connection.prepareStatement("DELETE FROM usuarios WHERE id=?")){
            preparedSt.setLong(1, id);
            preparedSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void crear(Usuario usuario) {

    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM usuarios"))
        {
            while (resultSet.next()){
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getLong("id"));
                usuario.setUsername(resultSet.getString("username"));
                usuario.setPassword(resultSet.getString("password"));
                usuario.setEmail(resultSet.getString("email"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuarios;
    }
}
