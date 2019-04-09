
public class ContaBancaria {
	private String nome;
	private double saldo;
	static final private double DEFAULT_JUROS = 0.02;
	static private double tax_juros = ContaBancaria.DEFAULT_JUROS;
	
	public ContaBancaria() throws Exception {
		this.setNome("");
		this.setSaldo(0);
		
	}
	public ContaBancaria(String nome) throws Exception {
		this.setNome(nome);
		this.setSaldo(0);
	}
	public ContaBancaria(double valor) throws Exception {
		this.setSaldo(valor);
		this.setNome("");
	}
	public ContaBancaria(String nome, double valor) throws Exception {
		this.setNome(nome);
		this.setSaldo(valor);
	}
	
	public static void setJuros(double valor) {
		ContaBancaria.tax_juros = valor;
	}
	public void setNome(String valor) {
		this.nome = valor;
	}
	public void setSaldo (double valor) throws Exception {
		if (valor >= 0) this.saldo = valor;
		else {
			throw new Exception("Saldo negativo");
		}
	}
	public static double getJuros() {
		return ContaBancaria.tax_juros;
	}
	public String getNome() {
		return this.nome;
	}
	public double getSaldo() {
		return this.saldo;
	}
	
	public String toString() {
		StringBuilder dados = new StringBuilder();
		dados.append("Nome: "+this.getNome());
		dados.append("\n");
		dados.append("Saldo: " +this.getSaldo());
		return dados.toString();
	}
	
	public boolean equals(Object objeto) {
		ContaBancaria aux = (ContaBancaria) objeto;
		if (this.nome.equals(aux.nome)) {
			if (this.saldo == aux.saldo) {
				return true;
			}
		}
		return false;
	}
	
	public int compareTo(Object objeto) {
		ContaBancaria aux = (ContaBancaria) objeto;
		if (this.saldo > aux.saldo) return 1;
		if (this.saldo < aux.saldo) return -1;
		return 0;
	}
	
	public double correcaoSaldo() {
		this.saldo = this.saldo + this.saldo * ContaBancaria.tax_juros;
		return this.saldo;
	}
	
	
	
	
}
