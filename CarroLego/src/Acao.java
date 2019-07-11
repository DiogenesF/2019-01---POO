/**
 * Classe enumera��o onde faz a caracteriza��o das A��es feitas pelo carrinho
 * em numera��es para a facilita��o da implementa��o. 
 * <p>
 * 
 * @author Arthur B. 
 * @author Ayrton S. C.
 * @author Diogenes F.
 * @author Luan S. F
 * @author Yuri C. P.
 * @version 1.0 (julho - 2019)
 */
public enum Acao {
	/** Caracteristicas das a��es sobre o carrinho.*/
	FRENTE(1), TRAS(2), ESQUERDA(3), DIREITA(4), GIRO180(5);

	/** Variavel para receber a a��o.*/
	private int codigo;

	/**
	 * M�todo em que recebe um valor inteiro do usuario e � atribuido esse valor 
	 * para a op��o codigo. 
	 * 
	 * @param c Valor da a��o a ser efetuada
	 */
	private Acao (int c) {
		this.codigo = c;
	}

	/**
	 * Captura do codigo dada pelo usuario
	 * 
	 * @return Retorna o codigo passado
	 */
	public int getCodigo() {
		return this.codigo;
	}

}
