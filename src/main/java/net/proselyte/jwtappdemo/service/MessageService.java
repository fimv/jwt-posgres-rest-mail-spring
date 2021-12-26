package net.proselyte.jwtappdemo.service;

import java.util.List;
import net.proselyte.jwtappdemo.model.Message;

public interface MessageService {
	
	List<Message> getLast();
	List<Message> getAll();	
	Message findByText(String text);
	Message save(String text, String userName);
	List<Message> findByUserNamer(String userName);
}
