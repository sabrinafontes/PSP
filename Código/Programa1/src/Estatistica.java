import java.util.LinkedList;

public class Estatistica {

	/**
	 *** Calcula o desvio padr�o de uma lista de n�meros
	 **/
	public double calculaDesvioPadrao(LinkedList<Double> lista) {
		if (lista.size() == 1) 
		{
			return 0.0;
		} 
		else 
		{
			double media = calculaMedia(lista);
			double soma = 0;
			for (int i = 0; i < lista.size(); i++) 
			{
				double result = lista.get(i) - media;
				soma = soma + result * result;
			}
			return Math.sqrt(((double) 1 / (lista.size() - 1)) * soma);
		}
	}

	/**
	 *** Calcula a m�dia simples de uma lista de n�meros
	 **/
	public double calculaMedia(LinkedList<Double> lista) {
		double soma = 0l;
		for (double d : lista) 
		{
			soma += d;
		}
		return soma / lista.size();
	}

}
