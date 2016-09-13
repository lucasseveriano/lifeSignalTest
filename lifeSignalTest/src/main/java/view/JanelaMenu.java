package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import control.ControladorPrograma;
import javax.swing.ImageIcon;

public class JanelaMenu {

	private JPanel contentPane;

	public JFrame jframe;

	public JComboBox<String> cbxRitmoCardiaco;
	public JComboBox<String> cbxNivelOximetria;
	public JComboBox<String> cbxRitmoRespiratorio;
	public JComboBox<String> cbxSegundaTela;

	JLabel lblVocNoPossui;

	ControladorPrograma ctrlPrograma;

	/**
	 * Create the frame.
	 */
	public JanelaMenu(ControladorPrograma p) {
		this.ctrlPrograma = p;
		jframe = new JFrame();
		jframe.setIconImage(Toolkit.getDefaultToolkit().getImage(JanelaMenu.class.getResource("/img/Heart beat.png")));
		jframe.setTitle("Menu");
		jframe.setResizable(false);
		jframe.setBounds(100, 100, 649, 574);
		contentPane = new JPanel();
		contentPane.setLocation(-20, -323);
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		jframe.setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelRitmoCardiaco = new JPanel();
		panelRitmoCardiaco.setBackground(new Color(0, 0, 0));
		panelRitmoCardiaco.setBounds(20, 30, 591, 80);
		contentPane.add(panelRitmoCardiaco);
		panelRitmoCardiaco.setLayout(null);

		JLabel lblRitmoCardiaco = new JLabel("Ritmo Cardíaco");
		lblRitmoCardiaco.setBounds(19, 5, 171, 26);
		panelRitmoCardiaco.add(lblRitmoCardiaco);
		lblRitmoCardiaco.setForeground(Color.WHITE);
		lblRitmoCardiaco.setFont(new Font("Verdana", Font.BOLD, 20));

		final JSpinner spCardiaco = new JSpinner();
		spCardiaco.setForeground(SystemColor.desktop);
		spCardiaco.setBackground(SystemColor.desktop);
		spCardiaco.setBounds(364, 40, 50, 25);
		panelRitmoCardiaco.add(spCardiaco);
		spCardiaco.setModel(new SpinnerNumberModel(80, 0, 220, 1));
		spCardiaco.setValue(80);
		spCardiaco.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				ctrlPrograma.atualizarValorCardiaco(((JSpinner) e.getSource()).getValue().toString());
			}
		});

		cbxRitmoCardiaco = new JComboBox<String>();
		cbxRitmoCardiaco.setBounds(20, 40, 332, 25);
		//System.out.println(cbxRitmoCardiaco.setSelectedItem(cbxRitmoCardiaco));
		panelRitmoCardiaco.add(cbxRitmoCardiaco);
		cbxRitmoCardiaco.setFont(new Font("Verdana", Font.BOLD, 14));
		cbxRitmoCardiaco.addItem("Ritmo Sinusal");
		cbxRitmoCardiaco.addItem("Bradicardia Sinusal");
		cbxRitmoCardiaco.addItem("Taquicardia Sinusal");
		cbxRitmoCardiaco.addItem("Arritimia Sinusal");
		cbxRitmoCardiaco.addItem("Bloqueio Sinoauricula");
		cbxRitmoCardiaco.addItem("Pausa Sinusal");
		cbxRitmoCardiaco.addItem("Ritmo Sinusal Com Extrassistoles Supraventriculares");
		cbxRitmoCardiaco.addItem("Tarquicardia Supraventricular");
		cbxRitmoCardiaco.addItem("Fibrilação Auricular");
		cbxRitmoCardiaco.addItem("Fluter Auricular");
		cbxRitmoCardiaco.addItem("Síndrome de Wolff-Parkinson-White");
		cbxRitmoCardiaco.addItem("Bloqueio Auriculo Ventricular de 1º Grau");
		cbxRitmoCardiaco.addItem("Bloqueio Auriculo Ventricular de 2º Grau Tipo 2");
		cbxRitmoCardiaco.addItem("Ritmo Sinusal com Extrassistoles Juncionais");
		cbxRitmoCardiaco.addItem("Ritmo Juncional");
		cbxRitmoCardiaco.addItem("Ritmo Juncional Acelerado");
		cbxRitmoCardiaco.addItem("Marcapasso Errante");
		cbxRitmoCardiaco.addItem("Tarquicardia Juncional");
		cbxRitmoCardiaco.addItem("Ritmo Idioventricular");
		cbxRitmoCardiaco.addItem("Ritmo Idioventricular Acelerado");
		cbxRitmoCardiaco.addItem("Taquicardia Ventricular");
		cbxRitmoCardiaco.addItem("Fibrilação Ventricular");
		cbxRitmoCardiaco.addItem("Assistolia");
		cbxRitmoCardiaco.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrlPrograma.atualizarRitmoCardiaco(cbxRitmoCardiaco.getSelectedItem().toString());
				spCardiaco.setValue(Integer.parseInt(ctrlPrograma.lerValorBatimentoBatimento()));
			}
		});

		final JButton btnIniciarCardiaco = new JButton("Play");
		btnIniciarCardiaco.setIcon(new ImageIcon(JanelaMenu.class.getResource("/img/play.png")));
		btnIniciarCardiaco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctrlPrograma.iniciarThreadCardiaco();
			}
		});
		btnIniciarCardiaco.setBounds(421, 40, 78, 25);
		panelRitmoCardiaco.add(btnIniciarCardiaco);

		JButton btnPararCardiaco = new JButton("Stop");
		btnPararCardiaco.setIcon(new ImageIcon(JanelaMenu.class.getResource("/img/stop.png")));
		btnPararCardiaco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ctrlPrograma.pararThreadCardiaco(btnIniciarCardiaco.getText());
				ctrlPrograma.pararThreadCardiaco();
			}
		});
		btnPararCardiaco.setBounds(509, 40, 82, 25);
		panelRitmoCardiaco.add(btnPararCardiaco);

		JPanel panelNivelOximetria = new JPanel();
		panelNivelOximetria.setBackground(SystemColor.desktop);
		panelNivelOximetria.setBounds(20, 110, 591, 80);
		contentPane.add(panelNivelOximetria);
		panelNivelOximetria.setLayout(null);

		JLabel lblNivelOximetria = new JLabel("N\u00EDvel Oximetria");
		lblNivelOximetria.setBounds(24, 8, 196, 26);
		lblNivelOximetria.setForeground(Color.WHITE);
		lblNivelOximetria.setFont(new Font("Verdana", Font.BOLD, 20));
		panelNivelOximetria.add(lblNivelOximetria);

		final JSpinner spOximetria = new JSpinner();
		spOximetria.setModel(new SpinnerNumberModel(100, 0, 100, 1));
		spOximetria.setBounds(364, 45, 50, 25);
		spOximetria.setForeground(Color.BLACK);
		spOximetria.setBackground(Color.BLACK);
		panelNivelOximetria.add(spOximetria);
		spOximetria.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				ctrlPrograma.atualizarValorOximetria(((JSpinner) e.getSource()).getValue().toString());
			}
		});

		cbxNivelOximetria = new JComboBox<String>();
		cbxNivelOximetria.setBounds(20, 45, 332, 25);
		cbxNivelOximetria.setFont(new Font("Verdana", Font.BOLD, 14));
		cbxNivelOximetria.addItem("Sinal Normal");
		cbxNivelOximetria.addItem("Baixa Perfusão");
		cbxNivelOximetria.addItem("Ruído Artefato");
		cbxNivelOximetria.addItem("Artefato de Movimento");
		cbxNivelOximetria.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrlPrograma.atualizarNivelOximetria(cbxNivelOximetria.getSelectedItem().toString());
				spOximetria.setValue(Integer.parseInt(ctrlPrograma.lerValorOximetria()));
			}
		});
		panelNivelOximetria.add(cbxNivelOximetria);

		JButton btnIniciarOximetria = new JButton("Play");
		btnIniciarOximetria.setIcon(new ImageIcon(JanelaMenu.class.getResource("/img/play.png")));
		btnIniciarOximetria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlPrograma.iniciarThreadOximetria();
			}
		});
		btnIniciarOximetria.setBounds(421, 45, 78, 25);
		panelNivelOximetria.add(btnIniciarOximetria);

		JButton btnParaOximetria = new JButton("Stop");
		btnParaOximetria.setIcon(new ImageIcon(JanelaMenu.class.getResource("/img/stop.png")));
		btnParaOximetria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlPrograma.pararThreadOximetria();
			}
		});
		btnParaOximetria.setBounds(509, 45, 82, 25);
		panelNivelOximetria.add(btnParaOximetria);

		JPanel panelRitmoRespiratorio = new JPanel();
		panelRitmoRespiratorio.setBackground(SystemColor.desktop);
		panelRitmoRespiratorio.setBounds(20, 188, 591, 126);
		contentPane.add(panelRitmoRespiratorio);
		panelRitmoRespiratorio.setLayout(null);

		JLabel lblRitmoReespiratorio = new JLabel("Ritmo Respirat\u00F3rio");
		lblRitmoReespiratorio.setBounds(23, 12, 226, 26);
		lblRitmoReespiratorio.setForeground(Color.WHITE);
		lblRitmoReespiratorio.setFont(new Font("Verdana", Font.BOLD, 20));
		panelRitmoRespiratorio.add(lblRitmoReespiratorio);

		final JSpinner spRespiratorio = new JSpinner();
		spRespiratorio.setModel(new SpinnerNumberModel(20, 0, 60, 1));
		spRespiratorio.setBounds(364, 45, 50, 25);
		spRespiratorio.setForeground(Color.BLACK);
		spRespiratorio.setBackground(Color.BLACK);
		panelRitmoRespiratorio.add(spRespiratorio);
		spRespiratorio.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				ctrlPrograma.atualizarValorRespiratorio(((JSpinner) e.getSource()).getValue().toString());
			}
		});

		cbxRitmoRespiratorio = new JComboBox<String>();
		cbxRitmoRespiratorio.setBounds(20, 45, 332, 25);
		cbxRitmoRespiratorio.setFont(new Font("Verdana", Font.BOLD, 14));
		panelRitmoRespiratorio.add(cbxRitmoRespiratorio);
		cbxRitmoRespiratorio.addItem("Bradipneia");
		cbxRitmoRespiratorio.addItem("Eupneia");
		cbxRitmoRespiratorio.addItem("Taquipneia");
		cbxRitmoRespiratorio.addItem("Apneia");
		cbxRitmoRespiratorio.addItem("Cheyne - Stoke");
		cbxRitmoRespiratorio.addItem("Biot's");
		cbxRitmoRespiratorio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrlPrograma.atualizarRitmoRespiratorio(cbxRitmoRespiratorio.getSelectedItem().toString());
				spRespiratorio.setValue(Integer.parseInt(ctrlPrograma.lerValorRespiratorio()));
			}
		});

		JButton btnIniciarRespiratorio = new JButton("Play");
		btnIniciarRespiratorio.setIcon(new ImageIcon(JanelaMenu.class.getResource("/img/play.png")));
		btnIniciarRespiratorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlPrograma.iniciarThreadRespiratorio();
			}
		});
		btnIniciarRespiratorio.setBounds(421, 45, 78, 25);
		panelRitmoRespiratorio.add(btnIniciarRespiratorio);

		JButton btnPararRespiratorio = new JButton("Stop");
		btnPararRespiratorio.setIcon(new ImageIcon(JanelaMenu.class.getResource("/img/stop.png")));
		btnPararRespiratorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlPrograma.pararThreadRespiratorio();
			}
		});
		btnPararRespiratorio.setBounds(509, 45, 82, 25);
		panelRitmoRespiratorio.add(btnPararRespiratorio);

		JButton btnPlayAll = new JButton("Play All");
		btnPlayAll.setIcon(new ImageIcon(JanelaMenu.class.getResource("/img/play.png")));
		btnPlayAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctrlPrograma.iniciarThreadCardiaco();
				ctrlPrograma.iniciarThreadOximetria();
				ctrlPrograma.iniciarThreadRespiratorio();
			}
		});
		btnPlayAll.setBounds(170, 100, 98, 26);
		panelRitmoRespiratorio.add(btnPlayAll);

		JButton btnStopAll = new JButton("Stop All");
		btnStopAll.setIcon(new ImageIcon(JanelaMenu.class.getResource("/img/stop.png")));
		btnStopAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlPrograma.pararThreadCardiaco();
				ctrlPrograma.pararThreadOximetria();
				ctrlPrograma.pararThreadRespiratorio();
			}
		});
		btnStopAll.setBounds(336, 100, 98, 26);
		panelRitmoRespiratorio.add(btnStopAll);

		JPanel panelPressão = new JPanel();
		panelPressão.setBackground(Color.BLACK);
		panelPressão.setBounds(20, 367, 591, 56);
		contentPane.add(panelPressão);
		panelPressão.setLayout(null);

		JLabel lblPressao = new JLabel("Press\u00E3o Arterial");
		lblPressao.setBounds(22, 0, 213, 26);
		lblPressao.setForeground(Color.WHITE);
		lblPressao.setFont(new Font("Verdana", Font.BOLD, 20));
		panelPressão.add(lblPressao);

		JLabel lblTemperatura = new JLabel("Temperatura");
		lblTemperatura.setBounds(383, 0, 181, 26);
		panelPressão.add(lblTemperatura);
		lblTemperatura.setForeground(Color.WHITE);
		lblTemperatura.setFont(new Font("Verdana", Font.BOLD, 20));

		JSpinner spPressaoMaxima = new JSpinner();
		spPressaoMaxima.setBounds(22, 38, 51, 20);
		panelPressão.add(spPressaoMaxima);
		spPressaoMaxima.setModel(new SpinnerNumberModel(120, 0, 350, 1));

		JSpinner spPressaoMinima = new JSpinner();
		spPressaoMinima.setBounds(156, 38, 53, 20);
		panelPressão.add(spPressaoMinima);
		spPressaoMinima.setModel(new SpinnerNumberModel(80, 0, 250, 1));

		JSpinner spTemperatura1 = new JSpinner();
		spTemperatura1.setBounds(383, 38, 51, 20);
		panelPressão.add(spTemperatura1);
		spTemperatura1.setModel(new SpinnerNumberModel(36, 20, 42, 1));

		JSpinner spTemperatura2 = new JSpinner();
		spTemperatura2.setBounds(479, 38, 53, 20);
		panelPressão.add(spTemperatura2);
		spTemperatura2.setModel(new SpinnerNumberModel(0, 0, 9, 1));
		spTemperatura2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				ctrlPrograma.atualizarTemperatura2(((JSpinner) e.getSource()).getValue().toString());
			}
		});
		spTemperatura1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				ctrlPrograma.atualizarTemperatura1(((JSpinner) e.getSource()).getValue().toString());
			}
		});
		spPressaoMinima.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				ctrlPrograma.atualizarPressaoMinima(((JSpinner) e.getSource()).getValue().toString());
			}
		});
		spPressaoMaxima.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				ctrlPrograma.atualizarPressaoMaxima(((JSpinner) e.getSource()).getValue().toString());
			}
		});

		JPanel painelMonitor = new JPanel();
		painelMonitor.setLayout(null);
		painelMonitor.setBackground(Color.BLACK);
		painelMonitor.setBounds(20, 467, 591, 79);
		contentPane.add(painelMonitor);

		JLabel lblSegundaTela = new JLabel("Segunda Tela");
		lblSegundaTela.setForeground(Color.WHITE);
		lblSegundaTela.setFont(new Font("Verdana", Font.BOLD, 20));
		lblSegundaTela.setBounds(58, 30, 181, 26);
		painelMonitor.add(lblSegundaTela);

		cbxSegundaTela = new JComboBox<String>();
		cbxSegundaTela.setBounds(329, 34, 227, 25);
		painelMonitor.add(cbxSegundaTela);

		lblVocNoPossui = new JLabel();
		lblVocNoPossui.setForeground(Color.WHITE);
		lblVocNoPossui.setBounds(125, 63, 347, 16);
		painelMonitor.add(lblVocNoPossui);

	}

	public void setTelas() {
		if (ctrlPrograma.getTelas() > 1) {
			cbxSegundaTela.removeAllItems();
			cbxSegundaTela.addItem("Segunda Tela");
			cbxSegundaTela.addItem("Primeira Tela");
			lblVocNoPossui.setVisible(false);
		} else {
			cbxSegundaTela.removeAllItems();
			cbxSegundaTela.addItem("Primeira Tela");
			lblVocNoPossui.setVisible(true);
			lblVocNoPossui.setText("Voc\u00EA n\u00E3o possui nenhuma tela integrada ao computador");
		}
	}
}