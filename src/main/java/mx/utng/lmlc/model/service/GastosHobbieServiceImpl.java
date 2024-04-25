package mx.utng.lmlc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.lmlc.model.dao.IGastosHobbieDao;
import mx.utng.lmlc.model.entity.GastosHobbie;

@Service
public class GastosHobbieServiceImpl implements IGastosHobbieService{

    @Autowired
    private IGastosHobbieDao dao;


    @Transactional(readOnly = true)
    @Override
    public List<GastosHobbie> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(GastosHobbie GastosHobbie) {
        dao.save(GastosHobbie);
    }

    @Transactional(readOnly = true)
    @Override
    public GastosHobbie getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
   
}
