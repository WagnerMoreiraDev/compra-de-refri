import java.util.Scanner;

public class AppMaquinaDeRefrigerante {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		MaquinaDeRefrigerante mr = new MaquinaDeRefrigerante();
		Refrigerante r1 = new Refrigerante("Coca-Cola 350ml", 3.99f);
		Refrigerante r2 = new Refrigerante("Fanta 350ml", 2.99f);
		Refrigerante r3 = new Refrigerante("Sukita 350ml", 2.99f);
		Refrigerante r4 = new Refrigerante("Guaraná Antarctica 350ml", 3.49f);
		Refrigerante r5 = new Refrigerante("Baré 350ml", 2.49f);
		int opcao, seletor = 0, resposta;
		float credito = 0f;
		boolean valorValido = true;
		do {
			mr.mostrarInfo();
			do {
				try {
					System.out.printf("\nPor favor, escolha uma das seguintes opções:\n" +
						"Digite 100 para inserir crédito!\n" +
						"Escolha o seu refrigerante favorito digitando de 1 a 5!\n" +
						"Para sair, digite 0!\n" +
					"MR:\\> ");
					seletor = Integer.valueOf(input.nextLine());
					valorValido = true;
					} catch (NumberFormatException ex) {
					System.out.println("Ops! Por favor, verifique as opções no menu e tente novamente!");
					valorValido = false;
				}
			} while (!valorValido);
			opcao = seletor - 1;
			switch(opcao) {
				case 0:
				case 1:
				case 2:
				case 3:
				case 4:
				resposta = mr.comprarRefrigerante(opcao);
				if (resposta == 0) {
					if (seletor == 1) {
						System.out.printf("Você acabou de comprar uma %s por R$ %.2f.\n", r1.getNome(), r1.getPreco());
					}
					else if (seletor == 2) {
						System.out.printf("Você acabou de comprar uma %s por R$ %.2f.\n", r2.getNome(), r2.getPreco());
					}
					else if (seletor == 3) {
						System.out.printf("Você acabou de comprar uma %s por R$ %.2f.\n", r3.getNome(), r3.getPreco());
					}
					else if (seletor == 4) {
						System.out.printf("Você acabou de comprar um %s por R$ %.2f.\n", r4.getNome(), r4.getPreco());
					}
					else if (seletor == 5) {
						System.out.printf("Você acabou de comprar uma %s por R$ %.2f.\n", r5.getNome(), r5.getPreco());
					}
				}
				else if (resposta == -1) {
					System.out.println("\nO seu saldo não é suficiente para realizar esta compra.\n" +
					"Por favor, insira mais crédito selecionando a opção 100!\n");
				}
				else {
					System.out.println("\nDesculpe! O refrigerante que você selecionou está em falta.\n" +
					"Por favor, escolha outro item na lista ou volte mais tarde!\n");
				}
				break;
				case 99:
				do {
					try {
						System.out.println("Por favor, informe qual o valor do crédito a ser inserido:");
						credito = Float.valueOf(input.nextLine());
						valorValido = true;
						if (credito < 1) {
							System.out.println("Atenção! O menor valor de crédito disponível é R$ 1,00.");
							valorValido = false;
						}
						else if (credito > 100) {
							System.out.println("Atenção! O maior valor de crédito disponível é R$ 100,00.");
							valorValido = false;
						}
						} catch (NumberFormatException ex) {
						System.out.println("Ops! Verifique o valor do crédito a ser inserido e tente novamente.");
						valorValido = false;
					}
				} while(!valorValido);
				mr.inserirCredito(credito);
				break;
				case -1:
				if (credito == 0) {
					System.out.println("Obrigado por ter utilizado a nossa máquina de refrigerante! Volte sempre!");
				}
				else {
					System.out.printf("Obrigado por ter utilizado a nossa máquina de refrigerante!\n" +
					"Por favor, retire o seu troco no valor de R$ %.2f!\n", mr.solicitarTroco());
					System.out.println("Volte sempre!");
				}
				break;
				default:
				System.out.println("Ops! Parece que você digitou uma opção inválida.\n" +
				"Por favor, escolha um dos refrigerantes da lista ou digite 0 para sair.");
				break;
				}
				}
			while (opcao != -1);
		}
}