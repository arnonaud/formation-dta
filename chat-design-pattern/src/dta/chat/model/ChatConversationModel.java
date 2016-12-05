package dta.chat.model;


import dta.chat.model.observer.ChatObservable;

public class ChatConversationModel extends ChatObservable<ChatMessage>{

	public void setLogin(ChatMessage login){
	
		notifyObservers(login);
	}
	
	public void sendMessage(ChatMessage msg){
		notifyObservers(msg);
	}


}
