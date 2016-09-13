package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.GrayFilter;
import javax.swing.ImageIcon;
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
import model.Respiratorio;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;

public class JanelaSecundaria {

	public static JFrame frmAluno;
	JPanel painelOximetria;
	JPanel painelRespiratorio;
	JPanel painelCardiaco;

	JLabel lbValorCardiaco;
	JLabel lblValorOximetria;
	JLabel lblValorRespiratorio;
	JLabel lblValorMmHg;
	JLabel lblTemperatura1;
	JLabel lblTemperatura2;
	JLabel lblPressaoMaxima;
	JLabel lblPressaoMinima;
	JLabel lblImgCoracao;

	LeitorBatimentos batimentos;

	ControladorPrograma ctrlProg;
	ControladorRitmoCardiaco ctrlRitmoCardiaco;

	Cardiaco cardiaco;
	Oximetria oximetria;
	Respiratorio respiratorio;

	/**
	 * MÉTODOS NECESSÁRIOS PARA CRIAÇÃO DOS GRÁFICOS
	 */
	public final XYSeries seriesRitmoCardiaco;
	public final XYSeries seriesNivelOximetria;
	public final XYSeries seriesRitmoRespiratorio;

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
	static Toolkit toolkit = Toolkit.getDefaultToolkit();
	static Dimension scrnSize = toolkit.getScreenSize();
	static int widthTelaComputados = (int) scrnSize.getWidth();
	static int heightTelaComputados = (int) scrnSize.getHeight();

	
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
		 
		devices[opcTela].setFullScreenWindow(frmAluno);
		int xx = (int) frmAluno.getLocation().getX();
		int yy = (int) frmAluno.getLocation().getY();
		devices[opcTela].setFullScreenWindow(null);
		frmAluno.setLocation(xx, yy);
		frmAluno.setVisible(true);

		pegarTela();
	}

	private static void pegarTela() {

		toolkit = Toolkit.getDefaultToolkit();
		scrnSize = toolkit.getScreenSize();
		widthTelaComputados = (int) scrnSize.getWidth();
		heightTelaComputados = (int) scrnSize.getHeight();

		frmAluno.setSize(widthTelaComputados, heightTelaComputados);
		frmAluno.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}

	/**
	 * MÉTODOS CONSTRUTOR DA CLASSE
	 */
	public JanelaSecundaria(ControladorPrograma ctrl, Cardiaco _cardiaco, Oximetria _oximetria,
			Respiratorio _respiratorio) {

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
		chartPanelRitmoCardiaco.setBounds(0, 10, 500, 110);

		chartPanelRitmoRespiratorio = new ChartPanel(chartRitmoRespiratorio);
		chartPanelRitmoRespiratorio.setBounds(0, 230, 1256, 110);

		chartPanelNivelOximetria = new ChartPanel(chartNivelOximetria);
		chartPanelNivelOximetria.setBounds(0, 120, 1256, 110);

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

		initialize();

	}

	private void initialize() {
		frmAluno = new JFrame();
		frmAluno.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmAluno.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmAluno.setIconImage(Toolkit.getDefaultToolkit().getImage(JanelaSecundaria.class.getResource("/img/Heart beat.png")));
		frmAluno.getContentPane().setBackground(Color.BLACK);
		frmAluno.setBackground(Color.BLACK);
		frmAluno.setTitle("Live Signal Java");
		frmAluno.setUndecorated(true);
		frmAluno.getContentPane().setLayout(null);

		/**
		 * CONFIGURAÇÃO DO RITMO CARDIACO
		 */
		chartRitmoCardiaco.setBackgroundPaint(Color.BLACK);// setando a cor do gráfico
		chartRitmoCardiaco.removeLegend(); // Remove a legenda
		chartPanelRitmoCardiaco.setBackground(Color.BLACK); // setando a cor dopainel

		chartPanelRitmoCardiaco.setPopupMenu(null); // retirando o menu
		chartPanelRitmoCardiaco.setMouseZoomable(false); // retirando o zoom

		yAxisRitmoCardiaco.setRange(-1, 4); // Define o tamanho do eixo Y
		yAxisRitmoCardiaco.setVisible(false); // Remove a barra do eixo Y

		plotRitmoCardiaco.setBackgroundPaint(Color.BLACK); // Define a cor de fundo
		plotRitmoCardiaco.setDomainGridlinesVisible(false); // Remove as linhas do eixo x
		plotRitmoCardiaco.setRangeGridlinesVisible(false); // Remove as linhas do eixo y

		axisRitmoCardiaco.setRange(0, 322); // Define o tamanho do eixo X
		axisRitmoCardiaco.setVisible(false); // Remove a barra do eixo X

		plotRitmoCardiaco.getRenderer().setSeriesPaint(0, Color.decode("#00CD00")); // Alterando a cor do Gráfico para Verde
		plotRitmoCardiaco.getRenderer().setSeriesStroke(0, new BasicStroke(3)); // Alterando a Largura do gráfico
		frmAluno.getContentPane().setLayout(null);

		frmAluno.getContentPane().add(chartPanelRitmoCardiaco); // Adicionando o gráfico na tela inicial

		/**
		 * CONFIGURAÇÃO DO RITMO RESPIRATORIO
		 */
		chartRitmoRespiratorio.setBackgroundPaint(Color.BLACK);// Setando a cor do gráfico
		chartRitmoRespiratorio.removeLegend(); // Remove a legenda

		chartPanelRitmoRespiratorio.setBackground(Color.BLACK); // Setando a cor de fundo do painel
		chartPanelRitmoRespiratorio.setMouseZoomable(false); // retirando o zoom
		chartPanelRitmoRespiratorio.setPopupMenu(null); // retirando o menu

		yAxisRitmoRespiratorio.setRange(-3, 3.4); // Define o tamanho do eixo Y
		yAxisRitmoRespiratorio.setVisible(false); // Remove a barra do eixo Y

		axisRitmoRespiratorio.setRange(0, 150); // Define o tamanho do eixo X
		axisRitmoRespiratorio.setVisible(false); // Remove a barra do eixo X

		plotRitmoRespiratorio.setBackgroundPaint(Color.BLACK); // Define a cor de fundo
		plotRitmoRespiratorio.setDomainGridlinesVisible(false); // Remove a linhas do eixo x
		plotRitmoRespiratorio.setRangeGridlinesVisible(false); // Remove as linhas do eixo y

		plotRitmoRespiratorio.getRenderer().setSeriesPaint(0, Color.WHITE);
		plotRitmoRespiratorio.getRenderer().setSeriesStroke(0, new BasicStroke(2));

		frmAluno.getContentPane().add(chartPanelRitmoRespiratorio);

		/**
		 * CONFIGURAÇÃO DO NÍVEL DE OXIMETRIA
		 */
		chartNivelOximetria.setBackgroundPaint(Color.BLACK); // Setando a cor do gráfico
		chartNivelOximetria.removeLegend(); // Removendo a legenda

		chartPanelNivelOximetria.setBackground(Color.BLACK); // Adicionando a cor de fundo do painel
		chartPanelNivelOximetria.setMouseZoomable(false); // Retirando o zoom
		chartPanelNivelOximetria.setPopupMenu(null); // Retirando o menu

		yAxisNivelOximetria.setRange(-1, 4); // Definindo o tamanho do eixo Y
		yAxisNivelOximetria.setVisible(false); // Removendo a barrado eixo Y

		axisNivelOximetria.setRange(0, 322); // Define o tamanho do eixo X
		axisNivelOximetria.setVisible(false); // Remove a barra do eixo X

		plotNivelOximetria.setBackgroundPaint(Color.BLACK); // Define a cor de fundo
		plotNivelOximetria.setDomainGridlinesVisible(false); // Remove as linhas do eixo X
		plotNivelOximetria.setRangeGridlinesVisible(false); // Remove as linhas do eixo Y

		plotNivelOximetria.getRenderer().setSeriesPaint(0, Color.decode("#00BFFF"));
		plotNivelOximetria.getRenderer().setSeriesStroke(0, new BasicStroke(2));

		frmAluno.getContentPane().add(chartPanelNivelOximetria);

		/**
		 * COMPONENTES DO PAINEL
		 */

		painelCardiaco = new JPanel();
		painelCardiaco.setBounds(1256, 10, 103, 110);
		painelCardiaco.setBackground(Color.BLACK);
		frmAluno.getContentPane().add(painelCardiaco);
		painelCardiaco.setLayout(null);

		lblImgCoracao = new JLabel("");
		lblImgCoracao.setIcon(new ImageIcon(JanelaSecundaria.class.getResource("/img/hearts20.png")));
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
		painelOximetria.setBounds(1256, 123, 103, 110);
		painelOximetria.setLayout(null);
		painelOximetria.setBackground(Color.BLACK);
		frmAluno.getContentPane().add(painelOximetria);

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
		painelRespiratorio.setBounds(1256, 230, 103, 110);
		painelRespiratorio.setLayout(null);
		painelRespiratorio.setBackground(Color.BLACK);
		frmAluno.getContentPane().add(painelRespiratorio);

		lblValorRespiratorio = new JLabel("20");
		lblValorRespiratorio.setForeground(Color.WHITE);
		lblValorRespiratorio.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblValorRespiratorio.setBackground(Color.BLACK);
		lblValorRespiratorio.setBounds(10, 11, 89, 47);
		painelRespiratorio.add(lblValorRespiratorio);

		JLabel LblRESP = new JLabel("RESP");
		LblRESP.setForeground(Color.WHITE);
		LblRESP.setFont(new Font("Tahoma", Font.BOLD, 14));
		LblRESP.setBounds(20, 52, 46, 14);
		painelRespiratorio.add(LblRESP);

		JPanel panelTemperatura = new JPanel();
		panelTemperatura.setBounds(324, 572, 238, 84);
		panelTemperatura.setBackground(Color.BLACK);
		frmAluno.getContentPane().add(panelTemperatura);
		panelTemperatura.setLayout(null);

		lblTemperatura1 = new JLabel("36");
		lblTemperatura1.setBounds(0, 0, 74, 84);
		panelTemperatura.add(lblTemperatura1);
		lblTemperatura1.setFont(new Font("Dialog", Font.BOLD, 66));
		lblTemperatura1.setForeground(Color.WHITE);

		JLabel label = new JLabel(",");
		label.setBounds(70, 0, 18, 84);
		panelTemperatura.add(label);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.BOLD, 66));
		label.setBackground(Color.WHITE);

		lblTemperatura2 = new JLabel("0");
		lblTemperatura2.setBounds(86, 0, 74, 84);
		panelTemperatura.add(lblTemperatura2);
		lblTemperatura2.setFont(new Font("Dialog", Font.BOLD, 66));
		lblTemperatura2.setForeground(Color.WHITE);

		JLabel lblc = new JLabel("ºC");
		lblc.setBounds(150, 0, 88, 84);
		panelTemperatura.add(lblc);
		lblc.setForeground(Color.WHITE);
		lblc.setFont(new Font("Dialog", Font.BOLD, 66));
		lblc.setBackground(Color.WHITE);

		JPanel panelPressao = new JPanel();
		panelPressao.setBounds(754, 562, 283, 118);
		panelPressao.setLayout(null);
		panelPressao.setBackground(Color.BLACK);
		frmAluno.getContentPane().add(panelPressao);

		lblValorMmHg = new JLabel("93");
		lblValorMmHg.setForeground(Color.WHITE);
		lblValorMmHg.setFont(new Font("Dialog", Font.BOLD, 30));
		lblValorMmHg.setBackground(Color.WHITE);
		lblValorMmHg.setBounds(175, 54, 110, 84);
		panelPressao.add(lblValorMmHg);

		lblPressaoMaxima = new JLabel("120");
		lblPressaoMaxima.setForeground(Color.WHITE);
		lblPressaoMaxima.setFont(new Font("Dialog", Font.BOLD, 66));
		lblPressaoMaxima.setBounds(12, 0, 123, 84);
		panelPressao.add(lblPressaoMaxima);

		JLabel label_3 = new JLabel("/");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Dialog", Font.BOLD, 66));
		label_3.setBackground(Color.WHITE);
		label_3.setBounds(131, 0, 18, 84);
		panelPressao.add(label_3);

		lblPressaoMinima = new JLabel("80");
		lblPressaoMinima.setForeground(Color.WHITE);
		lblPressaoMinima.setFont(new Font("Dialog", Font.BOLD, 66));
		lblPressaoMinima.setBounds(161, 0, 96, 84);
		panelPressao.add(lblPressaoMinima);

		JLabel lblMmhg = new JLabel("mmHg");
		lblMmhg.setForeground(Color.WHITE);
		lblMmhg.setFont(new Font("Dialog", Font.BOLD, 30));
		lblMmhg.setBackground(Color.WHITE);
		lblMmhg.setBounds(53, 52, 110, 84);
		panelPressao.add(lblMmhg);

		JLabel label_2 = new JLabel("(        )");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Dialog", Font.BOLD, 30));
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(155, 52, 84, 84);
		panelPressao.add(label_2);
	}

	/**
	 * MÉTODO RESPONSÁVEL POR PLOTAR OS MESMOS VALORES QUE ESTÃO SENDO PLOTADOS
	 * NA JANELA PRINCIPAL
	 * 
	 * @param x
	 * @param y
	 */
	public void plotCardiaco(float x, float y) {
		seriesRitmoCardiaco.add(x, y);
	}
	
	public void clearCardiaco(){
		seriesRitmoCardiaco.clear();
	}
	
	public void clearRespiratorio() {
		seriesRitmoRespiratorio.clear();
	}

	/**
	 * MÉTODO RESPONSÁVEL POR PLOTAR OS MESMOS VALORES QUE ESTÃO SENDO PLOTADOS
	 * NA JANELA PRINCIPAL ALÉM DE PLOTAR, VERIFICA O TAMANHO DO RANGE
	 * NECESSÁRIO PARA O GRÁFICO DE OXIMETRIA
	 * 
	 * @param x
	 * @param y
	 */
	@SuppressWarnings("static-access")
	public void plotOximetria(float x, float y) {
		axisNivelOximetria.setRange(0, oximetria.getRangeOximetria());
		seriesNivelOximetria.add(x, y);
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
	
	

	public JLabel getLblValorMmHg() {
		return lblValorMmHg;
	}

	public void setLblValorMmHg(JLabel lblValorMmHg) {
		this.lblValorMmHg = lblValorMmHg;
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

	public void setLblPressaoMinima(String valor) {
		this.lblPressaoMinima.setText(valor);
	}

	
}
