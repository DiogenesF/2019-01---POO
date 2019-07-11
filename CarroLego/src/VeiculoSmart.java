import java.util.LinkedList;
import java.util.List;
import lejos.utility.Delay;


/**
 * Classe Veiculo Smart em que � utilizada para fazer o controle do carrinho LEGO
 * utilizado na pratica de POO. Classe essa em que faz o carrinho seguir uma linha preta,
 * at� que encontre uma bolinha a sua frente. Caso a bolinha for encontrada, o carrinho 
 * retorna ao seu ponto de origem mesmo sendo iniciado fora da linha.
 * <p>
 * 
 * Essa classe extende a classe veiculo, onde ela atribui todos os m�todos dessa classe.
 * <p>
 * 
 * H� tambem a utiliza��o de uma linkedList para guardar os comandos feitos ao decorrer do caminho,
 * onde ser� utilizado para fazer o retorno do carrinho ao ponto inicial.
 * 
 * @author Arthur B. 
 * @author Ayrton S. C.
 * @author Diogenes F.
 * @author Luan S. F
 * @author Yuri C. P.
 * @version 1.0 (julho - 2019)
 */
public class VeiculoSmart extends Veiculo {
	/** Variavel boleana onde ira verificar a presen�a da bolinha. */
	private boolean ver_bolinha = false;
	/** Variavel que recebe os parametros de EV3Cerebro*/
	EV3Cerebro ev3;
	private List<Acao> movimentos = new LinkedList<Acao>();

	/**
	 * Construtor Veiculo Smart onde recebe como parametro quatro boleanos, um toque, colorDir,
	 * colorEsq e o infravermelho, fazendo a utiliza��o da op��o super para fazer a chamada  
	 * dos m�todos da classe Veiculo.
	 * 
	 *  @param toque Recebe um boleano em que diz se o toque esta ou nao sendo utilizado 
	 *  @param colorDir Recebe um boleano em que diz se o sensor da direita esta ou nao funcionando
	 *  @param colorEsq Recebe um boleano em que fiz se o sensor da esquerda esta ou nao funcionando
	 *  @param infravermelho Recebe um boleano em que diz se o sensor infravermelho esta ou nao ativo
	 */
	public VeiculoSmart(boolean toque, boolean colorDir, boolean colorEsq, boolean infravermelho) {
		super(toque, colorDir, colorEsq, infravermelho);
	}

	/**
	 * M�todo proprio eixo, consiste em fazer a rota��o do carrinho ate em que os dois sensores fiquem 
	 * na linha preta fazendo a rota��o das esteiras n�o simultaneamente.
	 * 
	 * @param seg Valor referente ao segundos 
	 */
	public void giraProprioEixo(int seg) {
		this.desligaSincronizacaoEsteiras();
		this.dir.ligaFrente(1);
		this.esq.ligaTras(1);
	}

	/**
	 * M�todo gira proprio eixo para volta ao inicio, consiste em retornar o carrinho para 
	 * o ponto de origem.
	 * 
	 * @param seg Valor referente ao segundos 
	 */
	public void giraProprioEixoVoltarInicio(int seg) {
		this.desligaSincronizacaoEsteiras();
		this.dir.ligaTras(1);
		this.esq.ligaFrente(1);
	}

	/**
	 * M�todo segue linha, consiste em fazer o carrinho analisas se ele esta ou n�o
	 * captando a linha preta entre o seus dois sensores direito e esquerdo, fazendo casos 
	 * para cada quando um ou outro nao encontrar a linha ou quando encontrarem a linha.
	 */
	public void segueLinha() {

		this.setVelocidadeEsteirasGrau(240);

		int k=0;

		//fora da linha, procura  a faixa
		while(!this.isPreto("esquerdo") || !this.isPreto("direito")) {
			this.setEsteirasForward(1);
			movimentos.add(Acao.FRENTE);
			k = 1;//pra marcar que ja entrou na faixa
		}
		//na faixa, procura o final da largura da faixa
		while(this.isPreto("esquerdo") && this.isPreto("direito") ) {
			if (k == 0) {
				break;
			}
			this.setEsteirasForward(1);
			movimentos.add(Acao.FRENTE);
		}
		//acerta e coloca na faixa em uma das dire��es
		while (!this.isPreto("esquerdo") || !this.isPreto("direito") && k == 1) {

			//Gira em uma dire��o, melhor, pra colocar na lista
			//this.setVelocidadeEsteirasGrau(180);
			this.giraProprioEixo(1);
			//ev3.beep1();
			movimentos.add(Acao.GIRO180);
			this.ligaSincronizacaoEsteiras();
			//this.setVelocidadeEsteirasGrau(240);
			//Movimentos.add(Acao.ESQUERDA/DIREITA);

		}
		//percorre a faixa seguindo a linha
		while ((this.isPreto("esquerdo") && this.isPreto("direito"))) {
			this.setEsteirasForward(2);
			movimentos.add(Acao.FRENTE);
			//se o sensor esquerdo for igual a branco
			while (!this.isPreto("esquerdo")) {
				this.recuaEsquerda(1);
				movimentos.add(Acao.DIREITA);
			}
			//se o sensor direito for igual a branco
			while (!this.isPreto("direito")) {
				this.recuaDireita(1);
				movimentos.add(Acao.ESQUERDA);
			}

			if (this.getDistancia() <= 3) {
				this.ver_bolinha = true;
				break;
			}
		}
	}

	/**
	 * M�todo segue linha ate bola consiste em fazer o carrinho percorrer a linha
	 * at� que o sensor de infravermelho encontre uma diferen�a de altura onde acusara
	 * a bolinha. Caso ele n�o encontre a bolinha, ele dara um giro de 180 graus e voltara 
	 * a percorer a linha mas no sentido oposto.
	 */
	public void segueLinhaAteBola() {
		this.segueLinha();
		if (this.ver_bolinha) {
			this.pegaBolaNaLinha();
			this.stop();
		}
		else {
			//ev3.beep1();
			while (!this.isPreto("esquerdo") || !this.isPreto("direito")) {
				//this.setVelocidadeEsteirasGrau(180);
				this.curvaDireita(1);
				
				//this.giraProprioEixo(1);
				//this.ligaSincronizacaoEsteiras();
				//this.setVelocidadeEsteirasGrau(240);
				movimentos.add(Acao.GIRO180);
			}
			//ev3.beep1();
			this.segueLinha();
			if (this.ver_bolinha) {
				this.pegaBolaNaLinha();
				this.stop();
			}
		}
	}

	/**
	 * M�todo volta ao ponto de origem, consiste em fazer o carrinho retornar ao ponto de
	 * partida em que foi inciado.
	 */
	public void voltaAoPontoDeOrigem() {
		this.setVelocidadeEsteirasGrau(240);
		for (int i = this.movimentos.size() - 1; i >= 0;i--) {
			if (this.movimentos.get(i).equals(Acao.FRENTE)) {
				this.setEsteirasBackward(2);
			}
			else if (this.movimentos.get(i).equals(Acao.DIREITA)) {
				this.recuaEsquerda(1);
			}
			else if (this.movimentos.get(i).equals(Acao.ESQUERDA)) {
				this.recuaDireita(1);
			}
			else if (this.movimentos.get(i).equals(Acao.GIRO180)) {
				//this.setVelocidadeEsteirasGrau(180);
				this.giraProprioEixoVoltarInicio(1);
				//this.setVelocidadeEsteirasGrau(240);
			}
		}
	}

	/**
	 * M�todo segura bola, faz com que a garra seja aberta e fechada para a 
	 * captura da bolinha.
	 */
	public void seguraBola() {
		this.abreGarra();
		this.fechaGarra();
	}

	/**
	 * M�todo larga a bola consiste em que a garrinha seja aberta para soltar 
	 * a bolinha.
	 */
	public void largaBola() {
		this.abreGarra();
	}

	/**
	 * M�todo pega a bola na linha, coonsiste em reconhecer que o carrinho esta seguindo a linha
	 * normalmente e quando o sensor encontrar a bolinha, ele avan�a alguns centimetros e faz a captura 
	 * da bolinha.
	 */
	public void pegaBolaNaLinha() {
		this.abreGarra();
		this.setEsteirasForward(1);
		movimentos.add(Acao.FRENTE);
		this.fechaGarra();
	}
}
