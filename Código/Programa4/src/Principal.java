import java.util.HashMap;
import java.util.LinkedList;
import java.io.File;

public class Principal {

	public static void main(String[] args) {		
		File arquivo1 = FileManager.lerDados();
		if (arquivo1 == null){
			System.out.println("Arquivo inválido");
			return;
		}		
		LinkedList<Double> lista1 = LeitorArquivo.lerDados(arquivo1);		
		
		File arquivo2 = FileManager.lerDados();
		if (arquivo2 == null){
			System.out.println("Arquivo inválido");
			return;
		}
		LinkedList<Double> lista2 = LeitorArquivo.lerDados(arquivo2);	
		
		
		LinkedList<Double> listaDividida = Calculo.Tamanho(lista1, lista2);		
		LinkedList<Double> listaLog = Calculo.ListaLog(listaDividida);
				
		double media = Calculo.Media(listaLog);
		double variancia = Calculo.Variancia(listaLog);
		double desvioPadrao = Calculo.DesvioPadrao(variancia);
		
		HashMap<String, Double> resultado = Calculo.IntervaloLog(media, desvioPadrao);
		
		System.out.println("Muito Pequeno: " + resultado.get("Muito Pequeno"));	
		System.out.println("Pequeno: " + resultado.get("Pequeno"));	
		System.out.println("Medio: " + resultado.get("Medio"));	
		System.out.println("Grande: " + resultado.get("Grande"));	
		System.out.println("Muito Grande: " + resultado.get("Muito Grande"));			
	}

}
