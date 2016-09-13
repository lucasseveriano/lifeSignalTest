package test;

import org.junit.Test;

import control.LeitorBatimentos;
import model.Oximetria;

public class ModelTeste {

	@SuppressWarnings("static-access")
	@Test
	public void getOximetria() {
		
		LeitorBatimentos batimentos = new LeitorBatimentos();
		
		Oximetria oximetria = Oximetria.getOximetria();
		oximetria.setIndiceDesenhoOximetria(0);
		oximetria.setRangeOximetria(322);
		oximetria.setVelocidadePlotOximetria(40);
		oximetria.setParametrosOxi(batimentos.getParameters("oxiBaixaPerfusão.txt"));
		
		System.out.println("Objeto Criado");
		System.out.println();
		
		Oximetria oximetria2 = Oximetria.getOximetria();
		
		System.out.println("Ranger:" + oximetria2.getRangeOximetria());
		System.out.println("Indice Desenho:" + oximetria2.getIndiceDesenhoOximetria());
		System.out.println("Velocidade Plot:" + oximetria2.getVelocidadePlotOximetria());
		System.out.println("Total parametros:" + oximetria2.getParametrosOxi().size());
		
		oximetria2.setRangeOximetria(500);
		oximetria.setParametrosOxi(batimentos.getParameters("oxiRuídoArtefato.txt"));
		
		System.out.println();
		System.out.println("Objeto alterado");
		System.out.println();
		
		System.out.println("Ranger:" + oximetria2.getRangeOximetria());
		System.out.println("Indice Desenho:" + oximetria2.getIndiceDesenhoOximetria());
		System.out.println("Velocidade Plot:" + oximetria2.getVelocidadePlotOximetria());
		System.out.println("Total parametros:" + oximetria2.getParametrosOxi().size());
		
		
	}

}
