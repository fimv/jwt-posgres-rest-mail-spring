package net.proselyte.jwtappdemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Message extends BaseEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    
    
    private String userName;
        
    private String text;   
    
    public Message() {
    }

    public Message(String text, String userName) {
    	
    	this.userName = userName;        
        this.text = text;        
    }    
   
}
