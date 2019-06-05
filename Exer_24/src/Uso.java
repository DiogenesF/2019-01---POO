import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

/**
 * Exemplo de:
 * 1. Uso da calsse ConjuntoSorteio. Que vai gerar, a partir de um sorteio, uma certa quantidade de valores (definido pelo usuario)
 * e vai gerar tambem uma certa quantidade de sorteios (tambem definido pelo usuario), com uma respectiva data para cada sorteio.
 * 2. Serializa��o de objetos
 *
 *<p>
 *Vale ressaltar que foram utilizados as colecoes:
 *	LinkedList para agrupar todo o conjunto de sorteio
 *	e uma TreeSet para organizar os numeros sorteados.
 *<p> 
 *As classes foram encapsuladas afim de melhorar a legilibidade e manutencao do codigo
 *<p>
 *O resultado eh depois gravado em um arquivo de texto no disco atraves da serializacao 
 *
 * @author Diogenes Fiorezi
 *
 */

public class Uso {

	public static void main(String[] args) {
		
		try {
			ConjuntoSorteio teste_2 = new ConjuntoSorteio();
			teste_2.insere(30,12,1998,10,10,50,5);
			System.out.println(teste_2);
			
			Arquivo.grava("arquivo.my", teste_2);
			ConjuntoSorteio teste_3;
			teste_3 = (ConjuntoSorteio) Arquivo.le("arquivo.my");
			System.out.println("Dados lidos do arquivo:\n"+ teste_3.toString());
			
			
			BufferedWriter arqSaida;
			arqSaida = new BufferedWriter(new FileWriter("arquivo_de_saida.txt"));
			// O m�todo write grava a string no arquivo texto.
			// Deve ser chamado para cada objeto, com o seu respectivo toString().
			// Normalmente aparece dentro de um la�o que percorre toda cole��o
			// que cont�m os objetos que ser�o gravados.
			// O "\r\n" � necess�rio para colocar os objetos um em cada linha
			// (o WordPad, Word, InternetExplorer tamb�m aceitam "\n" ou "\r", mas
			// O Bloco de Notas, por exemplo, s� aceita "\r\n")
			arqSaida.write(teste_2.toString()+"\r\n");
			arqSaida.close();
			
			
			
		} catch(FileNotFoundException e) {
			System.out.println("Arquivo n�o encontrado");
		}
		catch(IOException e) {
			System.out.println("Problemas na leitura ou grava��o do arquivo");
		}
		catch(ClassNotFoundException e) {
			System.out.println("Classe inexistente usada na convers�o");
		}
		catch (Exception e) {
			System.out.println("Data invalida!");
		}
	
		
		
		
	}
}
