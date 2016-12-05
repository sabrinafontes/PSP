import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;;

public class LeitorArquivo {
	public static LinkedList<Double> lerDados(File arquivo){
		LinkedList<Double> listaRetorno = new LinkedList<Double>();
		try {
			FileReader fReader = new FileReader(arquivo);
			BufferedReader bReader = new BufferedReader(fReader);
			String linha;
			try {
				while ((linha = bReader.readLine())!= null){
					listaRetorno.add(Double.parseDouble(linha));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			return null;
		}		
		return listaRetorno;
	}
}
