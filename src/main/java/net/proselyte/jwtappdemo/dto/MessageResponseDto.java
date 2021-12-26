package net.proselyte.jwtappdemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import net.proselyte.jwtappdemo.model.Message;

	/**
	 * DTO class for message requests by ROLE_USER
	 */

	@Data
	@JsonIgnoreProperties(ignoreUnknown = true)
	public class MessageResponseDto {
		
	    private Long id;
	    private String userName;
	    private String text;
	    	    
	    public Message toMessage() {
	        Message message = new Message();
	        message.setId(id);
	        message.setUserName(userName);
	        message.setText(text);
	        	        
	        return message;
	    }

	    public static MessageResponseDto fromMessage(Message message) {
	    	MessageResponseDto messageDto = new MessageResponseDto();
	        
		
			messageDto.setId(message.getId());
	        messageDto.setUserName(message.getUserName());
	        messageDto.setText(message.getText());	        

	        return messageDto;
	    }
		
	}
