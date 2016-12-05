import java.util.LinkedList;

public class Calcula {
    
	private static double multiplicarArrays(LinkedList<Double> xArrayList, LinkedList<Double> yArrayList){
		double mult = 0;
		for (int i = 0; i < xArrayList.size(); i++){
			mult += xArrayList.get(i)*yArrayList.get(i);
		}
		return mult;
	}
	
	private static double multiplicarArray(LinkedList<Double> xArrayList){
		double mult = 0;
		for (int i = 0; i < xArrayList.size(); i++){
			mult += xArrayList.get(i);
		}
		return mult;
	}
	
	private static double calcularMedia(LinkedList<Double> lista) {
		double somatoria = 0.0;
        for(double x : lista)
            somatoria += x;
        return somatoria/lista.size();
	}
	
	public static double calcularBeta0(double beta1, LinkedList<Double> lista1, LinkedList<Double> lista2){
		double mediaLista1 = calcularMedia(lista1); 
		double mediaLista2 = calcularMedia(lista2); 
		
		double beta0 = mediaLista2 - beta1*mediaLista1;
		
		return beta0;
	}
	
	public static double calcularBeta1(LinkedList<Double> lista1, LinkedList<Double> lista2){
		double mediaLista1 = calcularMedia(lista1); 
		double mediaLista2 = calcularMedia(lista2); 
		double beta1 = 0;
		
		beta1 = multiplicarArrays(lista1, lista2)-(lista1.size()*mediaLista1*mediaLista2);
		beta1 = beta1 / (multiplicarArrays(lista1, lista1) - lista1.size()*mediaLista1*mediaLista1);
		return beta1;
	}
	
	public static double calcularR(LinkedList<Double> lista1, LinkedList<Double> lista2){
		double r = 0;
		r = lista1.size()*multiplicarArrays(lista1, lista2)-multiplicarArray(lista1)*multiplicarArray(lista2);
		double minus = 0;
		minus = lista1.size()*multiplicarArrays(lista1, lista1)-multiplicarArray(lista1)*multiplicarArray(lista1);
		minus *= lista2.size()*multiplicarArrays(lista2, lista2)-multiplicarArray(lista2)*multiplicarArray(lista2);
		r = r / Math.sqrt(minus);
		return r;
	}
	
	public static double calcularY(double beta0, double beta1, double x){
		return (beta0 + beta1 * x);
	}
}