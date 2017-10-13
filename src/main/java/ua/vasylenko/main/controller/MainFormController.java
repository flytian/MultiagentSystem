package ua.vasylenko.main.controller;

import java.util.Random;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import ua.vasylenko.main.agent.SingletonSetup;

/*
 * ���������� ��������� �������� MainFormLayout.fxml
 * @Created by Ҹ�� on 10.09.2017.
 * @version 1.0
 */
public class MainFormController{
	/** ----------------���������� ������� ����� -----------------*/
	@FXML
	private GridPane mainFormBasicGrid;
	
	@FXML
	private TextArea urlsArea;
	
	@FXML
	private ProgressBar workingResultProgress;
	
	@FXML
	private Button urlsSearchButton;
	
	@FXML
	private TextField urlEntryField;
	
	/**---------------------�������/������� ----------------------*/
	public GridPane getMainFormBasicGrid() {
		return mainFormBasicGrid;
	}

	public void setMainFormBasicGrid(GridPane mainFormBasicGrid) {
		this.mainFormBasicGrid = mainFormBasicGrid;
	}
	
	public TextArea getUrlsArea() {
		return urlsArea;
	}

	public void setUrlsArea(TextArea urlsArea) {
		this.urlsArea = urlsArea;
	}
	
	public ProgressBar getWorkingResultProgress() {
		return workingResultProgress;
	}

	public void setWorkingResultProgress(ProgressBar workingResultProgress) {
		this.workingResultProgress = workingResultProgress;
	}
	
	/**
	 * ����� "�������" �������� ������.
	 * @return "������" ������.
	 */
	private String getUrlText() {
		return urlEntryField.getText().trim();
	}
	
	/**
	 * ����� ��������� ������� �������� ������� ������ ������.
	 */
	@FXML
	private void searchURLS() {
		try {
			createAgents(10, getUrlText());
		} catch (StaleProxyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ����� �������� �������.
	 * @param countAgents ���������� �������.
	 * @param inputUrl ������� ������ ��� ������.
	 * @throws StaleProxyException
	 */
	private void createAgents(int countAgents, String inputUrl) throws StaleProxyException {
		// ContainerController tempContainerController = AgentSetuble.createContainerAgent();
		/*Object[] arguments = {getUrlsArea()}; 
		SingletonSetup.getInstance().getContainerController().createNewAgent("LinksSaverAgent"+new Random().nextInt(), "ua.vasylenko.main.agent.LinksSaverAgent", arguments).start();
		*/
		Object[] argumentsForSaverAgent = {getUrlsArea(), getWorkingResultProgress()};
		SingletonSetup.getInstance()
			.getContainerController()
			.createNewAgent("LinksSaverAgent", "ua.vasylenko.main.agent.LinksSaverAgent", argumentsForSaverAgent).start();
		
		SingletonSetup.getInstance()
			.getContainerController()
			.createNewAgent("ContentPrepareAgent", "ua.vasylenko.main.agent.ContentPrepareAgent", null).start();
		
		for(int i=1; i<=countAgents; ++i) {
			Object[] arguments = {inputUrl+i}; 
			SingletonSetup.getInstance()
				.getContainerController()
				.createNewAgent("LinksSearcherAgent"+i, "ua.vasylenko.main.agent.LinksSearcherAgent", arguments).start();
		}
		
	}
	
	/**
	 * ����� ���������� ��� �������� ����������.
	 */
	public void exitApplication() {
		//TODO: �������� ������� ��������� ������� � �� ���������� ��� �������� ����������.
		System.out.println("closeee");
	}
}
