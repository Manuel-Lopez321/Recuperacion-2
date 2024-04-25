package mx.utng.lmlc.model.dao;

import java.util.List;

import mx.utng.lmlc.model.entity.ListaDeseosMueble;

public interface IListaDeseosMuebleDao {
    List<ListaDeseosMueble> list();
    void save(ListaDeseosMueble listaDeseosMueble);
    ListaDeseosMueble getById(Long id);
    void delete(Long id);
}
