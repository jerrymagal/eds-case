package br.com.eds.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.eds.enuns.TipoLancamento;

@Converter
public class TipoLancamentoConverter implements AttributeConverter<TipoLancamento, Integer>{

	@Override
	public Integer convertToDatabaseColumn(TipoLancamento tipoLancamento) {
		return tipoLancamento.getCodigo();
	}

	@Override
	public TipoLancamento convertToEntityAttribute(Integer codigo) {
		return TipoLancamento.getTipoLancamento(codigo);
	}
}
