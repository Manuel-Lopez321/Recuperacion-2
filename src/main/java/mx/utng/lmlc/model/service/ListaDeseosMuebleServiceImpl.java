package mx.utng.lmlc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.lmlc.model.dao.IListaDeseosMuebleDao;
import mx.utng.lmlc.model.entity.ListaDeseosMueble;

@Service
public class ListaDeseosMuebleServiceImpl implements IListaDeseosMuebleService{

    @Autowired
    private IListaDeseosMuebleDao dao;


    @Transactional(readOnly = true)
    @Override
    public List<ListaDeseosMueble> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(ListaDeseosMueble listaDeseosMueble) {
        dao.save(listaDeseosMueble);
    }

    @Transactional(readOnly = true)
    @Override
    public ListaDeseosMueble getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
   
}
