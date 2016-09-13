
package control;

import java.util.ArrayList;

import model.Parametro;
import model.Respiratorio;

public class ControladorRitmoRespiratorio {

	Respiratorio respiratorio;
	ControladorPrograma ctrlPrograma;
	LeitorBatimentos batimentos = new LeitorBatimentos();
	
	Thread threadRespiratorio;
	
	//Método contrutor
	public ControladorRitmoRespiratorio(ControladorPrograma ctrlPrograma){
		this.ctrlPrograma = ctrlPrograma;
	}
	
	/**
	 * MÉTODO RESPONSÁVEL POR RETORNAR UM OBJETO RESPIRATORIO
	 * @param nome
	 * @return
	 */
	public Respiratorio getRespiratorio(String nome){
		respiratorio = Respiratorio.getRespiratorio();
		respiratorio = atualizarParametrosRespiratorio(nome, respiratorio);
		return respiratorio;
	}
	
	
	private Respiratorio atualizarParametrosRespiratorio(String ritmo, Respiratorio respiratorio) {
		switch(ritmo)
		{
		case "Eupneia":
			//Gera valor aleatório dentro de uma faixa
			Integer valorRitmoRespiratorio = 12 + (int)(Math.random() * 9);
			respiratorio.setParametrosResp1(batimentos.getParameters("resEupneia.txt"));
			respiratorio.setParametrosResp2(null);
			respiratorio.setParametrosResp3(null);
			respiratorio.setRetaRespiratorio(1);
			respiratorio.setRetaRespiratorio1(250);
			respiratorio.setRetaRespiratorio2(0);
			respiratorio.setIndiceDesenhoResp(0);
			respiratorio.setValorRespiratorio(valorRitmoRespiratorio.toString());
			respiratorio.setNomeRespiratorio("Eupneia");
			respiratorio.setVelocidadePlotDesenho(50);
			respiratorio.setVelocidadePlot(20);
			break;
			
		case "Taquipneia":
			respiratorio.setParametrosResp1(batimentos.getParameters("resTaquipneia.txt"));
			respiratorio.setParametrosResp2(null);
			respiratorio.setParametrosResp3(null);
			respiratorio.setRetaRespiratorio(10);
			respiratorio.setRetaRespiratorio1(10);
			respiratorio.setRetaRespiratorio2(0);
			respiratorio.setIndiceDesenhoResp(0);
			respiratorio.setValorRespiratorio("30");
			respiratorio.setVelocidadePlot(15);;
			respiratorio.setVelocidadePlotDesenho(2);			
			respiratorio.setNomeRespiratorio("Taquipneia");
			break;
		
		case "Bradipneia":
			respiratorio.setParametrosResp1(batimentos.getParameters("resBradipneia.txt"));
			respiratorio.setParametrosResp2(null);
			respiratorio.setParametrosResp3(null);
			respiratorio.setRetaRespiratorio(1);
			respiratorio.setRetaRespiratorio1(350);
			respiratorio.setRetaRespiratorio2(0);
			respiratorio.setIndiceDesenhoResp(0);
			respiratorio.setVelocidadePlot(20);
			respiratorio.setVelocidadePlotDesenho(50);
			respiratorio.setValorRespiratorio("08");
			respiratorio.setNomeRespiratorio("Bradipneia");
			break;
		
		case "Apneia":
			respiratorio.setRetaRespiratorio(10);
			respiratorio.setRetaRespiratorio1(10);
			respiratorio.setRetaRespiratorio2(10);
			respiratorio.setIndiceDesenhoResp(0);
			respiratorio.setDesenho(false);
			respiratorio.setValorRespiratorio("0");
			respiratorio.setNomeRespiratorio("Apneia");
			respiratorio.setVelocidadePlot(20);
			break;			
			
			
		case "Cheyne - Stoke":
			respiratorio.setParametrosResp1(batimentos.getParameters("resCheyneStokes.txt"));
			respiratorio.setParametrosResp2(null);
			respiratorio.setParametrosResp3(null);
			respiratorio.setRetaRespiratorio(30);
			respiratorio.setRetaRespiratorio1(0);
			respiratorio.setRetaRespiratorio2(0);
			respiratorio.setIndiceDesenhoResp(0);
			respiratorio.setValorRespiratorio("14");
			respiratorio.setVelocidadePlotDesenho(20);
			respiratorio.setVelocidadePlot(20);
			respiratorio.setNomeRespiratorio("Cheyne - Stoke");
			
			break;
		
		case "Biot's":
			respiratorio.setParametrosResp1(batimentos.getParameters("resBiots.txt"));
			respiratorio.setParametrosResp2(batimentos.getParameters("resBiots2.txt"));
			respiratorio.setParametrosResp3(batimentos.getParameters("resBiots3.txt"));
			respiratorio.setRetaRespiratorio(80);
			respiratorio.setRetaRespiratorio1(80);
			respiratorio.setRetaRespiratorio2(20);
			respiratorio.setIndiceDesenhoResp(0);
			respiratorio.setValorRespiratorio("10");
			respiratorio.setNomeRespiratorio("Biot's");
			respiratorio.setVelocidadePlotDesenho(10);
			respiratorio.setVelocidadePlot(20);
			break;
		
		case "Apneustic":
			respiratorio.setParametrosResp1(batimentos.getParameters("resApneustic.txt"));
			respiratorio.setParametrosResp2(batimentos.getParameters(null));
			respiratorio.setParametrosResp3(batimentos.getParameters(null));
			respiratorio.setRetaRespiratorio(0);
			respiratorio.setRetaRespiratorio1(0);
			respiratorio.setRetaRespiratorio2(0);
			respiratorio.setIndiceDesenhoResp(0);
			respiratorio.setValorRespiratorio("20");
			respiratorio.setNomeRespiratorio("Apneustic");
			respiratorio.setVelocidadePlotDesenho(20);
			break;	
		}
		return respiratorio;
	}
	
	protected void executarGraficoRespiratorio() {
 		threadRespiratorio = new Thread()
 		{
 			@SuppressWarnings("static-access")
 			@Override
 			public void run() 
 			{			
 				//int indiceDesenho = 0;
 				int indiceReta = 0;
 				float plotX;
 				Parametro plot = null;
 				
 				int reta = 0;
 				float valorDesenhoReta;
 				plot = respiratorio.getParametrosResp1().get(respiratorio.getIndiceDesenhoResp());
 				
 			//	 VariÃ¡vel para indicar qual parametro desenhar
 				int par = 1;
 				try 
 				{
 					while (true) 
 					{			
 						Thread.sleep(respiratorio.getVelocidadePlot()); 	 
 						if (respiratorio.isDesenho()) 
 						{	
 							Thread.sleep(respiratorio.getVelocidadePlotDesenho());
 							switch(par){
 							case 1:
 								int totalParametros1 = respiratorio.getParametrosResp1().size();
 								plot = respiratorio.getParametrosResp1().get(respiratorio.getIndiceDesenhoResp());
 								
 								
 								plotX = calcularDesenhoXRespiratorio(respiratorio.getParametrosResp1(), respiratorio.getIndiceDesenhoResp());
 								ctrlPrograma.plotSeriesRitmoRespiratorio(plotX, plot.getY());
 								
 								respiratorio.setResPosicaoX(plotX);						
 								
 								if ((respiratorio.getIndiceDesenhoResp() == totalParametros1 -1))
 								{
 									respiratorio.setDesenho(false);	 									
 									respiratorio.setIndiceDesenhoResp(0);
 									indiceReta = 0;
 									
 									if(respiratorio.getParametrosResp2() != null){
 										par = 2;
 									}
 									else 
 										par = 1;
 								}
 								else
 									respiratorio.setIndiceDesenhoResp(respiratorio.getIndiceDesenhoResp()+1); 									
 								
 								break;
 								
 							case 2:
 								try{
 									int totalParametros2 = respiratorio.getParametrosResp2().size();	 									
 									plot = respiratorio.getParametrosResp2().get(respiratorio.getIndiceDesenhoResp());	 									
 									plotX = calcularDesenhoXRespiratorio(respiratorio.getParametrosResp2(), respiratorio.getIndiceDesenhoResp());	 									
 									ctrlPrograma.plotSeriesRitmoRespiratorio(plotX, plot.getY());
 									respiratorio.setResPosicaoX(plotX);						
 									
 									
 									if ((respiratorio.getIndiceDesenhoResp() == totalParametros2 -1))
 									{
 										respiratorio.setDesenho(false);
 										respiratorio.setIndiceDesenhoResp(0);
 										
 										indiceReta = 0;
 										
 										if(respiratorio.getParametrosResp3() != null){
 											par = 3;
 										}
 										else 
 											par = 1;
 									}
 									else
 										respiratorio.setIndiceDesenhoResp(respiratorio.getIndiceDesenhoResp()+1);
 								}
 								catch(NullPointerException ex){
 									par = 1;
 								}catch(IndexOutOfBoundsException ex){
 									par = 1;
 								}
 								
 								break;
 								
 							case 3:
 								try{
 									int totalParametros3 = respiratorio.getParametrosResp3().size();								
 									plot = respiratorio.getParametrosResp3().get(respiratorio.getIndiceDesenhoResp());									
 									plotX = calcularDesenhoXRespiratorio(respiratorio.getParametrosResp3(), respiratorio.getIndiceDesenhoResp());									
 									ctrlPrograma.plotSeriesRitmoRespiratorio(plotX, plot.getY());
 									respiratorio.setResPosicaoX(plotX);															
 									
 									if ((respiratorio.getIndiceDesenhoResp() == totalParametros3 -1))
 									{
 										respiratorio.setDesenho(false);
 										respiratorio.setIndiceDesenhoResp(0);
 										indiceReta = 0;										
 										par = 1;
 									}
 									else
 										respiratorio.setIndiceDesenhoResp(respiratorio.getIndiceDesenhoResp()+1);
 								
 								}catch(NullPointerException ex){
 									par = 1;					
 								}catch(IndexOutOfBoundsException ex){
 									par = 1;
 								}
 								break;
 							}
 						}
 						else 
 						{	
 							valorDesenhoReta = plot.getY();
 							switch(reta)
 							{				
 							
 							case 0:
 								if(respiratorio.getRetaRespiratorio() == 0)
 									respiratorio.setDesenho(true);
 								
 								if(indiceReta <= respiratorio.getRetaRespiratorio() || respiratorio.getNomeRespiratorio().equals("Apneia")) 
 								{									
 									ctrlPrograma.plotSeriesRitmoRespiratorio(respiratorio.getResPosicaoX(), valorDesenhoReta);
									respiratorio.setResPosicaoX(respiratorio.getResPosicaoX() + (float) 0.1);	
									indiceReta ++;
 								}
 								else{								
 									respiratorio.setDesenho(true);
 								
 									if(respiratorio.getRetaRespiratorio1() != 0)
 										reta = 1;		
 								}
 								
 							break;
 								case 1:
 									if(indiceReta <= respiratorio.getRetaRespiratorio1() || respiratorio.getNomeRespiratorio().equals("Apneia"))
 									{
 										ctrlPrograma.plotSeriesRitmoRespiratorio(respiratorio.getResPosicaoX(), valorDesenhoReta);
										respiratorio.setResPosicaoX(respiratorio.getResPosicaoX() + (float) 0.1);	
										indiceReta ++;
 									}
 									else{								
 										respiratorio.setDesenho(true);
 									
 										if(respiratorio.getRetaRespiratorio2() != 0)
 											reta = 2;		
 									}
 									
 								break;
 								case 2:
 									if(indiceReta <= respiratorio.getRetaRespiratorio2() || respiratorio.getNomeRespiratorio().equals("Apneia"))
 									{										
 										ctrlPrograma.plotSeriesRitmoRespiratorio(respiratorio.getResPosicaoX(), valorDesenhoReta);
										respiratorio.setResPosicaoX(respiratorio.getResPosicaoX() + (float) 0.1);	
										indiceReta ++;
 									}
 									else{		
 										respiratorio.setDesenho(true);
 										reta = 1;
 									}
 									
 								break;
 							}
 						}
 						
 						/**
 						 * SE O GRÃ�FICO CHEGAR AO FINAL DO CHART, VOLTO PARA POSIÃ‡ÃƒO INICIAL
 						 */
 						if (respiratorio.getResPosicaoX() >= 150) 
 						{
 							respiratorio.setResPosicaoX(0);
 							reta = 0;
 							ctrlPrograma.limparSeriesRespiratorio();	
 						}						
 					}
 				} 
 				catch(IndexOutOfBoundsException ex ){
 					System.err.println("Erro ao capiturar o objeto");
 					ex.printStackTrace();
 				}
 				catch (Exception e) 
 				{
 					e.printStackTrace();
 				}
 			}		
 		};
 
 		threadRespiratorio.start(); 
 	}

	/**
	  *  MÉTODO RESPONSÁVEL POR CALCULAR ONDE SERÁ O PLOT DO MEU X A PARTIR DA POSIÇÃO ATUAL DO MEU GRÁFICO
	  * @param parametros
	  * @param indice
	  * @return
	  */
	public float calcularDesenhoXRespiratorio(ArrayList<Parametro> parametros, int indice)
	{
		//Valor que irá retornar no método
		float resultado = 0;
		
		//Valor do meu X para o indice anterior
		float xAnterior = 0;
		
		//Valor do meu X para a posição desejada pelo meu indice
		float xAtual = 0;
		
		//Se o valor do meu indice for 0 o valor da variável X anterior continua sendo 0 
		if(indice == 0)
			xAnterior = 0;
		else
			//Se o valor do indice não for 0, a variável X anterior receberá o valor do indice anterior
			xAnterior = parametros.get(indice - 1).getX();
		
		//X Atual receberá o valor do X do indice desejado
		xAtual = parametros.get(indice).getX();
		
		//A variavel resultado receberar o valor da expressão abaixo
		//Valor da posição X do meu grafico cardiaco atual + Valor da variável X do meu indice - o Valor do X do meu indice anterior
		resultado = ((respiratorio.getResPosicaoX() + xAtual) - xAnterior);
		
		//Retorno do método
		return resultado;		
	}

}