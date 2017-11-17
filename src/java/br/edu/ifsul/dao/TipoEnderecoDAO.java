
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.TipoEndereco;
import java.io.Serializable;

public class TipoEnderecoDAO<T> extends DAOGenerico<TipoEndereco> implements Serializable {

    public TipoEnderecoDAO() {
        super();
        classePersistente = TipoEndereco.class;
        ordem = "descricao";
    }
    
}
