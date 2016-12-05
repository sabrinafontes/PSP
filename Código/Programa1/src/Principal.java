import java.util.LinkedList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		LinkedList<Double> lista = new LinkedList<Double>();
		Scanner sc = new Scanner(System.in); // Lê o que está sendo digitado no
												// console
		Estatistica est = new Estatistica();

		System.out.println("Insira os números para o cálculo de média e desvio padrão.");

		boolean controle = true;

		while (controle) {
			String numero = sc.nextLine();

			if (numero.equals("") || numero.equals(" ") || numero.equals("\n") || numero.equals(null))
			{
				controle = false;
			}
			else
			{
				try
				{
					lista.add(Double.parseDouble(numero));
				}
				catch(NumberFormatException e)
				{
					System.out.println("Por favor, insira somente números.");
					sc.nextLine();
					sc.close();
					return;
				}
			}
		}
		
		if(lista.size() > 0)
		{
			System.out.println("Média: " + est.calculaMedia(lista));
			System.out.println("Desvio Padrão: " + est.calculaDesvioPadrao(lista));
		}
		else
		{
			System.out.println("Finalizado!");
		}
		
		sc.nextLine();
		sc.close();
		return;
	}

}
