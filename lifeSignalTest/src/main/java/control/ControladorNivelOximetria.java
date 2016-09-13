package control;

import java.util.ArrayList;

import model.Oximetria;
import model.Parametro;

public class ControladorNivelOximetria {
	
	Oximetria oximetria;
	ControladorPrograma ctrlPrograma;
	LeitorBatimentos batimentos = new LeitorBatimentos();
	
	Thread threadOximetria;
	
	static float oxiPosicaoX = 0;
	
	public ControladorNivelOximetria (ControladorPrograma ctrl){
		this.ctrlPrograma = ctrl;
		
	}
	
	/**
	 * MÉTODO RESPONSÁVEL POR RETORNAR UM OBJETO DE OXIMETRIA
	 * @param nome
	 * @return
	 */
	public Oximetria getOximetria(String nome){
		
		oximetria = Oximetria.getOximetria();
		
		oximetria = atualizarParametrosOximetria(nome, oximetria);
		
		return oximetria;
	}

	
	/**
	 * MÉTODOS RESPONSÁVEIS POR DEFINIR OS VALORES DE PARAMETROS DO NÍVEL DE OXIMETRIA
	 */
	@SuppressWarnings("static-access")
	protected Oximetria atualizarParametrosOximetria(String ritmo, Oximetria oximetria) {
		
		switch(ritmo)
		{
		case "Baixa Perfusão":
			oximetria.setIndiceDesenhoOximetria(0);
			oximetria.setParametrosOxi(batimentos.getParameters("oxiBaixaPerfusão.txt"));
			oximetria.setRangeOximetria(322);
			oximetria.setVelocidadePlotOximetria(40);
			oximetria.setValorOximetria("80");
			oximetria.setNomeOximetria("Baixa Perfusão");
			break;

		case "Ruído Artefato":
			oximetria.setIndiceDesenhoOximetria(0);
			oximetria.setParametrosOxi(batimentos.getParameters("oxiRuídoArtefato.txt"));
			oximetria.setRangeOximetria(322);
			oximetria.setVelocidadePlotOximetria(40);
			oximetria.setValorOximetria("0");
			oximetria.setNomeOximetria("Ruído Artefato");
			break;
		
		case "Sinal Normal":
			oximetria.setIndiceDesenhoOximetria(0);
			oximetria.setParametrosOxi(batimentos.getParameters("oxiSinalNormal.txt"));
			oximetria.setRangeOximetria(350);
			oximetria.setVelocidadePlotOximetria(11);
			oximetria.setValorOximetria("95");
			oximetria.setNomeOximetria("Sinal Normal");
			break;		
			
		case "Artefato de Movimento":
			oximetria.setIndiceDesenhoOximetria(0);
			oximetria.setParametrosOxi(batimentos.getParameters("oxiArtefatodeMovimento.txt"));
			oximetria.setRangeOximetria(350);
			oximetria.setVelocidadePlotOximetria(40);
			oximetria.setValorOximetria("0");
			oximetria.setNomeOximetria("Artefato de Movimento");
			break;
		}
		
		return oximetria;
		
	}

	protected void executarGraficoOximetria() {
		threadOximetria = new Thread() {
			@SuppressWarnings("static-access")
			@Override
			public void run() 
			{				
				boolean update = false;	
				float plotX;
				Parametro plotY ;

				try 
				{
					while (true) 
					{					
						Thread.sleep(oximetria.getVelocidadePlotOximetria());
						ctrlPrograma.ajustarRangeOximetria(0, oximetria.getRangeOximetria());						
						int totalParametros = oximetria.getParametrosOxi().size();
												
							if(update){
								plotY = oximetria.getParametrosOxi().get(oximetria.getIndiceDesenhoOximetria());
								plotX = calcularDesenhoXOximetria(oximetria.getParametrosOxi(), oximetria.getIndiceDesenhoOximetria());
								ctrlPrograma.plotSeriesOximetria(plotX, plotY.getY());
								oxiPosicaoX = plotX;
								
								if ((oximetria.getIndiceDesenhoOximetria() == totalParametros -1))
								{
									oximetria.setIndiceDesenhoOximetria(0);
									//indiceDesenhoOximetria = 0;
								}
								else
									oximetria.setIndiceDesenhoOximetria(oximetria.getIndiceDesenhoOximetria()+1);
									//indiceDesenhoOximetria++;
							}
							else
							{
								plotY = oximetria.getParametrosOxi().get(oximetria.getIndiceDesenhoOximetria());	
								ctrlPrograma.plotSeriesOximetria(plotY.getX(), plotY.getY());
								
								oxiPosicaoX = plotY.getX();						
																
								if ((oximetria.getIndiceDesenhoOximetria() == totalParametros -1))
								{
									oximetria.setIndiceDesenhoOximetria(0);
									//indiceDesenhoOximetria = 0;
								}
								else
									oximetria.setIndiceDesenhoOximetria(oximetria.getIndiceDesenhoOximetria()+1);
									//indiceDesenhoOximetria++;
								update = true;
							}
							
						/**
						 * SE O GRÃ�FICO CHEGAR AO FINAL DO CHART, VOLTO PARA POSIÃ‡ÃƒO INICIAL
						 */
						if (oxiPosicaoX >= oximetria.getRangeOximetria() ) 
						{
							update = true;
							oxiPosicaoX = 0;
							ctrlPrograma.limparSeriesOximetria();
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
		threadOximetria.start();
	}
		
	/**
	 * MÉTODO RESPONSÁVEL POR CALCULAR ONDE SERÁ O PLOT DO MEU X A PARTIR DA POSIÇÃO ATUAL DO MEU GRÁFICO
	 * @param parametros
	 * @param indice
	 * @return
	 */
	public float calcularDesenhoXOximetria(ArrayList<Parametro> parametros, int indice)
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
		resultado = ((oxiPosicaoX + xAtual) - xAnterior);
		
		//Retorno do método
		return resultado;		
	}


}
