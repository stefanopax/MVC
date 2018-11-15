package it.unimi.di.sweng.lab12.model;

import java.util.Observable;

public abstract class  Model extends Observable {
	public abstract int nextToServe();  //ritorna numero da mettere su display
	public abstract int lastInQueue(); //ritorna ultimo  numero consegnato
	public abstract void serveNext(); // incrementa contatore di cliente corrente (se minore di contatore cliente in attesa) ... POTENZIALE CAMBIO DI STATO (da visualizzare lato servitore e display)
	public abstract void getTicket(); //incrementa contatore in attesa CAMBIA SEMPRE LO STATO (da visualizzare lato cliente)
}