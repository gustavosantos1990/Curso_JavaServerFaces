
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Produto;
import java.io.Serializable;

public class ProdutoDAO<T> extends DAOGenerico<Produto> implements Serializable {

    public ProdutoDAO() {
        super();
        classePersistente = Produto.class;
        ordem = "nome";
    }
    
}
