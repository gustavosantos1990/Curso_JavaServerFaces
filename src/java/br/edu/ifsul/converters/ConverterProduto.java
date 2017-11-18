
package br.edu.ifsul.converters;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Produto;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "converterProduto")
public class ConverterProduto implements Converter, Serializable {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String string) {
        if(string == null || string.equals("Selecione um registro")){
            return null;
        }
        return EntityManagerUtil.getEntityManager().find(Produto.class, Integer.parseInt(string));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object o) {
        if(o == null){
            return null;
        }
        Produto obj = (Produto) o;
        return obj.getId().toString();
    }
    
}
