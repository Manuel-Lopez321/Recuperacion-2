package mx.utng.lmlc.model.dao;

import java.util.List;

import mx.utng.lmlc.model.entity.GastosHobbie;

public interface IGastosHobbieDao {
    List<GastosHobbie> list();
    void save(GastosHobbie gastosHobbie);
    GastosHobbie getById(Long id);
    void delete(Long id);
}
