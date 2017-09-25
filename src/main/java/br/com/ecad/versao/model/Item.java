package br.com.ecad.versao.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="COD_ITEM")
	private Integer id;
	
	@Column(name="DSC_TITULO")
	private String tituloDescricao;
	
	@Column(name="TXT_DESCRICAO")
	private String descricao;
	
	@ManyToMany(mappedBy="items")
	private List<Versao> versoes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTituloDescricao() {
		return tituloDescricao;
	}

	public void setTituloDescricao(String tituloDescricao) {
		this.tituloDescricao = tituloDescricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<Versao> getVersoes() {
		return versoes;
	}
	
	public void setVersoes(List<Versao> versoes) {
		this.versoes = versoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
