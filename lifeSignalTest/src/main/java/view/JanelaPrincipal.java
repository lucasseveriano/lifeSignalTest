package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import control.ControladorPrograma;
import control.ControladorRitmoCardiaco;
import control.LeitorBatimentos;
import model.Cardiaco;
import model.Oximetria;
import model.Parametro;
import model.Respiratorio;

public class JanelaPrincipal extends JFrame{

	public JFrame frmMaingraph;
	ControladorPrograma ctrlProg;
	ControladorRitmoCardiaco ctrlRitmoCardiaco;
	
	Cardiaco cardiaco;
	Oximetria oximetria;
	Respiratorio respiratorio;
	
	/**
	 * PONTEIRO PARA AS THREADS
	 */
	public Thread threadCardiaco;
	public Thread threadRespiratorio;
	public Thread threadOximetria;

	/**
	 * ATRIBUTOS REFERÊNTES AO MÉTODO CARDIACO
	 */	
	int indiceDesenho = 0;	
	static float carPosicaoX = 0;
	String nomeRitmoCardiaco;
	//String valorBatimentoCardiaco = "80";
	JComboBox<String> cbxRitmoCardiaco;	
	JLabel lblImgCoracao;	
	JPanel painelCardiaco;
	

	/**
	 * ATRIBUTOS REFERÊNTES AO MÉTODO RESPIRATORIO
	 */
	//double retaRespiratorio = 0;
	int valorRespiratorio = 20;
//	int espessuraLinha = 3;
//	int indiceDesenhoResp = 0;
//	float frequencia = 0; //Quantidade de ciclos no gráfico
//	boolean plotDesenho = false;
	JPanel painelRespiratorio;
	JComboBox<String> cbxRitmoRespiratorio;	
	//private static float resPosicaoX = 0;
	
	
	/**
	 * ATRIBUTOS REFERÊNTES AO MÉTODO DE OXIMETRIA
	 */
	JPanel painelOximetria;	
	JComboBox<String> cbxNivelOximetria;
	int indiceDesenhoOximetria = 0;
	
	
	
	/**
	 * ATRIBUTOS REFERENTES A LEITURA DOS PARAMETROS
	 */
	LeitorBatimentos batimentos;
	
	//private ArrayList<Parametro> parametrosResp1;

	JLabel lbValorCardiaco;	
	JLabel lblValorOximetria;
	JLabel lblValorRespiratorio;
	
	JLabel lblValorMmHg;
	JLabel lblTemperatura1;
	JLabel lblTemperatura2;
	JLabel lblPressaoMaxima;
	JLabel lblPressaoMinima;
	

	/**
	 * MÉTODOS NECESSÁRIOS PARA CRIAÇÃO DOS GRÁFICOS
	 */
	final XYSeries seriesRitmoCardiaco;
	final XYSeries seriesNivelOximetria;
	final XYSeries seriesRitmoRespiratorio;

	XYSeriesCollection datasetRitmoCardiaco;
	XYSeriesCollection datasetRitmoRespiratorio;
	XYSeriesCollection datasetNivelOximetria;

	final JFreeChart chartRitmoCardiaco;
	final JFreeChart chartRitmoRespiratorio;
	final JFreeChart chartNivelOximetria;

	final ChartPanel chartPanelRitmoCardiaco;
	final ChartPanel chartPanelRitmoRespiratorio;
	final ChartPanel chartPanelNivelOximetria;

	XYPlot plotRitmoCardiaco;
	ValueAxis yAxisRitmoCardiaco;
	NumberAxis axisRitmoCardiaco;

	XYPlot plotRitmoRespiratorio;
	ValueAxis yAxisRitmoRespiratorio;
	NumberAxis axisRitmoRespiratorio;
	
	XYPlot plotNivelOximetria;
	ValueAxis yAxisNivelOximetria;
	NumberAxis axisNivelOximetria;

	XYLineAndShapeRenderer renderer;
	
	/**
	 * ATRIBUTOS PARA CONTROLE DA DIMENSÃO DOS GRÁFICOS
	 */
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Dimension scrnSize = toolkit.getScreenSize();	
	int widthTelaComputados = (int) scrnSize.getWidth();
	int heightTelaComputados = (int) scrnSize.getHeight();
		
	
	/**
	 * MÉTODOS CONSTRUTOR DA CLASSE 
	 */
	public JanelaPrincipal(ControladorPrograma ctrl, Cardiaco _cardiaco, Oximetria _oximetria, Respiratorio _respiratorio) {
		
		this.ctrlProg = ctrl;	
		this.cardiaco = _cardiaco;
		this.oximetria = _oximetria;
		this.respiratorio = _respiratorio;

		seriesRitmoCardiaco = new XYSeries("");
		seriesRitmoRespiratorio = new XYSeries("");
		seriesNivelOximetria = new XYSeries("");

		datasetRitmoCardiaco = new XYSeriesCollection(seriesRitmoCardiaco);
		datasetRitmoRespiratorio = new XYSeriesCollection(seriesRitmoRespiratorio);
		datasetNivelOximetria = new XYSeriesCollection(seriesNivelOximetria);

		chartRitmoCardiaco = ChartFactory.createXYLineChart(null, null, null, datasetRitmoCardiaco);
		chartRitmoRespiratorio = ChartFactory.createXYLineChart(null, null, null, datasetRitmoRespiratorio);
		chartNivelOximetria = ChartFactory.createXYLineChart(null, null, null, datasetNivelOximetria);

		chartPanelRitmoCardiaco = new ChartPanel(chartRitmoCardiaco);
		chartPanelRitmoCardiaco.setBounds(0, 10, (widthTelaComputados - 110), 110);
		
		chartPanelRitmoRespiratorio = new ChartPanel(chartRitmoRespiratorio);
		chartPanelRitmoRespiratorio.setBounds(0, 230, (widthTelaComputados - 110), 110);
		
		chartPanelNivelOximetria = new ChartPanel(chartNivelOximetria);
		chartPanelNivelOximetria.setBounds(0, 120, (widthTelaComputados - 110), 110);

		plotRitmoCardiaco = (XYPlot) chartRitmoCardiaco.getPlot();
		yAxisRitmoCardiaco = plotRitmoCardiaco.getRangeAxis();
		axisRitmoCardiaco = (NumberAxis) chartRitmoCardiaco.getXYPlot().getDomainAxis();

		plotRitmoRespiratorio = (XYPlot) chartRitmoRespiratorio.getPlot();
		yAxisRitmoRespiratorio = plotRitmoRespiratorio.getRangeAxis();
		axisRitmoRespiratorio = (NumberAxis) chartRitmoRespiratorio.getXYPlot().getDomainAxis();
		
		
		plotNivelOximetria = (XYPlot) chartNivelOximetria.getPlot();
		yAxisNivelOximetria = plotNivelOximetria.getRangeAxis();
		axisNivelOximetria = (NumberAxis)chartNivelOximetria.getXYPlot().getDomainAxis();		
		

		renderer = new XYLineAndShapeRenderer();
		
		batimentos = new LeitorBatimentos();

		initialize();

	}

	private void initialize() {						
		frmMaingraph = new JFrame();
		frmMaingraph.setIconImage(Toolkit.getDefaultToolkit().getImage(JanelaPrincipal.class.getResource("/img/Heart beat.png")));
		frmMaingraph.getContentPane().setBackground(Color.BLACK);
		frmMaingraph.setBackground(Color.BLACK);
		frmMaingraph.setTitle("Live Signal Java");
		frmMaingraph.setSize((int)scrnSize.getWidth(), (int)scrnSize.getHeight());
		//frmMaingraph.setBounds(0, 0, 1200, 680);
		frmMaingraph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMaingraph.getContentPane().setLayout(null);
		frmMaingraph.setExtendedState(JFrame.MAXIMIZED_BOTH);


		/**
		 * CONFIGURAÇÃO DO RITMO CARDIACO
		 */
		chartRitmoCardiaco.setBackgroundPaint(Color.BLACK);// setando a cor do gráfico
		chartRitmoCardiaco.removeLegend(); // Remove a legenda		
		chartPanelRitmoCardiaco.setBackground(Color.BLACK); //setando a cor do painel
		
		chartPanelRitmoCardiaco.setPopupMenu(null); //retirando o meni
		chartPanelRitmoCardiaco.setMouseZoomable(false); //retirando o zoom
		
		yAxisRitmoCardiaco.setRange(-1, 4); // Define o tamanho do eixo Y
		yAxisRitmoCardiaco.setVisible(false); // Remove a barra do eixo Y

		plotRitmoCardiaco.setBackgroundPaint(Color.BLACK); // Define a cor de fundo
		plotRitmoCardiaco.setDomainGridlinesVisible(false); // Remove as linhas do eixo x
		plotRitmoCardiaco.setRangeGridlinesVisible(false); // Remove as linhas do eixo y

		axisRitmoCardiaco.setRange(0, 322); // Define o tamanho do eixo X
		axisRitmoCardiaco.setVisible(false); // Remove a barra do eixo X

		plotRitmoCardiaco.getRenderer().setSeriesPaint(0, Color.decode("#00CD00")); // Alterando a cor do Gráfico para Verde
		plotRitmoCardiaco.getRenderer().setSeriesStroke(0, new BasicStroke(3)); // Alterando a Largura do gráfico
		
		frmMaingraph.getContentPane().add(chartPanelRitmoCardiaco); //adicionando o gráfico na tela inicial

		/**
		 * CONFIGURAÇÃO DO RITMO RESPIRATORIO
		 */
		chartRitmoRespiratorio.setBackgroundPaint(Color.BLACK);// setando a cor do gráfico
		chartRitmoRespiratorio.removeLegend(); // Remove a legenda
		
		chartPanelRitmoRespiratorio.setBackground(Color.BLACK); //setando a cor de fundo do painel
		chartPanelRitmoRespiratorio.setMouseZoomable(false); //retirando o zoom
		chartPanelRitmoRespiratorio.setPopupMenu(null); //retirando o menu
		
		yAxisRitmoRespiratorio.setRange(-3, 3.4); // Define o tamanho do eixo Y
		yAxisRitmoRespiratorio.setVisible(false); // Remove a barra do eixo Y

		axisRitmoRespiratorio.setRange(0, 150); // Define o tamanho do eixo X
		axisRitmoRespiratorio.setVisible(false); // Remove a barra do eixo X

		plotRitmoRespiratorio.setBackgroundPaint(Color.BLACK); // Define a cor de fundo
		plotRitmoRespiratorio.setDomainGridlinesVisible(false); // Remove as linhas do eixo x
		plotRitmoRespiratorio.setRangeGridlinesVisible(false); // Remove as linhas do eixo y

		plotRitmoRespiratorio.getRenderer().setSeriesPaint(0, Color.WHITE);
		plotRitmoRespiratorio.getRenderer().setSeriesStroke(0, new BasicStroke(2));
		
		frmMaingraph.getContentPane().add(chartPanelRitmoRespiratorio);
		
		
		/**
		 * CONFIGURAÇÃO DO NÍVEL DE OXIMETRIA
		 */
		chartNivelOximetria.setBackgroundPaint(Color.BLACK); //Setando a cor do gráfico
		chartNivelOximetria.removeLegend(); //Removendo a legenda
		
		chartPanelNivelOximetria.setBackground(Color.BLACK); //Adicionando a cor de fundo do painel
		chartPanelNivelOximetria.setMouseZoomable(false); //Retirando o zoom
		chartPanelNivelOximetria.setPopupMenu(null); //Retirando o menu
		
		yAxisNivelOximetria.setRange(-1, 4); //Definindo o tamanho do eixo Y
		yAxisNivelOximetria.setVisible(false); //Removendo a barrado eixo Y
		
		axisNivelOximetria.setRange(0, 322); //Define o tamanho do eixo X
		axisNivelOximetria.setVisible(false); //Remove a barra do eixo X
		
		plotNivelOximetria.setBackgroundPaint(Color.BLACK); //Define a cor de fundo
		plotNivelOximetria.setDomainGridlinesVisible(false); //Remove as linhas do eixo X
		plotNivelOximetria.setRangeGridlinesVisible(false); //RRemove as linhas do eixo Y
		
		plotNivelOximetria.getRenderer().setSeriesPaint(0, Color.decode("#00BFFF"));
		plotNivelOximetria.getRenderer().setSeriesStroke(0, new BasicStroke(2));
		
		frmMaingraph.getContentPane().add(chartPanelNivelOximetria);
		
		
		/**
		 * COMPONENTES DO PAINEL
		 */

		painelCardiaco = new JPanel();
		painelCardiaco.setBounds( (widthTelaComputados - 110), 10, 103, 110);
		painelCardiaco.setBackground(Color.BLACK);
		frmMaingraph.getContentPane().add(painelCardiaco);
		painelCardiaco.setLayout(null);
		
		lblImgCoracao = new JLabel("");
		lblImgCoracao.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/img/hearts20.png")));
		lblImgCoracao.setBounds(69, 11, 46, 24);
		painelCardiaco.add(lblImgCoracao);

		lbValorCardiaco = new JLabel();
		lbValorCardiaco.setText("80");
		lbValorCardiaco.setForeground(Color.GREEN);
		lbValorCardiaco.setBackground(Color.BLACK);
		lbValorCardiaco.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lbValorCardiaco.setBounds(10, 11, 83, 47);
		painelCardiaco.add(lbValorCardiaco);

		JLabel lblBpm = new JLabel("BPM");
		lblBpm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBpm.setForeground(Color.GREEN);
		lblBpm.setBounds(20, 52, 46, 14);
		painelCardiaco.add(lblBpm);
				
		painelOximetria = new JPanel();
		painelOximetria.setLayout(null);
		painelOximetria.setBackground(Color.BLACK);
		painelOximetria.setBounds( (widthTelaComputados - 110), 123, 103, 110);
		frmMaingraph.getContentPane().add(painelOximetria);
		
		lblValorOximetria = new JLabel("100");
		lblValorOximetria.setForeground(new Color(70, 130, 180));
		lblValorOximetria.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblValorOximetria.setBackground(Color.BLACK);
		lblValorOximetria.setBounds(10, 11, 89, 47);
		painelOximetria.add(lblValorOximetria);
		
		JLabel lblSPO2 = new JLabel("SPO2");
		lblSPO2.setForeground(new Color(70, 130, 180));
		lblSPO2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSPO2.setBounds(20, 52, 46, 14);
		painelOximetria.add(lblSPO2);

		painelRespiratorio = new JPanel();
		painelRespiratorio.setLayout(null);
		painelRespiratorio.setBackground(Color.BLACK);
		painelRespiratorio.setBounds((widthTelaComputados - 110), 230, 103, 110);
		frmMaingraph.getContentPane().add(painelRespiratorio);
		
		lblValorRespiratorio = new JLabel(Integer.toString(valorRespiratorio));
		lblValorRespiratorio.setForeground(Color.WHITE);
		lblValorRespiratorio.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblValorRespiratorio.setBackground(Color.BLACK);
		lblValorRespiratorio.setBounds(10, 11, 89, 47);
		painelRespiratorio.add(lblValorRespiratorio);
				
		JLabel lblRESP = new JLabel("RESP");
		lblRESP.setForeground(Color.WHITE);
		lblRESP.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblRESP.setBounds(20, 52, 46, 14);
		painelRespiratorio.add(lblRESP);
		
		JPanel painelMenu = new JPanel();
		painelMenu.setBackground(Color.BLACK);
		painelMenu.setBounds(30, 666, 840, 52);
		frmMaingraph.getContentPane().add(painelMenu);
		painelMenu.setLayout(null);
		
		
		JPanel panelTemperatura = new JPanel();
		panelTemperatura.setBackground(Color.BLACK);
		panelTemperatura.setBounds(911, 617, 176, 84);
		frmMaingraph.getContentPane().add(panelTemperatura);
		panelTemperatura.setLayout(null);
		
		lblTemperatura1 = new JLabel("36");
		lblTemperatura1.setBounds(0, 0, 74, 84);
		panelTemperatura.add(lblTemperatura1);
		lblTemperatura1.setFont(new Font("Dialog", Font.BOLD, 50));
		lblTemperatura1.setForeground(Color.YELLOW);
		
		JLabel label = new JLabel(",");
		label.setBounds(63, 0, 18, 84);
		panelTemperatura.add(label);
		label.setForeground(Color.YELLOW);
		label.setFont(new Font("Dialog", Font.BOLD, 50));
		label.setBackground(Color.WHITE);
		
		lblTemperatura2 = new JLabel("0");
		lblTemperatura2.setBounds(74, 0, 74, 84);
		panelTemperatura.add(lblTemperatura2);
		lblTemperatura2.setFont(new Font("Dialog", Font.BOLD, 50));
		lblTemperatura2.setForeground(Color.YELLOW);
		
		JLabel lblc = new JLabel("ºC");
		lblc.setBounds(114, 0, 91, 84);
		panelTemperatura.add(lblc);
		lblc.setForeground(Color.YELLOW);
		lblc.setFont(new Font("Dialog", Font.BOLD, 50));
		lblc.setBackground(Color.WHITE);
		
		JPanel panelPressao = new JPanel();
		panelPressao.setLayout(null);
		panelPressao.setBackground(Color.BLACK);
		panelPressao.setBounds(1110, 600, 228, 118);
		frmMaingraph.getContentPane().add(panelPressao);
		
		lblValorMmHg = new JLabel("93");
		lblValorMmHg.setForeground(Color.RED);
		lblValorMmHg.setFont(new Font("Dialog", Font.BOLD, 30));
		lblValorMmHg.setBackground(Color.WHITE);
		lblValorMmHg.setBounds(145, 52, 110, 84);
		panelPressao.add(lblValorMmHg);
		
		lblPressaoMaxima = new JLabel("120");
		lblPressaoMaxima.setForeground(Color.RED);
		lblPressaoMaxima.setFont(new Font("Dialog", Font.BOLD, 50));
		lblPressaoMaxima.setBounds(12, 0, 101, 84);
		panelPressao.add(lblPressaoMaxima);
		
		JLabel label_3 = new JLabel("/");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Dialog", Font.BOLD, 50));
		label_3.setBackground(Color.WHITE);
		label_3.setBounds(115, 0, 18, 84);
		panelPressao.add(label_3);
		
		lblPressaoMinima = new JLabel("80");
		lblPressaoMinima.setForeground(Color.RED);
		lblPressaoMinima.setFont(new Font("Dialog", Font.BOLD, 50));
		lblPressaoMinima.setBounds(143, 0, 77, 84);
		panelPressao.add(lblPressaoMinima);
		
		JLabel lblMmhg = new JLabel("mmHg");
		lblMmhg.setForeground(Color.RED);
		lblMmhg.setFont(new Font("Dialog", Font.BOLD, 30));
		lblMmhg.setBackground(Color.WHITE);
		lblMmhg.setBounds(23, 52, 110, 84);
		panelPressao.add(lblMmhg);
		
		JLabel label_2 = new JLabel("(        )");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Dialog", Font.BOLD, 30));
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(125, 54, 84, 84);
		panelPressao.add(label_2);
		
		JButton btnCarregar = new JButton("Carregar");
		btnCarregar.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/img/open.png")));
		btnCarregar.setBounds(352, 12, 118, 27);
		painelMenu.add(btnCarregar);
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctrlProg.carregarDados();						
			}
		});
								
	
		
		JButton btnAbrirJanelaAluno = new JButton("Abrir Janela Aluno");
		btnAbrirJanelaAluno.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/img/openinwindow.png")));
		btnAbrirJanelaAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ctrlProg.abrirJanelaAluno(ctrlProg);
			}
		});
		btnAbrirJanelaAluno.setBounds(482, 12, 162, 26);
		painelMenu.add(btnAbrirJanelaAluno);
		
		JButton btnFecharJanelaAluno = new JButton("Fechar Janela Aluno");
		btnFecharJanelaAluno.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/img/closewindow.png")));
		btnFecharJanelaAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlProg.fecharJanelaAluno();
			}
		});
		btnFecharJanelaAluno.setBounds(656, 12, 169, 26);
		painelMenu.add(btnFecharJanelaAluno);
		
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/img/settings.png")));
		btnMenu.setBounds(127, 12, 98, 26);
		painelMenu.add(btnMenu);
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctrlProg.abrirMenu();
			}
		});
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/img/save.png")));
		btnSalvar.setBounds(237, 12, 103, 26);
		painelMenu.add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlProg.salvarDados();
			}
		});
		
		final JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/img/play.png")));
		btnIniciar.setBounds(12, 12, 103, 27);
		//btnIniciar.setIcon(arg0);
		painelMenu.add(btnIniciar);
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				ctrlProg.instanciarObjetos();
				ctrlProg.executarGraficoCardiaco();
				ctrlProg.executarGraficoRespiratorio();
				ctrlProg.executarGraficoOximetria();
				btnIniciar.setEnabled(false);
			}
		});
		
	}
	
	 /**
	  *  MÉTODO RESPONSÁVEL POR PLOTAR OS MESMOS VALORES QUE ESTÃO SENDO PLOTADOS
	  * @param x
	  * @param y
	  */
	public void plotCardiaco(float x, float y) {
		seriesRitmoCardiaco.add(x, y);
	}
	
	
	 /** 
	  * RESPONSÁVEL POR LIMPAR O GRÁFICO QUANDO O PLOT CHEGA AO FIM DA TELA
	  */
	public void clearCardiaco(){
		seriesRitmoCardiaco.clear();
	}

	
	/**
	 * MÉTODO RESPONSÁVEL POR PLOTAR OS MESMOS VALORES QUE ESTÃO SENDO PLOTADOS
	 * NA JANELA PRINCIPAL
	 * 
	 * @param x
	 * @param y
	 */
	public void plotRespiratorio(float x, float y) {
		seriesRitmoRespiratorio.add(x, y);
	}
	
	/** 
	  * RESPONSÁVEL POR LIMPAR O GRÁFICO QUANDO O PLOT CHEGA AO FIM DA TELA
	  */
	public void clearRespiratorio(){
		seriesRitmoRespiratorio.clear();
	}
	
	/**
	 * MÉTODO RESPONSÁVEL POR PLOTAR OS MESMOS VALORES QUE ESTÃO SENDO PLOTADOS
	 * NA JANELA PRINCIPAL
	 * 
	 * @param x
	 * @param y
	 */
	public void plotOximetria(float x, float y) {
		seriesNivelOximetria.add(x, y);
	}
	
	/** 
	  * RESPONSÁVEL POR LIMPAR O GRÁFICO QUANDO O PLOT CHEGA AO FIM DA TELA
	  */
	public void clearOximetria(){
		seriesNivelOximetria.clear();
	}
	
	
	/**
	 * MÉTODO RESPONSÁVEL POR AJUSTAR O TAMANHO DA RETA PELOS BATIMENTOS
	 * @param retaAtual
	 * @param batimentoAnterior
	 * @param batimentoAtual
	 * @return
	 */
	public int ajustarReta(int retaAtual, int batimentoAnterior, int batimentoAtual)
	{	
		int btm1 = batimentoAnterior;
		int btm2 = batimentoAtual;
		int reta1 = retaAtual;
		int reta2;
		
		reta2 = (btm1 * reta1) / batimentoAtual;
		
		return reta2;
	}

	public void setLbValorCardiaco(String valor) {
		this.lbValorCardiaco.setText(valor);
	}

	public void setLblValorOximetria(String valor) {
		this.lblValorOximetria.setText(valor);
	}

	public void setLblValorRespiratorio(String valor) {
		this.lblValorRespiratorio.setText(valor);
	}

	public void setLblValorMmHg(String valor) {
		this.lblValorMmHg.setText(valor);
	}

	public void setLblTemperatura1(String valor) {
		this.lblTemperatura1.setText(valor);
	}

	public void setLblTemperatura2(String valor) {
		this.lblTemperatura2.setText(valor);
	}

	public void setLblPressaoMaxima(String valor) {
		this.lblPressaoMaxima.setText(valor);
	}

	public String getLblTemperatura1() {
		return lblTemperatura1.getText();
	}
	
	public String getLblTemperatura2() {
		return lblTemperatura2.getText();
	}
	
	public void setLblPressaoMinima(String valor) {
		this.lblPressaoMinima.setText(valor);
	}

	public JLabel getLblValorMmHg() {
		return lblValorMmHg;
	}

	public void setLblValorMmHg(JLabel lblValorMmHg) {
		this.lblValorMmHg = lblValorMmHg;
	}

	public String getLblPressaoMaxima() {
		return lblPressaoMaxima.getText();
	}

	public String getLblPressaoMinima() {
		return lblPressaoMinima.getText();
	}

	public void setRagneOximetria(int i, float rangeOximetria) {
		axisNivelOximetria.setRange(i, rangeOximetria); // Define o tamanho do eixo X
	}

	

	
	

	
	
	
}
