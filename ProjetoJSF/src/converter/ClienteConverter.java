package converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import classes.Cliente;

@FacesConverter("clienteConverter")
public class ClienteConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null || value.equals("")) {
			return null;
		}
		
		String[] cliente = value.split("=");
		try {
			return new Cliente(Integer.parseInt(cliente[0]),cliente[1],cliente[2]);
		} catch (NumberFormatException ex) {
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao converter Cliente");
			
			throw new ConverterException(fm);
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null || value.equals("")) {
			return null;
		}

		try {
		Cliente cliente = (Cliente) value;
		return cliente.getCdCliente() + "=" + cliente.getNmCliente() + "=" + cliente.getNrTelefoneRes();
		} catch (Exception e) {
			return null;
		}
	}

}
