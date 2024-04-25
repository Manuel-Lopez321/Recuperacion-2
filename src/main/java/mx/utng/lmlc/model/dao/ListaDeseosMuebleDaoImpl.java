package mx.utng.lmlc.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.lmlc.model.entity.ListaDeseosMueble;

@Repository
public class ListaDeseosMuebleDaoImpl implements IListaDeseosMuebleDao{
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<ListaDeseosMueble> list() {
        return em.createQuery("from ListaDeseosMueble").getResultList();
    }

    @Override
    public void save(ListaDeseosMueble listaDeseosMueble) {
        System.out.println("ListaDeseosMueble id="+listaDeseosMueble.getId());
        if(listaDeseosMueble.getId() != null && listaDeseosMueble.getId() >0){
            em.merge(listaDeseosMueble);
        }else{
            em.persist(listaDeseosMueble);
        }
    }

    @Override
    public ListaDeseosMueble getById(Long id) {
        return em.find(ListaDeseosMueble.class, id);
    }

    @Override
    public void delete(Long id) {
        ListaDeseosMueble listaDeseosMueble = getById(id);
        em.remove(listaDeseosMueble);
    }

    
}