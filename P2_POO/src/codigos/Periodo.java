package codigos;

/**
 * Classe Periodo representa o periodo de dura��o de um item da agenda, atrav�s de uma data de inicio e de final e um
 * horario de inicio e de final
 * <p>
 * 
 * @author Diogenes F.
 *
 */
public class Periodo {
	/** Datas inicial e final do periodo*/
	private Data data_inicio, data_fim;
	/** Horarios inicial e final do periodo*/
	private Horario horario_inicio, horario_fim;
	
	/**
	 * Construtor Periodo � inicializado com uma data de inicio, uma data final,
	 * uma hora inicial e uma hora final
	 * 
	 * @param _data_inicio Data inicial do periodo
	 * @param _data_fim Data final do periodo
	 * @param _horario_inicio Horario inicial do periodo
	 * @param _horario_fim Horario final do periodo
	 */
	public Periodo(Data _data_inicio, Data _data_fim, Horario _horario_inicio, Horario _horario_fim) {
		this.setDataInicio(_data_inicio);
		this.setDataFim(_data_fim);
		this.setHorarioInicio(_horario_inicio);
		this.setHorarioFim(_horario_fim);
	}
	/**
	 * Construtor sobrecarregado inicializado com um dia inicio, m�s inicio, 
	 * ano inicio e dia final, m�s final, ano final. Hora inicial, minuto inicial,
	 * segundo inicial, hora final, minuto finail e segundo final
	 * 
	 * @param d_inicio Dia inicial dada pelo Usuario
	 * @param m_inicio M�s inicial dada pelo Usuario
	 * @param a_inicio Ano inicial dada pelo Usuario
	 * @param d_fim Dia final dada pelo Usuario
	 * @param m_fim M�s final dada pelo Usuario
	 * @param a_fim Ano final dada pelo Usuario
	 * @param hor_inicio Hora inicial dada pelo Usuario
	 * @param min_inicio Minuto inicial dada pelo Usuario
	 * @param seg_inicio Segundos inicial dada pelo Usuario
	 * @param hor_fim Hora final dada pelo Usuario
	 * @param min_fim Minutos finais dada pelo Usuario
	 * @param seg_fim Segundos finais dada pelo Usuario
	 * @throws Exception Tratamento de erro que para verificar se as datas e os horarios s�o validos
	 */
	public Periodo(int d_inicio, int m_inicio, int a_inicio, int d_fim, int m_fim, int a_fim, int hor_inicio, int min_inicio, 
			int seg_inicio, int hor_fim, int min_fim, int seg_fim) throws Exception {
		this.setDataInicio(new Data(d_inicio, m_inicio, a_inicio));
		this.setDataFim(new Data(d_fim, m_fim, a_fim));
		this.setHorarioInicio(new Horario(hor_inicio, min_inicio, seg_inicio));
		this.setHorarioFim(new Horario(hor_fim, min_fim, seg_fim));
	}
	/**
	 * Acessa a data de inicio 
	 * 
	 * @return Data de inicio
	 */
	public Data getDataInicio() {
		return this.data_inicio;
	}
	/**
	 * Acessa a data de t�rmino 
	 * 
	 * @return Data de t�rmino
	 */
	public Data getDataFim() {
		return this.data_fim;
	}
	/**
	 * Acessa o horario de inicio 
	 * 
	 * @return Horario de inicio
	 */
	public Horario getHorarioInicio() {
		return this.horario_inicio;
	}
	/**
	 * Acessa o horario de t�rmino 
	 * 
	 * @return Horario de t�rmino
	 */
	public Horario getHorarioFim() {
		return this.horario_fim;
	}
	/**
	 * Altera��o da Data de inicio
	 * 
	 * @param _data_inicio Data de inicio do periodo
	 */
	public void setDataInicio(Data _data_inicio) {
		this.data_inicio = _data_inicio;
	}
	/**
	 * Altera��o da Data de t�rmino
	 * 
	 * @param _data_fim Data de t�rmino do periodo
	 */
	public void setDataFim(Data _data_fim) {
		this.data_fim = _data_fim;
	}
	/**
	 * Altera��o do Horario de inicio
	 * 
	 * @param _horario_inicio Horario de inicio do periodo
	 */
	public void setHorarioInicio(Horario _horario_inicio) {
		this.horario_inicio = _horario_inicio;
	}
	/**
	 * Altera��o do Horario de inicio
	 * 
	 * @param _horario_fim Horario de t�rmino do periodo
	 */
	public void setHorarioFim(Horario _horario_fim) {
		this.horario_fim = _horario_fim;
	}
	/**
	 * M�todo para retornar as informa��es da classe em formato de string
	 * 
	 * @return String com todas as informa��es
	 */
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append("Data  de inicio: " + this.data_inicio);
		info.append("\nData do fim: " + this.data_fim);
		info.append("\nHorario de inicio: " + this.horario_inicio);
		info.append("\nHorario do fim: " + this.horario_fim);
		return info.toString();
	}
	
}
