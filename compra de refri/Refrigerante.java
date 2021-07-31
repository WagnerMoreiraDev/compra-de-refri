public class Refrigerante {
	private String nome;
	private float preco;
	private int quantidade;
	
	public Refrigerante (String nome, float preco, int quantidade) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	} 
	
	public Refrigerante (String nome, float preco) {
		this.nome = nome;
		this.preco = preco;
		}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public float getPreco() {
		return this.preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public int getQuantidade() {
		return this.quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}	