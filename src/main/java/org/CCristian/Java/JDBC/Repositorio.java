package org.CCristian.Java.JDBC;

import java.util.List;

public interface Repositorio <T>{

/*------------------MÉTODOS------------------*/
    void actualizar(T t);
    void eliminar(Long id);
    void crear(T t);
    List<T> listar();
}
