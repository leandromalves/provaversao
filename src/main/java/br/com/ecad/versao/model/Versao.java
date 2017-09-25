package br.com.ecad.versao.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Versao {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "COD_VERSAO")
	private Integer id;
	
	@Column(name = "NRO_VERSAO")
	private String numeroVersao;
	
	@Column(name = "DAT_VERSAO")
	private LocalDate data;
	
	@ManyToMany(fetch=FetchType.EAGER ,cascade = CascadeType.ALL)
	@JoinTable(name="VERSAO_ITEM", 
		joinColumns={@JoinColumn (name="COD_VERSAO")}, 
	 	inverseJoinColumns={@JoinColumn(name="COD_ITEM")})
	private List<Item> items;

	
	public Versao() {
		this.items = new ArrayList<>();
	}
	
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

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
}
