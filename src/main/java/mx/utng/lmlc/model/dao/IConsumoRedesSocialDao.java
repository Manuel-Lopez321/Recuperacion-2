package mx.utng.lmlc.model.dao;

import java.util.List;

import mx.utng.lmlc.model.entity.ConsumoRedesSocial;

public interface IConsumoRedesSocialDao {
    List<ConsumoRedesSocial> list();
    void save(ConsumoRedesSocial consumoRedesSocial);
    ConsumoRedesSocial getById(Long id);
    void delete(Long id);
}
