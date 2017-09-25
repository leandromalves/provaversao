package br.com.ecad.versao.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.ecad.versao.dao.VersaoDAO;
import br.com.ecad.versao.model.FiltroConsulta;
import br.com.ecad.versao.model.Item;
import br.com.ecad.versao.model.Versao;

@Named
@ViewScoped
public class VersaoMB extends BaseMB {

	private static final long serialVersionUID = 4117250188048855009L;

	@Inject
	private VersaoDAO dao;
	
	private Versao versao = new Versao();
	
	private FiltroConsulta filtro = new FiltroConsulta();
	
	private List<Item> itemsParaExcluir;
	
	private List<Versao> resultado;
	
	private String itemTitulo;
	private String descricao;
	
	public void incluir() {
		if(versao == null) {
			exibirMensagemErro("Erro ao incluir Versão");
		}
		
		dao.salvar(versao);
		limparIncluir();
		exibirMensagemSucesso("Versao Adicionada com Sucesso!");
	}
	
	private void limparIncluir() {
		versao = new Versao();
		limparAddItem();
	}
	
	private void limparAddItem() {
		itemTitulo = "";
		descricao = "";
	}
	
	public void adicionarItem() {
		if(versao != null) {
			Item item = new Item();
			item.setTituloDescricao(itemTitulo);
			item.setDescricao(descricao);
			versao.getItems().add(item);
			limparAddItem();
		}
	}
	
	public void consultar() {
		this.resultado = dao.consultar(filtro);
		this.itemsParaExcluir = new ArrayList<>();
	}
	
	public void limparFiltro() {
		this.filtro = new FiltroConsulta();
	}
	
	public void marcarItemExcluido(Item item) {
		if(item != null && this.itemsParaExcluir != null) {
			this.itemsParaExcluir.add(item);
			versao.getItems().remove(item);
		}
	}
	
	public void atualizarVersao() {
		dao.atualizar(this.versao, this.itemsParaExcluir);
		limparIncluir();
		this.resultado = null;
		exibirMensagemSucesso("Versao Atualizada com Sucesso!");
	}
	
	
	public Versao getVersao() {
		return versao;
	}
	public void setVersao(Versao versao) {
		this.versao = versao;
	}

	public String getItemTitulo() {
		return itemTitulo;
	}

	public void setItemTitulo(String itemTitulo) {
		this.itemTitulo = itemTitulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public FiltroConsulta getFiltro() {
		return filtro;
	}
	public void setFiltro(FiltroConsulta filtro) {
		this.filtro = filtro;
	}
	public List<Versao> getResultado() {
		return resultado;
	}
	public void setResultado(List<Versao> resultado) {
		this.resultado = resultado;
	}
}
