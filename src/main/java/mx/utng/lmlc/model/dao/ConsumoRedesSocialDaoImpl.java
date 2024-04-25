package mx.utng.lmlc.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.lmlc.model.entity.ConsumoRedesSocial;

@Repository
public class ConsumoRedesSocialDaoImpl implements IConsumoRedesSocialDao{
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<ConsumoRedesSocial> list() {
        return em.createQuery("from ConsumoRedesSocial").getResultList();
    }

    @Override
    public void save(ConsumoRedesSocial consumoRedesSocial) {
        System.out.println("ConsumoRedesSocial id="+consumoRedesSocial.getId());
        if(consumoRedesSocial.getId() != null && consumoRedesSocial.getId() >0){
            em.merge(consumoRedesSocial);
        }else{
            em.persist(consumoRedesSocial);
        }
    }

    @Override
    public ConsumoRedesSocial getById(Long id) {
        return em.find(ConsumoRedesSocial.class, id);
    }

    @Override
    public void delete(Long id) {
        ConsumoRedesSocial consumoRedesSocial = getById(id);
        em.remove(consumoRedesSocial);
    }

    
}