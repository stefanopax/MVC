package it.unimi.di.sweng.lab12.controller;

import java.awt.event.ActionListener;

import it.unimi.di.sweng.lab12.model.Model;
import it.unimi.di.sweng.lab12.view.TicketManagerView;

public abstract class AbstractController implements ActionListener {

	protected Model model;
	protected TicketManagerView view;
	
}