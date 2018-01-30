package converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.glassfish.jersey.message.internal.StringBuilderUtils;

import classes.Genero;
import classes.Livro;

@FacesConverter("livroConverter")
public class LivroConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		if(value == null) {
			return null;
		}
		
		String[] livro = value.split("=");
		try {
			return new Livro(Integer.parseInt(livro[0]),livro[1],livro[2], new Genero(Integer.parseInt(livro[3]), livro[4]));
		} catch (NumberFormatException ex) {
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao converter Livro");
			
			throw new ConverterException(fm);
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value == null) {
			return null;
		}

		Livro livro = (Livro) value;
		return livro.getCdLivro() + "=" + livro.getNmAutor() + "=" + livro.getNmLivro() + "="
				+ livro.getGenero().getCdGenero() + "=" + livro.getGenero().getNmGenero();
	}

}
