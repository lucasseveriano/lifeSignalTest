package br.gov.serpro.behave.lifeSignalTest;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.Button;
import br.gov.frameworkdemoiselle.behave.runner.ui.Label;

@ScreenMap(name = "tela principal", location = "LIVE SIGNAL - UNIGRANRIO")
public class JanelaPrincipalTest {
	
	@ElementMap(name = "Temperatura1", locatorType = ElementLocatorType.LinkText, locator = "36")
	private Label lblTemperatura1;
	
	@ElementMap(name = "Iniciar", locatorType = ElementLocatorType.Label, locator = "Iniciar")
	private Button btnIniciar;
	
	@ElementMap(name = "abrirJanelaAluno", locatorType = ElementLocatorType.Label, locator = "Abrir Tela Aluno")
	private Button btnAbrirJanelaAluno;
	
	@ElementMap(name = "abrirJanelaMenu", locatorType = ElementLocatorType.Label, locator = "Menu")
	private Button btnAbrirJanelaMenu;	

}