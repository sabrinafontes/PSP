import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JFileChooser;

public class FileManager {

	/*
	 * Método utilizado para selecionar um diretória via JFileChooser
	 * @return File Retorna um arquivo File com o diretório selecionado
	 */
	public static File getDirectory() {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setCurrentDirectory(new File("."));

		if (JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(null)) {
			return fileChooser.getSelectedFile();
		} else {
			System.out.println("Caminho não selecionado!");
			System.exit(1);
		}
		return null;
	}

	
	/* 
	 * Método utilizado para pegar o caminho de todos os arquivos
     * dentro de um diretório.
     *
     * @param caminho
     * @return ArrayList com os caminhos
     */
	public static ArrayList<String> getPathsArray(String path) {
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
			System.out.println("Arquivos inválidos");
		}
		return arrayPaths;
	}
	
	public static File lerDados(){
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setCurrentDirectory(new File("."));

		if (JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(null)) {
			return fileChooser.getSelectedFile();
		}
		return null;
	}
}
