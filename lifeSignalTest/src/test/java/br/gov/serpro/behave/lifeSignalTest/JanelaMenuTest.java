package br.gov.serpro.behave.lifeSignalTest;

import javax.swing.JComboBox;
import javax.swing.plaf.ComboBoxUI;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.fest.annotation.ElementIndex;
import br.gov.frameworkdemoiselle.behave.runner.ui.Button;
import br.gov.frameworkdemoiselle.behave.runner.ui.Label;

@ScreenMap(name = "tela Menu", location = "Menu")
public class JanelaMenuTest {
	
	@ElementMap(name = "comboBox", locatorType = ElementLocatorType.ClassName, locator = "JComboBox<String>")
	@ElementIndex(index = 1)
	
	private JComboBox<String> ritmoCardiaco;
	
	@ElementMap(name = "abrirJanelaMenu", locatorType = ElementLocatorType.Label, locator = "Menu")
	private Button btnAbrirJanelaMenu;		
}