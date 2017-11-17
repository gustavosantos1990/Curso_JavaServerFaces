
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.PessoaFisica;
import java.io.Serializable;

public class PessoaFisicaDAO<T> extends DAOGenerico<PessoaFisica> implements Serializable {

    public PessoaFisicaDAO() {
        super();
        classePersistente = PessoaFisica.class;
        ordem = "nome";
    }
    
    
}
