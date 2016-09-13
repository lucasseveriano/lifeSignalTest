package control;

import java.util.ArrayList;

import model.Cardiaco;
import model.Parametro;

public class ControladorRitmoCardiaco {
		
	Cardiaco cardiaco;	
	ControladorPrograma ctrlPrograma;
	
	Thread threadCardiaco;
	
	static float carPosicaoX = 0;
	
	LeitorBatimentos batimentos = new LeitorBatimentos();
		
	
	/**
	 * MÉTODO CONSTRUTOR DA CLASSE
	 * @param ctrlPrograma
	 */
	public ControladorRitmoCardiaco(ControladorPrograma ctrlPrograma){
			this.ctrlPrograma = ctrlPrograma;
		
	}
	
	/**
	 * MÉTODO RESPONSÁVEL POR RETORNAR UM OBJETO CARDÍACO
	 * @param nome
	 * @return
	 */
	public Cardiaco getCardiaco(String nome){
		
		cardiaco = Cardiaco.getCardiaco();
		
		cardiaco = atualizarParametrosCardiaco(nome, cardiaco);
		
		return cardiaco;
	}
	
	/**
	 * MÉTODOS RESPONSÁVEIS POR DEFINIR OS VALORES DE PARAMETROS DO RITMO CARDÍACO
	 */
	@SuppressWarnings("static-access")
	private Cardiaco atualizarParametrosCardiaco(String ritmo, Cardiaco cardiaco) {
		
		switch(ritmo)
		{
		case "Ritmo Sinusal":
			cardiaco.setRetaCardiaco0(10);
			cardiaco.setRetaCardiaco1(12);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("60");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carRitmoSinusal.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);
			cardiaco.setNomeCardiaco("Ritmo Sinusal");
			break;			
			

		case "Bradicardia Sinusal":
			cardiaco.setRetaCardiaco0(10);
			cardiaco.setRetaCardiaco1(12);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("40");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carBradicardiaSinusal.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);
			cardiaco.setNomeCardiaco("Bradicardia Sinusal");
			break;

		case "Taquicardia Sinusal":
			cardiaco.setRetaCardiaco0(10);
			cardiaco.setRetaCardiaco1(9);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("130");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carTaquicardiaSinusal.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);
			cardiaco.setNomeCardiaco("Taquicardia Sinusal");
			break;

		case "Arritimia Sinusal":
			cardiaco.setRetaCardiaco0(10);
			cardiaco.setRetaCardiaco1(9);
			cardiaco.setRetaCardiaco2(20);
			cardiaco.setRetaCardiaco3(20);
			cardiaco.setRetaCardiaco4(9);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("75");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carArritmiaSinusal.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);	
			cardiaco.setNomeCardiaco("Arritimia Sinusal");
			break;

		case "Bloqueio Sinoauricula":
			cardiaco.setRetaCardiaco0(10);
			cardiaco.setRetaCardiaco1(7);
			cardiaco.setRetaCardiaco2(37);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("50");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carBloqueioSinoauricula.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);	
			cardiaco.setNomeCardiaco("Bloqueio Sinoauricula");
			break;

		case "Pausa Sinusal":
			cardiaco.setRetaCardiaco0(10);
			cardiaco.setRetaCardiaco1(8);
			cardiaco.setRetaCardiaco2(70);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("60");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carPausaSinusal.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);	
			cardiaco.setNomeCardiaco("Pausa Sinusal");
			break;

		case "Ritmo Sinusal Com Extrassistoles Supraventriculares":
			cardiaco.setRetaCardiaco0(3);
			cardiaco.setRetaCardiaco1(22);
			cardiaco.setRetaCardiaco2(8);
			cardiaco.setRetaCardiaco3(8);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("80");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carRitmoSinusalComExtrassistolesSupraventricularesPR1.txt"));
			cardiaco.setParametrosCar2(batimentos.getParameters("carRitmoSinusalComExtrassistolesSupraventricularesPR2.txt"));
			cardiaco.setParametrosCar3(batimentos.getParameters("carRitmoSinusalComExtrassistolesSupraventricularesPR2.txt"));
			cardiaco.setParametrosCar4(null);		
			cardiaco.setNomeCardiaco("Ritmo Sinusal Com Extrassistoles Supraventriculares");
			break;

		case "Tarquicardia Supraventricular":
			cardiaco.setRetaCardiaco0(2);
			cardiaco.setRetaCardiaco1(5);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("150");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carTarquicardiaSupraventricular.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);
			cardiaco.setNomeCardiaco("Tarquicardia Supraventricular");
			break;

		case "Fibrilação Auricular":			
			cardiaco.setRetaCardiaco0(0);
			cardiaco.setRetaCardiaco1(0);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("150");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carFibrilaçãoAuricular.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);
			cardiaco.setNomeCardiaco("Fibrilação Auricular");
			break;

		case "Fluter Auricular":
			cardiaco.setRetaCardiaco0(0);
			cardiaco.setRetaCardiaco1(0);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("180");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carFluterAuricular.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);
			cardiaco.setNomeCardiaco("Fluter Auricular");
			break;

		case "Sídrome de Wolff-Parkinson-White":
			cardiaco.setRetaCardiaco0(2);
			cardiaco.setRetaCardiaco1(11);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("60");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carSídromeDeWolff-Parkinson-White.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);
			cardiaco.setNomeCardiaco("Sídrome de Wolff-Parkinson-White");
			break;

		case "Bloqueio Auriculo Ventricular de 1º Grau":
			cardiaco.setRetaCardiaco0(15);
			cardiaco.setRetaCardiaco1(15);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("60");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carBloqueioAuriculoVentricularDe1Grau.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);	
			cardiaco.setNomeCardiaco("Bloqueio Auriculo Ventricular de 1º Grau");
			break;

		case "Bloqueio Auriculo Ventricular de 2º Grau Tipo 2":
			cardiaco.setRetaCardiaco0(6);
			cardiaco.setRetaCardiaco1(17);
			cardiaco.setRetaCardiaco2(17);
			cardiaco.setRetaCardiaco3(40);
			cardiaco.setRetaCardiaco4(43);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("90");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carBloqueioAuriculoVentricularDe2GrauTipo2PR1.txt"));
			cardiaco.setParametrosCar2(batimentos.getParameters("carBloqueioAuriculoVentricularDe2GrauTipo2PR1.txt"));
			cardiaco.setParametrosCar3(batimentos.getParameters("carBloqueioAuriculoVentricularDe2GrauTipo2PR2.txt"));
			cardiaco.setParametrosCar4(batimentos.getParameters("carBloqueioAuriculoVentricularDe2GrauTipo2PR4.txt"));	
			cardiaco.setNomeCardiaco("Bloqueio Auriculo Ventricular de 2º Grau Tipo 2");
			break;

		case "Ritmo Sinusal com Extrassistoles Juncionais":
			cardiaco.setRetaCardiaco0(6);
			cardiaco.setRetaCardiaco1(13);
			cardiaco.setRetaCardiaco2(13);
			cardiaco.setRetaCardiaco3(26);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("65");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carRitmoSinusalComExtrassistolesJuncionaisPR1.txt"));
			cardiaco.setParametrosCar2(batimentos.getParameters("carRitmoSinusalComExtrassistolesJuncionaisPR1.txt"));
			cardiaco.setParametrosCar3(batimentos.getParameters("carRitmoSinusalComExtrassistolesJuncionaisPR2.txt"));
			cardiaco.setParametrosCar4(null);
			cardiaco.setNomeCardiaco("Ritmo Sinusal com Extrassistoles Juncionais");
			break;

		case "Ritmo Juncional":
			cardiaco.setRetaCardiaco0(26);
			cardiaco.setRetaCardiaco1(50);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("60");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carRitmoJuncional.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);
			cardiaco.setNomeCardiaco("Ritmo Juncional");
			break;

		case "Ritmo Juncional Acelerado":
			cardiaco.setRetaCardiaco0(5);
			cardiaco.setRetaCardiaco1(16);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("60");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carRitmoJuncionalAcelerado.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);
			cardiaco.setNomeCardiaco("Ritmo Juncional Acelerado");
			break;

		case "Marcapasso Errante":
			cardiaco.setRetaCardiaco0(7);
			cardiaco.setRetaCardiaco1(26);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("75");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carMarcapassoErrantePR1.txt"));
			cardiaco.setParametrosCar2(batimentos.getParameters("carMarcapassoErrantePR1.txt"));
			cardiaco.setParametrosCar3(batimentos.getParameters("carMarcapassoErrantePR2.txt"));
			cardiaco.setParametrosCar4(batimentos.getParameters("carMarcapassoErrantePR2.txt"));
			cardiaco.setNomeCardiaco("Marcapasso Errante");
			break;
			
		case "Tarquicardia Juncional":
			cardiaco.setRetaCardiaco0(7);
			cardiaco.setRetaCardiaco1(13);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("130");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carTarquicardiaJuncional.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);
			cardiaco.setNomeCardiaco("Tarquicardia Juncional");
			break;

		case "Ritmo Sinusal com Extrassistoles Venticulares":
			cardiaco.setRetaCardiaco0(10);
			cardiaco.setRetaCardiaco1(10);
			cardiaco.setRetaCardiaco2(10);
			cardiaco.setRetaCardiaco3(8);
			cardiaco.setRetaCardiaco4(12);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("65");
			cardiaco.setVelocidadeDesenhoCardiaco(60);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carRitmoSinusalComExtrassistolesVenticularesPR1.txt"));
			cardiaco.setParametrosCar2(batimentos.getParameters("carRitmoSinusalComExtrassistolesVenticularesPR1.txt"));
			cardiaco.setParametrosCar3(batimentos.getParameters("carRitmoSinusalComExtrassistolesVenticularesPR1.txt"));
			cardiaco.setParametrosCar4(batimentos.getParameters("carRitmoSinusalComExtrassistolesVenticularesPR2.txt"));
			cardiaco.setNomeCardiaco("Ritmo Sinusal com Extrassistoles Venticulares");
			break;

		case "Ritmo Idioventricular":
			cardiaco.setRetaCardiaco0(7);
			cardiaco.setRetaCardiaco1(52);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("60");
			cardiaco.setVelocidadeDesenhoCardiaco(20);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carRitmoIdioventricular.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);
			cardiaco.setNomeCardiaco("Ritmo Idioventricular");
			break;

		case "Ritmo Idioventricular Acelerado":
			cardiaco.setRetaCardiaco0(7);
			cardiaco.setRetaCardiaco1(30);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("60");
			cardiaco.setVelocidadeDesenhoCardiaco(20);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carRitmoIdioventricularAcelerado.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);
			cardiaco.setNomeCardiaco("Ritmo Idioventricular Acelerado");
			break;

		case "Taquicardia Ventricular":
			cardiaco.setRetaCardiaco0(0);
			cardiaco.setRetaCardiaco1(0);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("170");
			cardiaco.setVelocidadeDesenhoCardiaco(20);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carTarquicardiaVentricular.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);
			cardiaco.setNomeCardiaco("Taquicardia Ventricular");
			break;

		case "Fibrilação Ventricular":
			cardiaco.setRetaCardiaco0(0);
			cardiaco.setRetaCardiaco1(0);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("0");
			cardiaco.setVelocidadeDesenhoCardiaco(15);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carFibrilaçãoVentricular.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);
			cardiaco.setNomeCardiaco("Fibrilação Ventricular");
			break;

		case "Assistolia":
			cardiaco.setRetaCardiaco0(0);
			cardiaco.setRetaCardiaco1(0);
			cardiaco.setRetaCardiaco2(0);
			cardiaco.setRetaCardiaco3(0);
			cardiaco.setRetaCardiaco4(0);
			cardiaco.setIndiceDesenho(0);
			cardiaco.setValorBatimentoCardiaco("0");
			cardiaco.setVelocidadeDesenhoCardiaco(15);
			cardiaco.setVelocidadeRetaCardiaco(60);
			cardiaco.setParametrosCar1(batimentos.getParameters("carAssistolia.txt"));
			cardiaco.setParametrosCar2(null);
			cardiaco.setParametrosCar3(null);
			cardiaco.setParametrosCar4(null);
			cardiaco.setNomeCardiaco("Assistolia");
			break;
		}
		return cardiaco;
	}

	/**
	 * MÉTODO RESPONSÁVEL POR EXECUTAR O PLOT DO RITMO CARDIACO
	 * ATRAVÉS DESTE MÉTODO SAI A POSIÇÃO EM QUE SERÁ DESENHADO NO GRAFICO DA JANELA PRINCIPAL E JANELA SECUNDÁRIA
	 */
	protected void executarGraficoCardiaco() {
		threadCardiaco = new Thread() 
		{
			@SuppressWarnings("static-access")
			@Override
			public void run() 
			{			
				boolean desenho = false;
				int indiceReta = 0;				
				float plotX;				
				Parametro plot;				
				int reta = 0;								
				int par = 1; //VariÃ¡vel para indicar qual parametro desenhar

				try 
				{					
					while (true) 
					{				
						if (desenho) 
						{		
							Thread.sleep(cardiaco.getVelocidadeDesenhoCardiaco()); 
							
							switch(par){
							
							case 1:
								int totalParametros1 = cardiaco.getParametrosCar1().size();								
								//lblImgCoracao.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/img/hearts30.png")));
								
								plot = cardiaco.getParametrosCar1().get(cardiaco.getIndiceDesenho());
								plotX = calcularDesenhoXCardiaco(cardiaco.getParametrosCar1(), cardiaco.getIndiceDesenho());	
								
								ctrlPrograma.plotSeriesCardiaco(plotX, plot.getY());
								
								carPosicaoX = plotX;													
								
								if ((cardiaco.getIndiceDesenho() == totalParametros1 -1))
								{
									desenho = false;	
									cardiaco.setIndiceDesenho(0);
									//indiceDesenho = 0;									
									indiceReta = 0;			
									par = cardiaco.getParametrosCar2() != null ? 2 : 1;
								}								
								else if ((cardiaco.getIndiceDesenho() == totalParametros1 -1) && cardiaco.getRetaCardiaco0() != 0){
									desenho = true;
								}									
								else
									cardiaco.setIndiceDesenho(cardiaco.getIndiceDesenho()+1);
									//indiceDesenho++;								
								break;
								
							case 2:
								try{
									int totalParametros2 = cardiaco.getParametrosCar2().size();									
									//lblImgCoracao.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/img/hearts30.png")));
									
									plot = cardiaco.getParametrosCar2().get(cardiaco.getIndiceDesenho());									
									plotX = calcularDesenhoXCardiaco(cardiaco.getParametrosCar2(), cardiaco.getIndiceDesenho());
									
									ctrlPrograma.plotSeriesCardiaco(plotX, plot.getY());
									
									carPosicaoX = plotX;				
									
									if ((cardiaco.getIndiceDesenho() == totalParametros2 -1))
									{
										desenho = false;		
										cardiaco.setIndiceDesenho(0);
										//indiceDesenho = 0;										
										indiceReta = 0;										
										par = cardiaco.getParametrosCar3() != null ?  3 : 1;
									}
									else
										cardiaco.setIndiceDesenho(cardiaco.getIndiceDesenho()+1);
										//indiceDesenho++;
								}
								catch(NullPointerException ex){
									par = 1;
								}catch(IndexOutOfBoundsException ex){
									par = 1;
								}								
								break;
								
							case 3:
								try{
									int totalParametros3 = cardiaco.getParametrosCar3().size();
									//lblImgCoracao.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/img/hearts30.png")));	
									
									plot = cardiaco.getParametrosCar3().get(cardiaco.getIndiceDesenho());									
									plotX = calcularDesenhoXCardiaco(cardiaco.getParametrosCar3(), cardiaco.getIndiceDesenho());
									
									ctrlPrograma.plotSeriesCardiaco(plotX, plot.getY());
									
									carPosicaoX = plotX;															
									
									if ((cardiaco.getIndiceDesenho() == totalParametros3 -1))
									{
										desenho = false;
										cardiaco.setIndiceDesenho(0);
										//indiceDesenho = 0;										
										indiceReta = 0;										
										par = cardiaco.getParametrosCar4() != null ? 4 : 1;
									}
									else
										cardiaco.setIndiceDesenho(cardiaco.getIndiceDesenho()+1);
										//indiceDesenho++;
									
								}catch(NullPointerException ex){
									par = 1;
								}catch(IndexOutOfBoundsException ex){
									par = 1;
								}								
								break;
								
							case 4:
								try{
									int totalParametros4 = cardiaco.getParametrosCar4().size();								
									//lblImgCoracao.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/img/hearts30.png")));		
									
									plot = cardiaco.getParametrosCar4().get(cardiaco.getIndiceDesenho());									
									plotX = calcularDesenhoXCardiaco(cardiaco.getParametrosCar4(), cardiaco.getIndiceDesenho());	
									
									ctrlPrograma.plotSeriesCardiaco(plotX, plot.getY());
									
									carPosicaoX = plotX;															
									
									if ((cardiaco.getIndiceDesenho() == totalParametros4 -1))
									{
										desenho = false;		
										cardiaco.setIndiceDesenho(0);
										//indiceDesenho = 0;										
										indiceReta = 0;										
										par = 1;
									}
									else
										cardiaco.setIndiceDesenho(cardiaco.getIndiceDesenho()+1);
										//indiceDesenho++;
								
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
							Thread.sleep(cardiaco.getVelocidadeRetaCardiaco());  
							
							switch(reta)
							{				
														
							case 0:
								if(cardiaco.getRetaCardiaco0() == 0)
									desenho = true;
								
								else if(indiceReta <= cardiaco.getRetaCardiaco0())
								{
									//lblImgCoracao.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/img/hearts20.png")));	
									ctrlPrograma.plotSeriesCardiaco(carPosicaoX, 0);
									carPosicaoX++;										
									indiceReta++;								}
								else
								{								
									desenho = true;
									reta = cardiaco.getRetaCardiaco1() != 0 ? 1 : 1;
								}
								
							break;
							
								case 1:
									if(indiceReta <= cardiaco.getRetaCardiaco1())
									{
										//lblImgCoracao.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/img/hearts20.png")));										
										ctrlPrograma.plotSeriesCardiaco(carPosicaoX, 0);
										carPosicaoX++;											
										indiceReta++;
									}
									else{								
										desenho = true;	
										reta = cardiaco.getRetaCardiaco2() != 0 ? 2 : 1;
									}
									
								break;
								
								case 2:
									if(indiceReta <= cardiaco.getRetaCardiaco2())
									{
										//lblImgCoracao.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/img/hearts20.png")));
										ctrlPrograma.plotSeriesCardiaco(carPosicaoX, 0);
										carPosicaoX++;											
										indiceReta++;
									}
									else
									{									
										desenho = true;											
										reta = cardiaco.getRetaCardiaco3() != 0 ? 3 : 1;										
									}
									
								break;
								
								case 3:
									if(indiceReta <= cardiaco.getRetaCardiaco3())
									{
										//lblImgCoracao.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/img/hearts20.png")));										
										ctrlPrograma.plotSeriesCardiaco(carPosicaoX, 0);
										carPosicaoX++;											
										indiceReta++;
									}
									else
									{						
										desenho = true;									
										reta = cardiaco.getRetaCardiaco4() != 0 ? 4 : 1;
									}
									
								break;
								
								case 4:
									if(indiceReta<= cardiaco.getRetaCardiaco4())
									{
										//lblImgCoracao.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/img/hearts20.png")));										
										ctrlPrograma.plotSeriesCardiaco(carPosicaoX, 0);
										carPosicaoX++;											
										indiceReta++;
									}
									else
									{						
										desenho = true;
										reta = 1;
									}																		
								break;
							}
						}
						
						/**
						 * SE O GRÃ�FICO CHEGAR AO FINAL DO CHART, VOLTO PARA POSIÃ‡ÃƒO INICIAL
						 */
						if (carPosicaoX >= 322) 
						{
							carPosicaoX = 0;
							reta = 0;
							ctrlPrograma.limparSeriesCardiaco();
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

		threadCardiaco.start(); 
	}

	/**
	 * MÉTODO RESPONSÁVEL POR CALCULAR ONDE SERÁ O PLOT DO MEU X A PARTIR DA POSIÇÃO ATUAL DO MEU GRÁFICO
	 * @param parametros
	 * @param indice
	 * @return
	 */
	public float calcularDesenhoXCardiaco(ArrayList<Parametro> parametros, int indice)
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
		resultado = ((carPosicaoX + xAtual) - xAnterior);
		
		//Retorno do método
		return resultado;		
	}
	
}
