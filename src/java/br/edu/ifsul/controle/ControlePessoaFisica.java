package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CidadeDAO;
import br.edu.ifsul.dao.PessoaFisicaDAO;
import br.edu.ifsul.dao.TipoEnderecoDAO;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Endereco;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.TipoEndereco;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "controlePessoaFisica")
@ViewScoped
public class ControlePessoaFisica implements Serializable {

    private PessoaFisicaDAO<PessoaFisica> dao;
    private PessoaFisica objeto;
    private CidadeDAO<Cidade> daoCidade;
    private TipoEnderecoDAO<TipoEndereco> daoTipoEndereco;
    private Endereco endereco;
    private Boolean novoEndereco;

    public ControlePessoaFisica() {
        dao = new PessoaFisicaDAO<>();
        daoCidade = new CidadeDAO<>();
        daoTipoEndereco = new TipoEnderecoDAO<>();
    }

    public String listar() {
        return "/privado/pessoafisica/listar?faces-redirect=true";
    }

    public void novoEndereco() {
        endereco = new Endereco();
        novoEndereco = true;
    }

    public void alterarEndereco(int index) {
        endereco = objeto.getEnderecos().get(index);
        novoEndereco = false;
    }
    
    public void salvarEndereco(){
        if(novoEndereco){
            objeto.adicionarEndereco(endereco);
        }
        Util.mensagemInformacao("Endereço persistido com sucesso!");
    }
    
    public void removerEndereco(int index){
        objeto.removeEndereco(index);
        Util.mensagemInformacao("Endereço removido com sucesso!");
    }

    public void novo() {
        objeto = new PessoaFisica();
    }

    public void salvar() {
        boolean persistiu = false;
        if (objeto.getId() == null) {
            persistiu = dao.persist(objeto);
        } else {
            persistiu = dao.merge(objeto);
        }
        if (persistiu) {
            Util.mensagemInformacao(dao.getMensagem());

        } else {
            Util.mensagemErro(dao.getMensagem());

        }
    }

    public void editar(Integer id) {
        objeto = dao.localizar(id);
    }

    public void remover(Integer id) {
        objeto = dao.localizar(id);
        if (dao.remove(objeto)) {
            Util.mensagemInformacao(dao.getMensagem());
        } else {
            Util.mensagemErro(dao.getMensagem());
        }
    }

    public PessoaFisicaDAO getDao() {
        return dao;
    }

    public void setDao(PessoaFisicaDAO dao) {
        this.dao = dao;
    }

    public PessoaFisica getObjeto() {
        return objeto;
    }

    public void setObjeto(PessoaFisica objeto) {
        this.objeto = objeto;
    }

    public CidadeDAO<Cidade> getDaoCidade() {
        return daoCidade;
    }

    public void setDaoCidade(CidadeDAO<Cidade> daoCidade) {
        this.daoCidade = daoCidade;
    }

    public TipoEnderecoDAO<TipoEndereco> getDaoTipoEndereco() {
        return daoTipoEndereco;
    }

    public void setDaoTipoEndereco(TipoEnderecoDAO<TipoEndereco> daoTipoEndereco) {
        this.daoTipoEndereco = daoTipoEndereco;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Boolean getNovoEndereco() {
        return novoEndereco;
    }

    public void setNovoEndereco(Boolean novoEndereco) {
        this.novoEndereco = novoEndereco;
    }

}
