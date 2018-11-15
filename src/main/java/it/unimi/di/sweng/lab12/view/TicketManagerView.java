package it.unimi.di.sweng.lab12.view;

import java.util.Observer;

import it.unimi.di.sweng.lab12.controller.AbstractController;

public interface TicketManagerView extends Observer {

	void addListener(AbstractController listener);
	
	RoleStrategy getRole();
	
}