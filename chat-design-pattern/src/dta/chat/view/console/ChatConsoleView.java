package dta.chat.view.console;

import java.util.Scanner;

import dta.chat.controller.ChatAuthController;

public class ChatConsoleView extends ViewComposite{
	
	private ChatConsoleTitleView titleView;
	private ChatConsoleConversationView conversationView;
	private ChatConsoleLoginView loginView;

	public ChatConsoleView(Scanner sc) {
		this.titleView = new ChatConsoleTitleView();
		this.conversationView = new ChatConsoleConversationView();
		this.loginView = new ChatConsoleLoginView(sc);
		this.children.add(titleView);
		this.children.add(loginView);
		this.children.add(conversationView);
	}
	
	public void setAuthController(ChatAuthController controller) {
		this.loginView.setAuthController(controller);
	}
	
	public void setLogin(String login) {
		this.conversationView.sayWelcome(login);
	}

	
	
}
