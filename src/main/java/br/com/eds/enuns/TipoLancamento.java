package br.com.eds.enuns;

public enum TipoLancamento {
	
	RECEITA(1), DESPESA(2);
	
	private Integer codigo;
	
	private TipoLancamento(Integer codigo) {
		this.codigo = codigo;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public static TipoLancamento getTipoLancamento(Integer codigo) {
		switch (codigo) {
			case 1:
				return RECEITA;
			case 2:
				return DESPESA;
			default:
				throw new IllegalArgumentException("Código não localizado");
		}
	}
}
