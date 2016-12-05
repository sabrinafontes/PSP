import java.util.HashMap;
import java.util.LinkedList;

public class Calculo {

	public static double DesvioPadrao(double variancia) {
		return Math.sqrt(variancia);
	}

	public static double Variancia(LinkedList<Double> lista) {
		double media = Media(lista);
		double tmp = 0;
		for (double a : lista)
			tmp += (a - media) * (a - media);
		double varianca = tmp / (lista.size() - 1);
		return varianca;
	}

	public static double Media(LinkedList<Double> lista) {
		double soma = 0.0;
		for (double a : lista)
			soma += a;
		return soma / lista.size();
	}

	public static LinkedList<Double> Tamanho(LinkedList<Double> lista1, LinkedList<Double> lista2) {
		LinkedList<Double> listaRetorno = new LinkedList<Double>();

		for (int i = 0; i < lista1.size(); i++) {
			double divisao = lista1.get(i) / lista2.get(i);
			listaRetorno.add(divisao);
		}
		return listaRetorno;
	}

	public static LinkedList<Double> ListaLog(LinkedList<Double> lista) {
		LinkedList<Double> listaRetorno = new LinkedList<Double>();

		for (int i = 0; i < lista.size(); i++) {
			double log = Math.log(lista.get(i));
			listaRetorno.add(log);
		}
		return listaRetorno;
	}

	public static HashMap<String, Double> IntervaloLog(double media, double dp) {
		double mPequeno = Math.pow(Math.E, media - (2 * dp));
		double Pequeno =  Math.pow(Math.E, media - dp);
		double Mediana = Math.pow(Math.E, media);
		double Grande = Math.pow(Math.E, media + dp);
		double mGrande = Math.pow(Math.E, media + (2 * dp));

		HashMap<String, Double> hashRetorno = new HashMap<String, Double>();

		hashRetorno.put("Muito Pequeno", mPequeno);
		hashRetorno.put("Pequeno", Pequeno);
		hashRetorno.put("Medio", Mediana);
		hashRetorno.put("Grande", Grande);
		hashRetorno.put("Muito Grande", mGrande);

		return hashRetorno;
	}
}
