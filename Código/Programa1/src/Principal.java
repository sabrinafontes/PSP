import java.util.LinkedList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		LinkedList<Double> lista = new LinkedList<Double>();
		Scanner sc = new Scanner(System.in); // L� o que est� sendo digitado no
												// console
		Estatistica est = new Estatistica();

		System.out.println("Insira os n�meros para o c�lculo de m�dia e desvio padr�o.");

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
					System.out.println("Por favor, insira somente n�meros.");
					sc.nextLine();
					sc.close();
					return;
				}
			}
		}
		
		if(lista.size() > 0)
		{
			System.out.println("M�dia: " + est.calculaMedia(lista));
			System.out.println("Desvio Padr�o: " + est.calculaDesvioPadrao(lista));
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
