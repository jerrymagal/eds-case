package br.com.eds.dao.impl;

import javax.ejb.Stateless;

import br.com.eds.dao.LancamentoDao;
import br.com.eds.model.Lancamento;

@Stateless
public class LancamentoDaoImpl extends GenericDaoImpl<Lancamento> implements LancamentoDao {

	public LancamentoDaoImpl() {
		super(Lancamento.class);
	}

}
