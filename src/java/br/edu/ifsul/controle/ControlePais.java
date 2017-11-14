package br.edu.ifsul.controle;

import br.edu.ifsul.dao.PaisDAO;
import br.edu.ifsul.modelo.Pais;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "controlePais")
@SessionScoped
public class ControlePais implements Serializable {
    
    private PaisDAO dao;
    private Pais objeto;
    
    public ControlePais() {
        dao = new PaisDAO();
    }
    
    public String listar() {
        return "/privado/pais/listar?faces-redirect=true";
    }
    
    public String novo() {
        objeto = new Pais();
        return "formulario?faces-redirect=true";
    }
    
    public String salvar() {
        if (dao.salvar(objeto)) {
            Util.mensagemInformacao(dao.getMensagem());
            return "listar?faces-redirect=true";
        } else {
            Util.mensagemErro(dao.getMensagem());
            return "formulario?faces-redirect=true";
        }
    }
    
    public String cancelar() {
        return "listar?faces-redirect=true";
    }
    
    public String editar(Integer id) {
        objeto = dao.localizar(id);
        return "formulario?faces-redirect=true";
    }
    
    public void remover(Integer id) {
        objeto = dao.localizar(id);
        if (dao.remover(objeto)) {
            Util.mensagemInformacao(dao.getMensagem());
        } else {
            Util.mensagemErro(dao.getMensagem());
        }
    }
    
    public PaisDAO getDao() {
        return dao;
    }
    
    public void setDao(PaisDAO dao) {
        this.dao = dao;
    }
    
    public Pais getObjeto() {
        return objeto;
    }
    
    public void setObjeto(Pais objeto) {
        this.objeto = objeto;
    }
    
}
