package br.com.ecad.versao.model;

import java.time.LocalDate;

public class FiltroConsulta {

	private Integer id;
	private String numeroVersao;
	private LocalDate data;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumeroVersao() {
		return numeroVersao;
	}
	public void setNumeroVersao(String numeroVersao) {
		this.numeroVersao = numeroVersao;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	
}
