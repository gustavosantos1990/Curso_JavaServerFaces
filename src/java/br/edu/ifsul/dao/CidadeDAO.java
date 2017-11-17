
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Cidade;
import java.io.Serializable;

public class CidadeDAO<T> extends DAOGenerico<Cidade> implements Serializable {

    public CidadeDAO() {
        super();
        classePersistente = Cidade.class;
        ordem = "nome";
    }
    
    
}
