package br.com.ecad.versao.mb;


import java.time.format.DateTimeParseException;
import java.time.temporal.Temporal;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.primefaces.util.MessageFactory;


@FunctionalInterface
interface TemporalConverter<T extends Temporal> extends Converter {

	@Override
	default Object getAsObject(final FacesContext context, final UIComponent component, final String strTemporal) {
        final T temporal;

        try {
        	if(strTemporal != null && !strTemporal.isEmpty()) {
        		temporal = parse(strTemporal);
        	} else {
        		temporal = null;
        		
        	}

        } catch (DateTimeParseException e){
    		final String[] params = {strTemporal};
    		
    		final FacesMessage message = 
    			MessageFactory
    				.getMessage(
    					"erro.prova.filtro.data.invalida", 
    					FacesMessage.SEVERITY_WARN, 
    					params);
    		
    		throw new ConverterException(message);
        }

        return temporal;
	}


	@SuppressWarnings("unchecked")
	@Override
	default String getAsString(final FacesContext context, final UIComponent component, final Object value) {
		return value == null ? null : format((T) value);
	}
	
	default String format(final T temporal){
		return temporal.toString();
	}
	
	T parse(String strTemporal);

}
