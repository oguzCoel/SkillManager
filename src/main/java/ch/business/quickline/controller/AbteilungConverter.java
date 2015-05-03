package ch.business.quickline.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.Abteilung;
import ch.business.quickline.service.AbteilungService;

@ManagedBean
@FacesConverter("abteilungConverter")
@Component
public class AbteilungConverter implements Converter {
	
	@Autowired
	private AbteilungService abteilungService;

	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		
		 if (value == null || value.isEmpty()) {
	            return null;
	        }

	        try {
	        	System.out.println();
	            return abteilungService.findByAbteilungId(Integer.valueOf(value));
	        } catch (NumberFormatException e) {
	            throw new ConverterException(new FacesMessage(String.format("%s is not a valid Abteilung ID", value)), e);
	        }
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		 if (value == null) {
	            return "";
	        }

	        if (value instanceof Abteilung) {
	            return String.valueOf(((Abteilung) value).getAbteilungId());
	        } else {
	            throw new ConverterException(new FacesMessage(String.format("%s is not a valid Abteilung", value)));
	        }
	    
	}

}
