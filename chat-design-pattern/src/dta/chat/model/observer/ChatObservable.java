package dta.chat.model.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class ChatObservable<T> {
	private List<ChatObserver<T>> observers = new ArrayList<>();

	public void addObserver(ChatObserver<T> observer) {
		this.observers.add(observer);
	}

	public void removerObserver(ChatObserver<T> observer) {
		this.observers.remove(observer);
	}

	public void notifyObservers(T msg) {
		this.observers.forEach(obs -> obs.update(this,msg));
	}
}
