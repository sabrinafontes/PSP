/**
* Contagem de linhas e elementos de um programa
*
* O Programa 2 é a implementação de um programa que
* conta linhas de código, métodos e classes de programas.
*
* @autor  Sabrina Fontes Carvalho
* @versão 1.0
* @data  19/10/2016
*/ 

/******************************************************************/
/* Listing Contents:                                                                                                   
/*    Reuse instructions 
/*      FileManager.java 
/*    Compilation instructions                                                                                    
/*    Includes  
/* 		java.util.regex
/* 		java.io.File                                                                                                            
/*    Class declarations:                                                                                              
/*      public class Principal                                                                                                     
/* 		public class FileManager                   
/*      public class Contador                                                          
/*	  Source code in: workspace/Programa2
/******************************************************************/

import java.io.File;

public class Principal {

	/* 
	 * Método principal do programa, utilizado para controlar o fluxo principal
     *
     * @param argumentos de execução
     */
	public static void main(String[] args) {
		
		File file = FileManager.selecionaDiretorio();
		
		if (file != null) {

			System.out.println("Abrindo: " + file.getName() + ".");
			Contador contador = new Contador(FileManager.obterCaminho(file.getPath()));
			
			/* Na proxima seção o programa irá processar o tamanho
			 * de cada arquivo encontrado dentro da pasta selecionada
			 */
			
			int totalClasses = contador.caminhosLista.size();
			int totalMetodos = contador.contaMetodos();
			int totalLOC = contador.contaLinhas();
			
			System.out.println("Total de classes: " + totalClasses);
			System.out.println("Total de métodos: " + totalMetodos);
			System.out.println("Total de linhas: " + totalLOC);
		} else {
			System.out.println("Operação cancelada!");
		}
	}

}
