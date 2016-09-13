package model;

import java.util.ArrayList;

public class Cardiaco {
	
	private static int velocidadeDesenhoCardiaco;
	private static int velocidadeRetaCardiaco;
	private static int indiceDesenho;	
	
	private static String valorBatimentoCardiaco = null;
	private String nomeCardiaco;
	
	private static ArrayList<Parametro> parametrosCar1;
	private static ArrayList<Parametro> parametrosCar2;
	private static ArrayList<Parametro> parametrosCar3;
	private static ArrayList<Parametro> parametrosCar4;
	
	private static double retaCardiaco0;
	private static double retaCardiaco1;
	private static double retaCardiaco2;
	private static double retaCardiaco3;
	private static double retaCardiaco4;
	
	private static Cardiaco cardiaco;
	
	
	
	public static Cardiaco getCardiaco(){
		
		if (cardiaco == null)
			cardiaco = new Cardiaco();
		
		return cardiaco;
	}


	
	
	public String getNomeCardiaco() {
		return nomeCardiaco;
	}
	
	public void setNomeCardiaco(String nomeCardiaco) {
		this.nomeCardiaco = nomeCardiaco;
	}
		
	public static int getVelocidadeDesenhoCardiaco() {
		return velocidadeDesenhoCardiaco;
	}

	public static void setVelocidadeDesenhoCardiaco(int velocidadeDesenhoCardiaco) {
		Cardiaco.velocidadeDesenhoCardiaco = velocidadeDesenhoCardiaco;
	}

	public static int getVelocidadeRetaCardiaco() {
		return velocidadeRetaCardiaco;
	}

	public static void setVelocidadeRetaCardiaco(int velocidadeRetaCardiaco) {
		Cardiaco.velocidadeRetaCardiaco = velocidadeRetaCardiaco;
	}

	public static int getIndiceDesenho() {
		return indiceDesenho;
	}

	public static void setIndiceDesenho(int indiceDesenho) {
		Cardiaco.indiceDesenho = indiceDesenho;
	}

	public static String getValorBatimentoCardiaco() {
		return valorBatimentoCardiaco;
	}

	public static void setValorBatimentoCardiaco(String valorBatimentoCardiaco) {
		Cardiaco.valorBatimentoCardiaco = valorBatimentoCardiaco;
	}

	public static ArrayList<Parametro> getParametrosCar1() {
		return parametrosCar1;
	}

	public static void setParametrosCar1(ArrayList<Parametro> parametrosCar1) {
		Cardiaco.parametrosCar1 = parametrosCar1;
	}

	public static ArrayList<Parametro> getParametrosCar2() {
		return parametrosCar2;
	}

	public static void setParametrosCar2(ArrayList<Parametro> parametrosCar2) {
		Cardiaco.parametrosCar2 = parametrosCar2;
	}

	public static ArrayList<Parametro> getParametrosCar3() {
		return parametrosCar3;
	}

	public static void setParametrosCar3(ArrayList<Parametro> parametrosCar3) {
		Cardiaco.parametrosCar3 = parametrosCar3;
	}

	public static ArrayList<Parametro> getParametrosCar4() {
		return parametrosCar4;
	}

	public static void setParametrosCar4(ArrayList<Parametro> parametrosCar4) {
		Cardiaco.parametrosCar4 = parametrosCar4;
	}

	public static double getRetaCardiaco0() {
		return retaCardiaco0;
	}

	public static void setRetaCardiaco0(double retaCardiaco0) {
		Cardiaco.retaCardiaco0 = retaCardiaco0;
	}

	public static double getRetaCardiaco1() {
		return retaCardiaco1;
	}

	public static void setRetaCardiaco1(double retaCardiaco1) {
		Cardiaco.retaCardiaco1 = retaCardiaco1;
	}

	public static double getRetaCardiaco2() {
		return retaCardiaco2;
	}

	public static void setRetaCardiaco2(double retaCardiaco2) {
		Cardiaco.retaCardiaco2 = retaCardiaco2;
	}

	public static double getRetaCardiaco3() {
		return retaCardiaco3;
	}

	public static void setRetaCardiaco3(double retaCardiaco3) {
		Cardiaco.retaCardiaco3 = retaCardiaco3;
	}

	public static double getRetaCardiaco4() {
		return retaCardiaco4;
	}

	public static void setRetaCardiaco4(double retaCardiaco4) {
		Cardiaco.retaCardiaco4 = retaCardiaco4;
	}
	
}
