package model;

import java.util.ArrayList;

public class Respiratorio {
	//Atributos
	private static float resPosicaoX;
	private static float posicaoDesenhoReta;
	
	private double retaRespiratorio;
	private double retaRespiratorio1;
	private double retaRespiratorio2;
	
	private ArrayList<Parametro> parametrosResp1;
	private ArrayList<Parametro> parametrosResp2;
	private ArrayList<Parametro> parametrosResp3;
	
	private	String valorRespiratorio;
	private String nomeRespiratorio;
	
	private int espessuraLinha = 3;
	private int indiceDesenhoResp = 0;
	private int indiceReta = 0;
	private boolean desenho = false;
	private float frequencia = 0; //Quantidade de ciclos no grÃ¡fico
	private Integer valorRitmoRespiratorio;
	private int velocidadePlot = 20; 
	private int velocidadePlotDesenho = 50; //Velocidade do momento em que a onda começa a ser desenhada
	
	private static Respiratorio respiratorio;
	
	//Método construtor
	public static Respiratorio getRespiratorio(){
		if (respiratorio== null)
			respiratorio = new Respiratorio();
		
		return respiratorio;
	}
	
	
	//Métodos getters e setters
	
	
	
	public static float getResPosicaoX() {
		return resPosicaoX;
	}

	public String getNomeRespiratorio() {
		return nomeRespiratorio;
	}


	public void setNomeRespiratorio(String nomeRespiratorio) {
		this.nomeRespiratorio = nomeRespiratorio;
	}


	public static void setResPosicaoX(float resPosicaoX) {
		Respiratorio.resPosicaoX = resPosicaoX;
	}

	public static float getPosicaoDesenhoReta() {
		return posicaoDesenhoReta;
	}

	public static void setPosicaoDesenhoReta(float posicaoDesenhoReta) {
		Respiratorio.posicaoDesenhoReta = posicaoDesenhoReta;
	}

	public double getRetaRespiratorio() {
		return retaRespiratorio;
	}

	public void setRetaRespiratorio(double retaRespiratorio) {
		this.retaRespiratorio = retaRespiratorio;
	}

	public double getRetaRespiratorio1() {
		return retaRespiratorio1;
	}

	public void setRetaRespiratorio1(double retaRespiratorio1) {
		this.retaRespiratorio1 = retaRespiratorio1;
	}

	public double getRetaRespiratorio2() {
		return retaRespiratorio2;
	}

	public void setRetaRespiratorio2(double retaRespiratorio2) {
		this.retaRespiratorio2 = retaRespiratorio2;
	}

	public ArrayList<Parametro> getParametrosResp1() {
		return parametrosResp1;
	}

	public void setParametrosResp1(ArrayList<Parametro> parametrosResp1) {
		this.parametrosResp1 = parametrosResp1;
	}

	public ArrayList<Parametro> getParametrosResp2() {
		return parametrosResp2;
	}

	public void setParametrosResp2(ArrayList<Parametro> parametrosResp2) {
		this.parametrosResp2 = parametrosResp2;
	}

	public ArrayList<Parametro> getParametrosResp3() {
		return parametrosResp3;
	}

	public void setParametrosResp3(ArrayList<Parametro> parametrosResp3) {
		this.parametrosResp3 = parametrosResp3;
	}

	public String getValorRespiratorio() {
		return valorRespiratorio;
	}

	public void setValorRespiratorio(String valorRespiratorio) {
		this.valorRespiratorio = valorRespiratorio;
	}

	public int getEspessuraLinha() {
		return espessuraLinha;
	}

	public void setEspessuraLinha(int espessuraLinha) {
		this.espessuraLinha = espessuraLinha;
	}

	public int getIndiceDesenhoResp() {
		return indiceDesenhoResp;
	}

	public void setIndiceDesenhoResp(int indiceDesenhoResp) {
		this.indiceDesenhoResp = indiceDesenhoResp;
	}

	public boolean isDesenho() {
		return desenho;
	}

	public void setDesenho(boolean desenho) {
		this.desenho = desenho;
	}

	public float getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(float frequencia) {
		this.frequencia = frequencia;
	}

	public Integer getValorRitmoRespiratorio() {
		return valorRitmoRespiratorio;
	}

	public void setValorRitmoRespiratorio(Integer valorRitmoRespiratorio) {
		this.valorRitmoRespiratorio = valorRitmoRespiratorio;
	}

	public static void setRespiratorio(Respiratorio respiratorio) {
		Respiratorio.respiratorio = respiratorio;
	}

	public int getVelocidadePlot() {
		return velocidadePlot;
	}

	public void setVelocidadePlot(int velocidadePlot) {
		this.velocidadePlot = velocidadePlot;
	}


	public int getVelocidadePlotDesenho() {
		return velocidadePlotDesenho;
	}


	public void setVelocidadePlotDesenho(int velocidadePlotDesenho) {
		this.velocidadePlotDesenho = velocidadePlotDesenho;
	}


	public int getIndiceReta() {
		return indiceReta;
	}


	public void setIndiceReta(int indiceReta) {
		this.indiceReta = indiceReta;
	}
	
}