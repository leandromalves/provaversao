package br.com.ecad.versao.mb;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.faces.convert.FacesConverter;

@FacesConverter(value="localDateConverter")
public class LocalDateConverter implements TemporalConverter<LocalDate> {
	
	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Override
	public String format(final LocalDate localDate) {
		return localDate.format(DATE_FORMAT);
	}

	@Override
	public LocalDate parse(final String value) {
		return LocalDate.parse(value, DATE_FORMAT);
	}

}
