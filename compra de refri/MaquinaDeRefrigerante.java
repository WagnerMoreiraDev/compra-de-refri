public class MaquinaDeRefrigerante {
	private Refrigerante lista[];
	private float credito;
	
	public MaquinaDeRefrigerante() {
		lista = new Refrigerante[5];
		lista[0] = new Refrigerante("Coca-Cola 350ml", 3.99f, 5);
		lista[1] = new Refrigerante("Fanta 350ml", 2.99f, 5);
		lista[2] = new Refrigerante("Sukita 350ml", 2.99f, 5);
		lista[3] = new Refrigerante("Guaraná Antárctica 350ml", 3.49f, 5);
		lista[4] = new Refrigerante("Baré 350ml", 2.49f, 5);
		this.credito = 0f;
	}
	
	public void inserirCredito(float valor) {
		this.credito += valor;
	}
	
	public float solicitarTroco() {
		float troco = this.credito;
		this.credito = 0.0f;
		return troco;
	}
	
	public int comprarRefrigerante(int numeroRefri) {
		if (this.credito >= lista[numeroRefri].getPreco()) {
			if (lista[numeroRefri].getQuantidade() > 0) {
				this.credito -= lista[numeroRefri].getPreco(); 
				int novaQuantidade = lista[numeroRefri].getQuantidade() - 1; 
				lista[numeroRefri].setQuantidade(novaQuantidade);
				return 0;
			} 
			else {
				return -2;
			}
		}
		else {
			return -1;
		}
	}
	
	public void mostrarInfo() {
		System.out.printf("==============================\n" +
			"| Máquina de Refrigerante.     |\n" +
			"------------------------------\n" +
			"| Credito disponível: R$ %.2f.\n" +
		"------------------------------\n", this.credito);
		
		for (Refrigerante r : lista){
			System.out.printf("%s - R$ %.2f.\n", r.getNome(), r.getPreco());
		}
		System.out.println("==============================");
	}
}