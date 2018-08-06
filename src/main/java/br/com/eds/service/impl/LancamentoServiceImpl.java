package br.com.eds.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.eds.dao.GenericDao;
import br.com.eds.dao.LancamentoDao;
import br.com.eds.model.Lancamento;
import br.com.eds.service.LancamentoService;

@Stateless
public class LancamentoServiceImpl extends GenericServiceImpl<Lancamento> implements LancamentoService {
	
	@EJB
	private LancamentoDao dao;

	@Override
	GenericDao<Lancamento> getDao() {
		return dao;
	}

}
