package codigos;


/**
 * Classe ItemAgenda abstrata para obrigar as subclasses a implementarem os m�todos dessa classe
 * <p>
 * 
 * @author Diogenes F.
 *
 */
public abstract class ItemAgenda {
	/** Registro do item e descri��o do item */
	private String registro_item, descricao;
	/** Periodo de tempo do item*/
	private Periodo periodo;
	
	/**
	 * Acessa o registro do item
	 * 
	 * @return Registro do item
	 */
	public String getRegistroItem() {
		return this.registro_item;
	}
	/**
	 * Acessa a descri��o do item
	 * 
	 * @return Descri��o do item
	 */
	public String getDescricao() {
		return this.descricao;
	}
	/**
	 * Acessa o periodo do item
	 * 
	 * @return Periodo do item
	 */
	public Periodo getPeriodo() {
		return this.periodo;
	}
	/**
	 * Altera o registro do item, recebendo uma nova string que representa essa informa��o
	 * 
	 * @param _registro_item String que representa o registro do item
	 */
	public void setRegistroItem(String _registro_item) {
		this.registro_item = _registro_item;
	}
	/**
	 * Altera a descri��o do item, recebendo uma nova string que representa essa informa��o
	 * 
	 * @param _descricao String que representa a descri��o do item
	 */
	public void setDescricao(String _descricao) {
		this.descricao = _descricao;
	}
	/**
	 * Altera o periodo do item, recebendo um novo periodo que representa essa informa��o
	 * 
	 * @param _periodo Periodo que representa o periodo do item
	 */
	public void setPeriodo(Periodo _periodo) {
		this.periodo = _periodo;
	}
	/**
	 * Altera o registro do item, recebendo uma data de inicio, data final, horario de inicio e horario final
	 * 
	 * @param _data_inicio Data de inicio
	 * @param _data_fim Data de t�rmino
	 * @param _horario_inicio Horario de inicio
	 * @param _horario_fim Horario de t�rmino
	 * 
	 */
	public void setPeriodo(Data _data_inicio, Data _data_fim, Horario _horario_inicio, Horario _horario_fim) {
		this.periodo = new Periodo(_data_inicio, _data_fim, _horario_inicio, _horario_fim);
	}
	/**
	 * M�todo para retornar as informa��es em formato de string
	 * 
	 * @return String que retorna todos os dados
	 */
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append("\nRegistro do Item: " + this.getRegistroItem());
		info.append("\nDescricao: " + this.getDescricao());
		info.append("\nPeriodo: " + this.getPeriodo());
		return info.toString();
	}
	
}
