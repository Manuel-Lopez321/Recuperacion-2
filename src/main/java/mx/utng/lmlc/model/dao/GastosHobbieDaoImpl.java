package mx.utng.lmlc.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.lmlc.model.entity.GastosHobbie;

@Repository
public class GastosHobbieDaoImpl implements IGastosHobbieDao{
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<GastosHobbie> list() {
        return em.createQuery("from GastosHobbie").getResultList();
    }

    @Override
    public void save(GastosHobbie gastosHobbie) {
        System.out.println("GastosHobbie id="+gastosHobbie.getId());
        if(gastosHobbie.getId() != null && gastosHobbie.getId() >0){
            em.merge(gastosHobbie);
        }else{
            em.persist(gastosHobbie);
        }
    }

    @Override
    public GastosHobbie getById(Long id) {
        return em.find(GastosHobbie.class, id);
    }

    @Override
    public void delete(Long id) {
        GastosHobbie gastosHobbie = getById(id);
        em.remove(gastosHobbie);
    }

    
}