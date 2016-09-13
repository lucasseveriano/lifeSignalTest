package test;

import org.junit.Test;

import control.ControladorPrograma;
import model.Cardiaco;

public class ControlerTeste {
	
	Cardiaco cardiaco;


	@SuppressWarnings("static-access")
	@Test
	public void IniciarControladorPrograma() {
		
		ControladorPrograma ctrlPrograma = new ControladorPrograma();
		
		ctrlPrograma.instanciarObjetos();
		
		System.out.println("Reta Cardiaco 0 = " + cardiaco.getRetaCardiaco0());
		System.out.println("Reta Cardiaco 1 = " + cardiaco.getRetaCardiaco1());
		System.out.println("Reta Cardiaco 2 = " + cardiaco.getRetaCardiaco2());
		System.out.println("Reta Cardiaco 3 = " + cardiaco.getRetaCardiaco3());
		System.out.println("Reta Cardiaco 4 = " + cardiaco.getRetaCardiaco4());
		System.out.println("Indice Desenho = " + cardiaco.getIndiceDesenho());
		System.out.println("Valor Batimento = " + cardiaco.getValorBatimentoCardiaco());
		System.out.println("Velocidade Reta Cardiaco = " + cardiaco.getVelocidadeRetaCardiaco());
		System.out.println("Total Parametros 1 = " + cardiaco.getParametrosCar1().size());
		System.out.println();
		
		ctrlPrograma.atualizarRitmoCardiaco("Bradicardia Sinusal");
		
		System.out.println("Cardiaco Atualizado");
		System.out.println();
		
		System.out.println("Reta Cardiaco 0 = " + cardiaco.getRetaCardiaco0());
		System.out.println("Reta Cardiaco 1 = " + cardiaco.getRetaCardiaco1());
		System.out.println("Reta Cardiaco 2 = " + cardiaco.getRetaCardiaco2());
		System.out.println("Reta Cardiaco 3 = " + cardiaco.getRetaCardiaco3());
		System.out.println("Reta Cardiaco 4 = " + cardiaco.getRetaCardiaco4());
		System.out.println("Indice Desenho = " + cardiaco.getIndiceDesenho());
		System.out.println("Valor Batimento = " + cardiaco.getValorBatimentoCardiaco());
		System.out.println("Velocidade Reta Cardiaco = " + cardiaco.getVelocidadeRetaCardiaco());
		System.out.println("Total Parametros 1 = " + cardiaco.getParametrosCar1().size());
		System.out.println();
		
		ctrlPrograma.atualizarRitmoCardiaco("Bloqueio Sinoauricula");
		
		System.out.println("Cardiaco Atualizado");
		System.out.println();
		
		System.out.println("Reta Cardiaco 0 = " + cardiaco.getRetaCardiaco0());
		System.out.println("Reta Cardiaco 1 = " + cardiaco.getRetaCardiaco1());
		System.out.println("Reta Cardiaco 2 = " + cardiaco.getRetaCardiaco2());
		System.out.println("Reta Cardiaco 3 = " + cardiaco.getRetaCardiaco3());
		System.out.println("Reta Cardiaco 4 = " + cardiaco.getRetaCardiaco4());
		System.out.println("Indice Desenho = " + cardiaco.getIndiceDesenho());
		System.out.println("Valor Batimento = " + cardiaco.getValorBatimentoCardiaco());
		System.out.println("Velocidade Reta Cardiaco = " + cardiaco.getVelocidadeRetaCardiaco());
		System.out.println("Total Parametros 1 = " + cardiaco.getParametrosCar1().size());
		
	}

}
