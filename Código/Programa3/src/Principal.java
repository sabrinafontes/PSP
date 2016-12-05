/**
* Contagem de linhas e elementos de um programa
*
* O Programa 3 é a implementação de um programa que
* calcula o inervalo de tamanho.
*
* @autor  Sabrina Fontes Carvalho
* @versão 1.0
* @data  19/11/2016
*/ 

/******************************************************************/
/* Listing Contents:                                                                                                   
/*    Reuse instructions 
/*      FileManager.java 
/*    Compilation instructions                                                                                    
/*    Includes 
/* 		java.io.File                                                                                                            
/*    Class declarations:                                                                                              
/*      public class Principal                                                                                                     
/* 		public class FileManager                   
/*      public class Calcula                                                          
/*	  Source code in: workspace/Programa3
/******************************************************************/

import java.io.File;
import java.util.LinkedList;

public class Principal {

	/* 
	 * Método principal do programa, utilizado para controlar o fluxo principal
     *
     * @param argumentos de execução
     */
	public static void main(String[] args) throws Exception {
		double x = 386;
		
		File fileDoc1 = FileManager.selecionarArquivo();
		File fileDoc2 = FileManager.selecionarArquivo();
		
		LinkedList<Double> listaDoc1 = new LinkedList<Double>();
		listaDoc1 = FileManager.lerDados(fileDoc1);
		
		LinkedList<Double> listaDoc2 = new LinkedList<Double>();
		listaDoc2 = FileManager.lerDados(fileDoc2);
				
		double beta1 = Calcula.calcularBeta1(listaDoc1, listaDoc2);
		double beta0 = Calcula.calcularBeta0(beta1, listaDoc1, listaDoc2);
		
		double r = Calcula.calcularR(listaDoc1, listaDoc2);
		double r2 = r * r;
		
		double y = Calcula.calcularY(beta0, beta1, x);
		
		System.out.println("beta0:" + beta0);
		System.out.println("beta1:" + beta1);
		System.out.println("r:" + r);
		System.out.println("r^2:" + r2);
		System.out.println("y:" + y);
	}
}
