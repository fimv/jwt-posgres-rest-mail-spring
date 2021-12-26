package net.proselyte.jwtappdemo.rest;

	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.proselyte.jwtappdemo.dto.MessageRequestDto;
import net.proselyte.jwtappdemo.dto.MessageResponseDto;
import net.proselyte.jwtappdemo.model.Message;
import net.proselyte.jwtappdemo.model.User;
import net.proselyte.jwtappdemo.service.MessageService;
import net.proselyte.jwtappdemo.service.UserService;

	/**
	 * REST controller user connected requestst.
	 */

	@RestController
	@RequestMapping(value = "/api/v1/messages")
	public class MessageRestControllerV1 {
		    
		    private UserService userService;
		   	private MessageService messageService;
		   		    
		    @Autowired
		    public MessageRestControllerV1(UserService userService,
		    		MessageService messageService) {
		        this.userService = userService;	        
				this.messageService = messageService;
		    }	    

	    	    
	    @PostMapping 
	    public ResponseEntity<List<MessageResponseDto>> createMessage(@RequestBody MessageRequestDto messageRequestDto) {
	    	String username = messageRequestDto.getUsername();
	    	User user = userService.findByUsername(username);
	    	 if(user == null){
	             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	         }
	    	 List<MessageResponseDto> resultList = null;
	    	if (messageRequestDto.getMessage() == "history 10") {        	
	        	List<Message> messages = messageService.getLast();
	        	for (int i=0; i<messages.size(); i++) { 
	        		Message message = new Message();
	        		MessageResponseDto result= MessageResponseDto.fromMessage(message);
	        	    resultList.add(result);
	        	}
	        	userService.sendMessage(user, messages);               
				return new ResponseEntity<List<MessageResponseDto>>(resultList, HttpStatus.OK);
	        }
	    	messageService.save(messageRequestDto.getMessage(),user.getUsername());
	    	return new ResponseEntity<>( HttpStatus.OK);
	    }
	    
	}