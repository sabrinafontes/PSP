/**
* Contagem de linhas e elementos de um programa
*
* O Programa 2 � a implementa��o de um programa que
* conta linhas de c�digo, m�todos e classes de programas.
*
* @autor  Sabrina Fontes Carvalho
* @vers�o 1.0
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
	 * M�todo principal do programa, utilizado para controlar o fluxo principal
     *
     * @param argumentos de execu��o
     */
	public static void main(String[] args) {
		
		File file = FileManager.selecionaDiretorio();
		
		if (file != null) {

			System.out.println("Abrindo: " + file.getName() + ".");
			Contador contador = new Contador(FileManager.obterCaminho(file.getPath()));
			
			/* Na proxima se��o o programa ir� processar o tamanho
			 * de cada arquivo encontrado dentro da pasta selecionada
			 */
			
			int totalClasses = contador.caminhosLista.size();
			int totalMetodos = contador.contaMetodos();
			int totalLOC = contador.contaLinhas();
			
			System.out.println("Total de classes: " + totalClasses);
			System.out.println("Total de m�todos: " + totalMetodos);
			System.out.println("Total de linhas: " + totalLOC);
		} else {
			System.out.println("Opera��o cancelada!");
		}
	}

}
