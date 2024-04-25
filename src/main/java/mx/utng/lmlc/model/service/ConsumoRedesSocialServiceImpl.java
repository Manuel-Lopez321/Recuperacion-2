package mx.utng.lmlc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.lmlc.model.dao.IConsumoRedesSocialDao;
import mx.utng.lmlc.model.entity.ConsumoRedesSocial;

@Service
public class ConsumoRedesSocialServiceImpl implements IConsumoRedesSocialService{

    @Autowired
    private IConsumoRedesSocialDao dao;


    @Transactional(readOnly = true)
    @Override
    public List<ConsumoRedesSocial> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(ConsumoRedesSocial consumoRedesSocial) {
        dao.save(consumoRedesSocial);
    }

    @Transactional(readOnly = true)
    @Override
    public ConsumoRedesSocial getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
   
}
