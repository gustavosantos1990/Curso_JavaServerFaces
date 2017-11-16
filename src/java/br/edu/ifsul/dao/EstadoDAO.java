
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Pais;
import java.io.Serializable;

public class EstadoDAO<T> extends DAOGenerico<Estado> implements Serializable {

    public EstadoDAO() {
        super();
        classePersistente = Estado.class;
        ordem = "nome";
    }
    
    
}
