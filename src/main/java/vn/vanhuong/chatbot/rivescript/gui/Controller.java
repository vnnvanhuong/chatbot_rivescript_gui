package vn.vanhuong.chatbot.rivescript.gui;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ManagedBean(name = "controller")
public class Controller {
	
	private String humanMessage;
	private String botMessage;
	private String humanMessageDisplay;

	public void onSend(ActionEvent event) {
		Response response = ClientBuilder.newClient().target("http://localhost:8080/chatbot_rivescript_backend/rest/bot")
				.request(MediaType.APPLICATION_FORM_URLENCODED)
				.post(Entity.entity(humanMessage, MediaType.APPLICATION_FORM_URLENCODED));
		this.botMessage = response.readEntity(String.class);
		this.humanMessageDisplay = humanMessage;
		this.humanMessage = null;
	}

	public String getHumanMessage() {
		return humanMessage;
	}

	public void setHumanMessage(String humanMessage) {
		this.humanMessage = humanMessage;
	}

	public String getBotMessage() {
		return botMessage;
	}

	public void setBotMessage(String botMessage) {
		this.botMessage = botMessage;
	}

	public String getHumanMessageDisplay() {
		return humanMessageDisplay;
	}

	public void setHumanMessageDisplay(String humanMessageDisplay) {
		this.humanMessageDisplay = humanMessageDisplay;
	}
}
