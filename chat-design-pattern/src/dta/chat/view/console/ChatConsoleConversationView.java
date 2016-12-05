package dta.chat.view.console;

import dta.chat.model.ChatMessage;
import dta.chat.model.observer.ChatObservable;
import dta.chat.model.observer.ChatObserver;

public class ChatConsoleConversationView extends ViewComposite implements ChatObserver<ChatMessage>{

	private String login;

	@Override
	public void print() {
		System.out.println("== Conversations ==");
		System.out.println("Welcome : " + login);
	}
	
	public void sayWelcome(String login) {
		this.login = login;
	}


	@Override
	public void update(ChatObservable<ChatMessage> observable, ChatMessage obj) {
		System.out.println(obj.getLogin() + " : " + obj.getText());
		
	}
}
