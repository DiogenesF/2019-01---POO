
public class RetanguloEscalavel implements ObjetoGeometrico, Escalavel{
	private Ponto pe, pd;
	
	public RetanguloEscalavel(double x1, double y1, double x2, double y2) throws Exception{
		Ponto p1 = new Ponto(x1, y1);
		Ponto p2 = new Ponto(x2, y2);
		this.setRetangulo(p1, p2);
	}
	public RetanguloEscalavel() throws Exception {
		Ponto p1 = new Ponto();
		Ponto p2 = new Ponto();
		this.setRetangulo(p1, p2);
	}
	
	public Ponto getPe() {
		return this.pe;
	}
	public Ponto getPd() {
		return this.pd;
	}
	public double getLadoX(Ponto pe, Ponto pd) {
		return (Math.abs(pe.getX() - pd.getX()));
	}
	public double getLadoY(Ponto pe, Ponto pd) {
		return (Math.abs(pe.getY() - pd.getY()));
	}
	public void setRetangulo(Ponto pe,Ponto pd) {
		this.pe = pe;
		this.pd = pd;
	}
	
	public double calculaArea() {
		return ((getLadoX(this.getPe(), this.getPd())) * getLadoY(this.getPe(), this.getPd()));
	}
	public double calculaPerimetro() {
		return ((2 * getLadoX(this.getPe(), this.getPd()) + (2 * getLadoY(this.getPe(), this.getPd()))));
	}
	public Ponto centro() throws Exception{
		Ponto pc = new Ponto((this.pe.getX() + this.pd.getX())/2, (this.pe.getY() + this.pd.getY())/2);
		return pc;
	}
	public void amplia(double escala) throws Exception{
			this.pe.setY(this.pe.getY() * escala);
			this.pd.setX(this.pd.getX() * escala);

	}
	public void espelha() throws Exception{
			this.pe = new Ponto(this.pe.getX() * (-1), this.pe.getY());
			this.pd = new Ponto(this.pd.getX() * (-1), this.pd.getY());
	}
	public ObjetoGeometrico clona() throws Exception{
		RetanguloEscalavel r = new RetanguloEscalavel(this.pe.getX(), this.pe.getY(), this.pd.getX(), this.pd.getY());
		return r;
	}
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append("Ponto Esquerdo: ");
		info.append(this.pe.toString());
		info.append("Ponto direito: ");
		info.append(this.pd.toString());
		return info.toString();
	}
}