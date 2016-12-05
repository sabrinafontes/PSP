import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

import javax.swing.JFileChooser;

public class FileManager {

	/*
	 * M�todo utilizado para selecionar um diret�rio via JFileChooser
	 * @return File Retorna um arquivo File com o diret�rio selecionado
	 */
	public static File selecionaDiretorio() {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setCurrentDirectory(new File("."));

		if (JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(null)) {
			return fileChooser.getSelectedFile();
		} else {
		System.out.println("Caminho n�o selecionado!");
			System.exit(1);
		}
		return null;
	}
	
	/*
	 * M�todo para selecionar um arquivo
	 * @return Um File contendo o arquivo selecionado
	*/
	
	public static File selecionarArquivo(){
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setCurrentDirectory(new File("."));

		if (JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(null)) {
			return fileChooser.getSelectedFile();
		} else {
			System.out.println("Arquivo n�o selecionado!");
			System.exit(1);
		}
		return null;
	}

	
	/* 
	 * M�todo utilizado para pegar o caminho de todos os arquivos
     * dentro de um diret�rio.
     *
     * @param caminho
     * @return ArrayList com os caminhos
     */
	public static ArrayList<String> obterCaminho(String path) {
		
		ArrayList<String> arrayPaths = new ArrayList<>();
		
		try {	
			Files.walk(Paths.get(path)).forEach(filePath -> {
				if (Files.isRegularFile(filePath)) {
					if (filePath.toString().endsWith("java")) {
						arrayPaths.add(filePath.toString());
					}
				}
			});
		} catch (IOException ex) {
			System.out.println("Arquivos inv�lidos");
		}
		return arrayPaths;
	}
	
	/* 
	 * M�todo para ler o conteudo do arquivo e transformar em uma lista lincada.
	 *
	 * @param arquivo contendo um valor por linha
	 * @return LinkedList<Double> com os valores encontrados no arquivo.
	*/
	public static LinkedList<Double> lerDados(File arquivo) throws IOException {
		LinkedList<Double> listaRetorno = new LinkedList<Double>();
		BufferedReader buffReader  = new BufferedReader(new FileReader(arquivo));
		try {			
			String linha = buffReader.readLine();
			
			while (linha != null) {
				listaRetorno.add(Double.parseDouble(linha));
				linha = buffReader.readLine();
			}
		}
		finally {
			buffReader.close();
		}	
		
		return listaRetorno;
	}
}
