import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Contador {

	ArrayList<String> caminhosLista = new ArrayList<>();

	/* 
	 * Método utilizado para inicializar um objeto do tipo Contador
     *
     * @param array de caminhos de arquivos
     */
	public Contador(ArrayList<String> caminhosLista) {
		this.caminhosLista = caminhosLista;
	}

	/* 
	 * Método utilizado para contar as linhas de códigos de arquivos
     *
     * @return int com o número de LOC (Lines of Code)
     */
	public int contaLinhas() {
		int LOCCounter = 0;
		for (String path : caminhosLista) {
			int classLOCCount = 0;
			try (BufferedReader br = new BufferedReader(new FileReader(path))) {

				String sCurrentLine;
				while ((sCurrentLine = br.readLine()) != null) {
					if (sCurrentLine.endsWith("{")) {
						classLOCCount++;
						LOCCounter++;
					} else if (sCurrentLine.endsWith(";")) {
						classLOCCount++;
						LOCCounter++;
					}
				}
				System.out.println("LOC da classe " + path + " = " + classLOCCount);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return LOCCounter;
	}

	/* 
	 * Método utilizado para contar os metodos dentro de arquivos
     *
     * @return int com o número de métodos
     */
	public int contaMetodos() {
		int methodCounter = 0;
		for (String path : caminhosLista) {
			int classMethodCount = 0;			
			try (BufferedReader br = new BufferedReader(new FileReader(path))) {

				String sCurrentLine;
				while ((sCurrentLine = br.readLine()) != null) {
					if (sCurrentLine.contains("public") && sCurrentLine.contains("(") && sCurrentLine.endsWith("{")) {
						classMethodCount++;
						methodCounter++;
					} else if (sCurrentLine.contains("private") && sCurrentLine.contains("(")
							&& sCurrentLine.endsWith("{")) {
						classMethodCount++;
						methodCounter++;
					} else if (sCurrentLine.contains("protected") && sCurrentLine.contains("(")
							&& sCurrentLine.endsWith("{")) {
						classMethodCount++;
						methodCounter++;
					}
				}
				System.out.println("Métodos da classe " + path + " = " + classMethodCount);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return methodCounter;
	}

}