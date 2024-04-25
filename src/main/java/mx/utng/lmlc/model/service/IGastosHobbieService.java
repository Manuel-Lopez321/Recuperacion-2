package mx.utng.lmlc.model.service;

import mx.utng.lmlc.model.entity.GastosHobbie;
import java.util.List;

public interface IGastosHobbieService {
    List<GastosHobbie> list();
    void save(GastosHobbie gastosHobbie);
    GastosHobbie getById(Long id);
    void delete(Long id);
}
