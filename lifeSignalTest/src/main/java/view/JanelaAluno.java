package view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

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
import control.LeitorBatimentos;

public class JanelaAluno extends JFrame {

	private JPanel painelPrincipal;
	public JPanel painelCentral;
	public JPanel painelCardiaco;
	public JPanel painelOximetria;
	public JPanel painelRespiratorio;

	JLabel lblValorRespiratorio;
	JLabel lblValorOximetria;
	JLabel lbValorCardiaco;
	
	
	JLabel lblValorMmHg;
	JLabel lblTemperatura1;
	JLabel lblTemperatura2;
	JLabel lblPressaoMaxima;
	JLabel lblPressaoMinima;

	/**
	 * ATRIBUTOS REFERENTES A LEITURA DOS PARAMETROS
	 */
	LeitorBatimentos batimentos;
	
	/**
	 * MÉTODOS NECESSÁRIOS PARA CRIAÇÃO DOS GRÁFICOS
	 */
	XYSeries seriesRitmoCardiaco;
	XYSeries seriesNivelOximetria;
	XYSeries seriesRitmoRespiratorio;

	XYSeriesCollection datasetRitmoCardiaco;
	XYSeriesCollection datasetRitmoRespiratorio;
	XYSeriesCollection datasetNivelOximetria;

	JFreeChart chartRitmoCardiaco;
	JFreeChart chartRitmoRespiratorio;
	JFreeChart chartNivelOximetria;

	ChartPanel chartPanelRitmoCardiaco;
	ChartPanel chartPanelRitmoRespiratorio;
	ChartPanel chartPanelNivelOximetria;

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
	
	ControladorPrograma ctrlProg;

	/**
	 * ATRIBUTOS PARA CONTROLE DA DIMENSÃO DOS GRÁFICOS
	 */
	static Toolkit toolkit;
	static Dimension scrnSize;
	static int widthTelaComputados;
	static int heightTelaComputados;

	public JanelaAluno(ControladorPrograma ctrlPrograma) {	
		this.ctrlProg = ctrlPrograma;

		setTitle("LIVE SIGNAL - UNIGRANRIO");
		setIconImage(Toolkit.getDefaultToolkit().getImage(JanelaAluno.class.getResource("/img/Heart beat.png")));
		setBackground(Color.BLACK);
		setBounds(100, 100, 1086, 573);
		painelPrincipal = new JPanel();
		painelPrincipal.setBackground(Color.BLACK);
		painelPrincipal.setBorder(new EmptyBorder(0, 0, 0, 0));
		painelPrincipal.setLayout(new BorderLayout(0, 0));
		setContentPane(painelPrincipal);
		setExtendedState(MAXIMIZED_BOTH);

		JPanel painelDireito = new JPanel();
		painelDireito.setBackground(Color.BLACK);
		painelPrincipal.add(painelDireito, BorderLayout.EAST);

		JPanel painelValorCardiaco = new JPanel();
		painelValorCardiaco.setBackground(Color.BLACK);

		JPanel painelValorOximetria = new JPanel();
		painelValorOximetria.setBackground(Color.BLACK);

		JPanel painelValorRespiratorio = new JPanel();
		painelValorRespiratorio.setBackground(Color.BLACK);

		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.BLACK);

		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.BLACK);

		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.BLACK);
		GroupLayout gl_painelDireito = new GroupLayout(painelDireito);
		gl_painelDireito
				.setHorizontalGroup(gl_painelDireito.createParallelGroup(Alignment.LEADING)
						.addComponent(painelValorCardiaco, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
						.addComponent(painelValorOximetria, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
						.addComponent(painelValorRespiratorio, GroupLayout.PREFERRED_SIZE, 122,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel3, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE));
		gl_painelDireito
				.setVerticalGroup(
						gl_painelDireito.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_painelDireito.createSequentialGroup()
										.addComponent(painelValorCardiaco, GroupLayout.DEFAULT_SIZE, 77,
												Short.MAX_VALUE)
										.addGap(6)
										.addComponent(painelValorOximetria, GroupLayout.DEFAULT_SIZE, 69,
												Short.MAX_VALUE)
										.addGap(6)
										.addComponent(painelValorRespiratorio, GroupLayout.DEFAULT_SIZE, 75,
												Short.MAX_VALUE)
										.addGap(6).addComponent(panel1, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
										.addGap(6).addComponent(panel2, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
										.addGap(6)
										.addComponent(panel3, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)));
		panel3.setLayout(null);
		panel2.setLayout(null);
		panel1.setLayout(null);
		painelValorRespiratorio.setLayout(null);

		lblValorRespiratorio = new JLabel("20");
		lblValorRespiratorio.setForeground(Color.WHITE);
		lblValorRespiratorio.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblValorRespiratorio.setBackground(Color.BLACK);
		lblValorRespiratorio.setBounds(12, 1, 89, 47);
		painelValorRespiratorio.add(lblValorRespiratorio);

		JLabel lblRESP = new JLabel("RESP");
		lblRESP.setForeground(Color.WHITE);
		lblRESP.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRESP.setBounds(36, 48, 46, 14);
		painelValorRespiratorio.add(lblRESP);
		painelValorOximetria.setLayout(null);

		lblValorOximetria = new JLabel("100");
		lblValorOximetria.setForeground(new Color(70, 130, 180));
		lblValorOximetria.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblValorOximetria.setBackground(Color.BLACK);
		lblValorOximetria.setBounds(12, 0, 89, 47);
		painelValorOximetria.add(lblValorOximetria);

		JLabel lblSPO2 = new JLabel("SPO2");
		lblSPO2.setForeground(new Color(70, 130, 180));
		lblSPO2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSPO2.setBounds(36, 48, 46, 14);
		painelValorOximetria.add(lblSPO2);
		painelValorCardiaco.setLayout(null);

		JLabel lblImgCoracao = new JLabel("");
		lblImgCoracao.setIcon(new ImageIcon(JanelaAluno.class.getResource("/img/hearts30.png")));
		lblImgCoracao.setBounds(76, 12, 46, 24);
		painelValorCardiaco.add(lblImgCoracao);

		lbValorCardiaco = new JLabel();
		lbValorCardiaco.setText("80");
		lbValorCardiaco.setForeground(Color.GREEN);
		lbValorCardiaco.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lbValorCardiaco.setBackground(Color.BLACK);
		lbValorCardiaco.setBounds(12, 0, 83, 47);
		painelValorCardiaco.add(lbValorCardiaco);

		JLabel lblBpm = new JLabel("BPM");
		lblBpm.setForeground(Color.GREEN);
		lblBpm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBpm.setBounds(36, 48, 46, 14);
		painelValorCardiaco.add(lblBpm);
		painelDireito.setLayout(gl_painelDireito);

		painelCentral = new JPanel();
		painelCentral.setBackground(Color.BLACK);
		painelPrincipal.add(painelCentral, BorderLayout.CENTER);

		painelCardiaco = new JPanel();
		painelCardiaco.setBackground(Color.BLACK);

		painelOximetria = new JPanel();
		painelOximetria.setBackground(Color.BLACK);

		painelRespiratorio = new JPanel();
		painelRespiratorio.setBackground(Color.BLACK);

		JPanel painel1 = new JPanel();
		painel1.setBackground(Color.BLACK);

		JPanel painel2 = new JPanel();
		painel2.setBackground(Color.BLACK);

		JPanel painel3 = new JPanel();
		painel3.setBackground(Color.BLACK);
		GroupLayout gl_painelCentral = new GroupLayout(painelCentral);
		gl_painelCentral.setHorizontalGroup(gl_painelCentral.createParallelGroup(Alignment.LEADING)
				.addComponent(painelCardiaco, GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
				.addComponent(painelOximetria, GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
				.addComponent(painelRespiratorio, GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
				.addComponent(painel1, GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
				.addComponent(painel2, GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
				.addComponent(painel3, GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE));
		gl_painelCentral
				.setVerticalGroup(
						gl_painelCentral
								.createParallelGroup(
										Alignment.LEADING)
								.addGroup(
										gl_painelCentral.createSequentialGroup()
												.addComponent(painelCardiaco, GroupLayout.DEFAULT_SIZE, 76,
														Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(painelOximetria, GroupLayout.DEFAULT_SIZE, 70,
														Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(painelRespiratorio, GroupLayout.DEFAULT_SIZE, 73,
														Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(painel1, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(painel2, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(painel3, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)));
		painelCentral.setLayout(gl_painelCentral);

		JPanel painelBotoes = new JPanel();
		painelBotoes.setBackground(Color.BLACK);
		painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

		JPanel painelAdicional = new JPanel();
		painelAdicional.setBackground(Color.BLACK);
		GroupLayout gl_painelBotoes = new GroupLayout(painelBotoes);
		gl_painelBotoes.setHorizontalGroup(
			gl_painelBotoes.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_painelBotoes.createSequentialGroup()
					.addContainerGap(168, Short.MAX_VALUE)
					.addComponent(painelAdicional, GroupLayout.PREFERRED_SIZE, 902, GroupLayout.PREFERRED_SIZE))
		);
		gl_painelBotoes.setVerticalGroup(
			gl_painelBotoes.createParallelGroup(Alignment.LEADING)
				.addComponent(painelAdicional, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
		);

		JPanel painelTemperatura = new JPanel();
		painelTemperatura.setBackground(Color.BLACK);
		painelTemperatura.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblTemperatura1 = new JLabel("36");
		lblTemperatura1.setForeground(Color.YELLOW);
		lblTemperatura1.setFont(new Font("Dialog", Font.BOLD, 40));
		painelTemperatura.add(lblTemperatura1);

		JLabel label_8 = new JLabel(",");
		label_8.setForeground(Color.YELLOW);
		label_8.setFont(new Font("Dialog", Font.BOLD, 40));
		label_8.setBackground(Color.WHITE);
		painelTemperatura.add(label_8);

		lblTemperatura2 = new JLabel("0");
		lblTemperatura2.setForeground(Color.YELLOW);
		lblTemperatura2.setFont(new Font("Dialog", Font.BOLD, 40));
		painelTemperatura.add(lblTemperatura2);

		JLabel label_10 = new JLabel("\u00BAC");
		label_10.setForeground(Color.YELLOW);
		label_10.setFont(new Font("Dialog", Font.BOLD, 40));
		label_10.setBackground(Color.WHITE);
		painelTemperatura.add(label_10);

		JPanel painelPressao = new JPanel();
		painelPressao.setBackground(Color.BLACK);
		painelPressao.setLayout(null);

		lblPressaoMaxima = new JLabel("120");
		lblPressaoMaxima.setBounds(12, 0, 67, 37);
		lblPressaoMaxima.setForeground(Color.RED);
		lblPressaoMaxima.setFont(new Font("Dialog", Font.BOLD, 35));
		painelPressao.add(lblPressaoMaxima);

		JLabel label_12 = new JLabel("/");
		label_12.setForeground(Color.RED);
		label_12.setFont(new Font("Dialog", Font.BOLD, 35));
		label_12.setBackground(Color.WHITE);
		label_12.setBounds(79, -8, 18, 52);
		painelPressao.add(label_12);

		lblPressaoMinima = new JLabel("80");
		lblPressaoMinima.setForeground(Color.RED);
		lblPressaoMinima.setFont(new Font("Dialog", Font.BOLD, 35));
		lblPressaoMinima.setBounds(101, -3, 59, 43);
		painelPressao.add(lblPressaoMinima);

		JLabel lblMmhg = new JLabel("mmHg");
		lblMmhg.setForeground(Color.RED);
		lblMmhg.setFont(new Font("Dialog", Font.BOLD, 25));
		lblMmhg.setBackground(Color.WHITE);
		lblMmhg.setBounds(12, 24, 110, 52);
		painelPressao.add(lblMmhg);

		lblValorMmHg = new JLabel("93");
		lblValorMmHg.setBounds(103, 32, 63, 37);
		painelPressao.add(lblValorMmHg);
		lblValorMmHg.setForeground(Color.RED);
		lblValorMmHg.setFont(new Font("Dialog", Font.BOLD, 25));
		lblValorMmHg.setBackground(Color.WHITE);

		JLabel label_16 = new JLabel("(      )");
		label_16.setForeground(Color.RED);
		label_16.setFont(new Font("Dialog", Font.BOLD, 25));
		label_16.setBackground(Color.WHITE);
		label_16.setBounds(89, 12, 71, 72);
		painelPressao.add(label_16);
		GroupLayout gl_painelAdicional = new GroupLayout(painelAdicional);
		gl_painelAdicional.setHorizontalGroup(
			gl_painelAdicional.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelAdicional.createSequentialGroup()
					.addContainerGap()
					.addComponent(painelTemperatura, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
					.addComponent(painelPressao, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addGap(459))
		);
		gl_painelAdicional.setVerticalGroup(
			gl_painelAdicional.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelAdicional.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_painelAdicional.createParallelGroup(Alignment.LEADING)
						.addComponent(painelPressao, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addComponent(painelTemperatura, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)))
		);
		painelAdicional.setLayout(gl_painelAdicional);
		painelBotoes.setLayout(gl_painelBotoes);

		
		iniciarParametros();
		
		
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
		painelCardiaco.setLayout(null);
		
		painelCardiaco.add(chartPanelRitmoCardiaco); //adicionando o gráfico na tela inicial

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
		painelRespiratorio.setLayout(null);
		
		painelRespiratorio.add(chartPanelRitmoRespiratorio);
		
		
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
		painelOximetria.setLayout(null);
		
		painelOximetria.add(chartPanelNivelOximetria);	
				
	}

	private void iniciarParametros() {
		
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
		FlowLayout flowLayout = (FlowLayout) chartPanelRitmoCardiaco.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		chartPanelRitmoRespiratorio = new ChartPanel(chartRitmoRespiratorio);
		chartPanelRitmoRespiratorio.setBounds(0, 0, 0, 0);

		chartPanelNivelOximetria = new ChartPanel(chartNivelOximetria);
		chartPanelNivelOximetria.setBounds(0, 0, 0, 0);

		plotRitmoCardiaco = (XYPlot) chartRitmoCardiaco.getPlot();
		yAxisRitmoCardiaco = plotRitmoCardiaco.getRangeAxis();
		axisRitmoCardiaco = (NumberAxis) chartRitmoCardiaco.getXYPlot().getDomainAxis();

		plotRitmoRespiratorio = (XYPlot) chartRitmoRespiratorio.getPlot();
		yAxisRitmoRespiratorio = plotRitmoRespiratorio.getRangeAxis();
		axisRitmoRespiratorio = (NumberAxis) chartRitmoRespiratorio.getXYPlot().getDomainAxis();

		plotNivelOximetria = (XYPlot) chartNivelOximetria.getPlot();
		yAxisNivelOximetria = plotNivelOximetria.getRangeAxis();																																																										
		axisNivelOximetria = (NumberAxis) chartNivelOximetria.getXYPlot().getDomainAxis();

		renderer = new XYLineAndShapeRenderer();

		batimentos = new LeitorBatimentos();

	}
	
	
	public void exibeTelaSec() {
		int opcTela = 0;
		
		String tela = ctrlProg.getTelaAluno();
		
		if(tela == "Primeira Tela"){
			opcTela = 0;
		}
		else if(tela == "Segunda Tela"){
			opcTela = 1;
		}		
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] devices = ge.getScreenDevices();
		 
		devices[opcTela].setFullScreenWindow(this);
		int xx = (int) this.getLocation().getX();
		int yy = (int) this.getLocation().getY();
		devices[opcTela].setFullScreenWindow(null);
		this.setLocation(xx, yy);
		this.setVisible(true);		
	}

	private static void pegarTela() {

		toolkit = Toolkit.getDefaultToolkit();
		scrnSize = toolkit.getScreenSize();
		widthTelaComputados = (int) scrnSize.getWidth();
		heightTelaComputados = (int) scrnSize.getHeight();
//
//		this.setSize(widthTelaComputados, heightTelaComputados);
//		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}

	
	
	public void plotCardiaco(float x, float y) {
		chartPanelRitmoCardiaco.setBounds(0, 0, painelCentral.getWidth(), painelCardiaco.getHeight());
		seriesRitmoCardiaco.add(x, y);
	}

	public void plotOximetria(float x, float y) {
		chartPanelNivelOximetria.setBounds(0, 0, painelCentral.getWidth(), painelOximetria.getHeight());
		seriesNivelOximetria.add(x, y);
	}
	
	public void plotRespiratorio(float x, float y){
		chartPanelRitmoRespiratorio.setBounds(0, 0, painelCentral.getWidth(), painelRespiratorio.getHeight());
		seriesRitmoRespiratorio.add(x, y);
	}

	public void ajustarPainelRitmoCardiaco(int width, int height){
		chartPanelRitmoCardiaco.setBounds(0, 0, width, height);
	}
	
	public void ajustarPainelNivelOximetria(int width, int height){
		chartPanelNivelOximetria.setBounds(0, 0, width, height);
	}
	
	public void ajustarPainelRitmoResporatorio(int width, int height){
		chartPanelRitmoRespiratorio.setBounds(0, 0, width, height);
	}
	
	
	 /** 
	  * RESPONSÁVEL POR LIMPAR O GRÁFICO QUANDO O PLOT CHEGA AO FIM DA TELA
	  */
	public void clearSeriesCardiaco(){
		seriesRitmoCardiaco.clear();
	}
	
	public void clearSeriesOximetria(){
		seriesNivelOximetria.clear();
	}
	
	public void clearSeriesRespiratorio(){
		seriesRitmoRespiratorio.clear();
	}

	public void setRangeOximetria(int i, float rangeOximetria) {
		axisNivelOximetria.setRange(i, rangeOximetria);
	}
		


	//
	// Get's e Set's
	//
	public JLabel getLblValorRespiratorio() {
		return lblValorRespiratorio;
	}

	public void setLblValorRespiratorio(String lblValorRespiratorio) {
		this.lblValorRespiratorio.setText(lblValorRespiratorio);
	}

	public JLabel getLblValorOximetria() {
		return lblValorOximetria;
	}

	public void setLblValorOximetria(String lblValorOximetria) {
		this.lblValorOximetria.setText(lblValorOximetria);
	}

	public JLabel getLbValorCardiaco() {
		return lbValorCardiaco;
	}

	public void setLbValorCardiaco(String lbValorCardiaco) {
		this.lbValorCardiaco.setText(lbValorCardiaco);
	}

	public JLabel getLblTemperatura1() {
		return lblTemperatura1;
	}

	public void setLblTemperatura1(String lblTemperatura1) {
		this.lblTemperatura1.setText(lblTemperatura1);
	}

	public JLabel getLblTemperatura2() {
		return lblTemperatura2;
	}

	public void setLblTemperatura2(String lblTemperatura2) {
		this.lblTemperatura2.setText(lblTemperatura2);
	}

	public JLabel getLblValorMmHg() {
		return lblValorMmHg;
	}

	public void setLblValorMmHg(String lblValorMmHg) {
		this.lblValorMmHg.setText(lblValorMmHg);
	}

	public JLabel getLblPressaoMaxima() {
		return lblPressaoMaxima;
	}

	public void setLblPressaoMaxima(String lblPressaoMaxima) {
		this.lblPressaoMaxima.setText(lblPressaoMaxima);
	}

	public JLabel getLblPressaoMinima() {
		return lblPressaoMinima;
	}

	public void setLblPressaoMinima(String lblPressaoMinima) {
		this.lblPressaoMinima.setText(lblPressaoMinima);
	}

}
