package model;

import java.util.ArrayList;

public class Oximetria {

	private static int indiceDesenhoOximetria = 0;	
	private static String valorOximetria;
	private static long velocidadePlotOximetria;
	private static float rangeOximetria = 322;	
	private static ArrayList<Parametro> parametrosOxi;
	private String nomeOximetria;
	
	private static Oximetria oximetria;
		
	public static Oximetria getOximetria(){
		if(oximetria == null)
			oximetria = new Oximetria();
		
		return oximetria;
	}
	
	
	

	public String getNomeOximetria() {
		return nomeOximetria;
	}

	public void setNomeOximetria(String nomeOximetria) {
		this.nomeOximetria = nomeOximetria;
	}
	
	public static int getIndiceDesenhoOximetria() {
		return indiceDesenhoOximetria;
	}

	public static void setIndiceDesenhoOximetria(int indiceDesenhoOximetria) {
		Oximetria.indiceDesenhoOximetria = indiceDesenhoOximetria;
	}

	public static String getValorOximetria() {
		return valorOximetria;
	}

	public static void setValorOximetria(String valorOximetria) {
		Oximetria.valorOximetria = valorOximetria;
	}

	public static long getVelocidadePlotOximetria() {
		return velocidadePlotOximetria;
	}

	public static void setVelocidadePlotOximetria(long velocidadePlotOximetria) {
		Oximetria.velocidadePlotOximetria = velocidadePlotOximetria;
	}

	public static float getRangeOximetria() {
		return rangeOximetria;
	}

	public static void setRangeOximetria(float rangeOximetria) {
		Oximetria.rangeOximetria = rangeOximetria;
	}

	public static ArrayList<Parametro> getParametrosOxi() {
		return parametrosOxi;
	}

	public static void setParametrosOxi(ArrayList<Parametro> parametrosOxi) {
		Oximetria.parametrosOxi = parametrosOxi;
	}

	
	
}
