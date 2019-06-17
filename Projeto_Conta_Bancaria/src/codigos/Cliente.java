package codigos;
import java.util.LinkedList;
import java.util.List;

public class Cliente {
	private String nome;
	private String CPF;			//O cliente possui essas informacoes, e a senha que sera utilizada quando implementarmos o banco
	private double saldo;		//de dados. As operacoes realizadas por este cliente sao armazenadas em uma linkedlist.
	private String senha;	
	private Data data_nasc;
	private List<Operacoes> operacoes = new LinkedList<Operacoes>();
	
	public Cliente(String _nome, String _CPF, double _saldo, String _senha, Data _data_nasc) {
		this.setNome(_nome);
		this.setCPF(_CPF);
		this.setSaldo(_saldo);
		this.setSenha(_senha);
		this.setDataNasc(_data_nasc);
	}
	
	public String getNome() {
		return this.nome;
	}
	public String getCPF() {
		return this.CPF;
	}
	public double getSaldo() {
		return this.saldo;
	}
	public String getSenha() {
		return this.senha;
	}
	public List getOperacoes() {
		return this.operacoes;
	}
	public Data getDataNasc() {
		return this.data_nasc;
	}
	public void setNome(String _nome) {
		this.nome = _nome;
	}
	public void setCPF(String _CPF) {
		this.CPF = _CPF;
	}
	public void setSaldo(double _saldo) {
		this.saldo = _saldo;
	}
	public void setSenha(String _senha) {
		this.senha = _senha;
	}
	public void setDataNasc(Data _data_nasc) {
		this.data_nasc = _data_nasc;
	}
	
	public void insere(String _CPF, Data _data, double _valor, TipoOperacao _operacao, int _tipo_conta) {
		Operacoes novo = new Operacoes(_CPF, _data, _valor, _operacao, _tipo_conta); //Quando uma nova operacao eh realizada, esse metodo eh 
		this.operacoes.add(novo);										//chamado, e ele adiciona a nova operacao a linkedlist.
	}
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append("Nome: " + this.getNome());
		info.append("\nCPF: " + this.getCPF());
		info.append("\nData de nascimento: " + this.getDataNasc());
		info.append("\nSaldo: " + this.getSaldo());
		info.append("\nOperacoes da conta: " + this.getOperacoes());
		return info.toString();
	}
}
