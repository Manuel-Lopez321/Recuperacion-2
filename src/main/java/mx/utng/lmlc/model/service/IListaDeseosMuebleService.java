package mx.utng.lmlc.model.service;

import mx.utng.lmlc.model.entity.ListaDeseosMueble;
import java.util.List;

public interface IListaDeseosMuebleService {
    List<ListaDeseosMueble> list();
    void save(ListaDeseosMueble listaDeseosMueble);
    ListaDeseosMueble getById(Long id);
    void delete(Long id);
}
