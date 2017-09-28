package chatbotProject;

public class Chatbot {

	private String userName;
	private Topic jasonYan;
	private boolean chatting;
	
	public Chatbot() {
		jasonYan = new ChatbotJasonYan();
		userName = "unknown user";
		chatting = true;
	}
	public void startTalking() {
		ChatbotMain.print("Welcome to our chatbot! What is your name?");
		userName = ChatbotMain.getInput();
		while(chatting) {
			ChatbotMain.print("What do you want to talk about?");
			String response = ChatbotMain.getInput();
			if (jasonYan.isTriggered(response)) {
				chatting = false;
				ben.startChatting();
			}else {
				ChatbotMain.print("I'm sorry. I don't understand.");
			}
		}
	}

}
