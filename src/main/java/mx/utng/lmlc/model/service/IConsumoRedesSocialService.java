package mx.utng.lmlc.model.service;

import mx.utng.lmlc.model.entity.ConsumoRedesSocial;
import java.util.List;

public interface IConsumoRedesSocialService {
    List<ConsumoRedesSocial> list();
    void save(ConsumoRedesSocial consumoRedesSocial);
    ConsumoRedesSocial getById(Long id);
    void delete(Long id);
}
