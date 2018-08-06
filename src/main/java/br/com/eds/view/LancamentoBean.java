package br.com.eds.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import br.com.eds.enuns.TipoLancamento;
import br.com.eds.model.Lancamento;
import br.com.eds.service.LancamentoService;
import br.com.eds.util.FacesUtil;

@ManagedBean
@ViewScoped
public class LancamentoBean implements Serializable {

	private static final long serialVersionUID = -1202129759986313366L;
	
	@EJB
	private LancamentoService service;
	
	private Lancamento lancamento;

	private List<Lancamento> lancamentos;
	
	public LancamentoBean() {
		lancamento = new Lancamento();
	}
	
	@PostConstruct
	public void init() {
		carregarLista();
	}
	
	private void carregarLista() {
		lancamentos = service.findAll();
	}
	
	public void inserir() {
		service.persist(lancamento);
		FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Lançamento cadastrado com sucesso.");
		lancamento = new Lancamento();
		carregarLista();
	}
	
	public void atualizar(Lancamento lancamento) {
		service.update(lancamento);
	}
	
	public void remover() {
		
	}
	
	public TipoLancamento[] getTiposLancamentos() {
		return TipoLancamento.values();
	}
	
	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}
	
}
