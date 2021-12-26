package net.proselyte.jwtappdemo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import  net.proselyte.jwtappdemo.model.Message;
public interface MessageRepository extends JpaRepository<Message, Long> {
		
	Message findByText(String text);
	List<Message> findByUserName(String userName);
			
}