package net.proselyte.jwtappdemo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import net.proselyte.jwtappdemo.model.Message;
import  net.proselyte.jwtappdemo.repository.MessageRepository;
import  net.proselyte.jwtappdemo.service.MessageService;

@Service
@Slf4j
public class MessageServiceImpl implements MessageService {
	 @Autowired
	 private MessageRepository messageRepository;	 
	 
	 @Override
	 public List<Message> getAll() {
		 return messageRepository.findAll();
	 }
		 
	 @Override
	 public List<Message> getLast() {
        final List<Message> all = messageRepository.findAll();
        final List<Message> result = all.subList(all.size()-Math.min(all.size(),10), all.size());
        log.info("IN getAll - {} users found", result.size());
        return result;
    }

	@Override
	public Message findByText(String text) {
		return messageRepository.findByText(text);
	}
	
	@Override
	public List<Message> findByUserNamer(String userName) {
		
		return messageRepository.findByUserName(userName);
	}
	

	@Override
	public Message save(String text, String userName) {
		Message message = new Message(text, userName);
		return messageRepository.save(message);
		
	}
	 
}
