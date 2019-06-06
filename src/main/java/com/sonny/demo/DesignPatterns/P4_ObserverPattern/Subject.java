package com.sonny.demo.DesignPatterns.P4_ObserverPattern;


public interface Subject {
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObserver();
}
