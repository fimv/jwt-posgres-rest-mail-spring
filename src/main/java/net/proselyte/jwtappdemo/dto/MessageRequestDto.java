package net.proselyte.jwtappdemo.dto;

import lombok.Data;

/**
 * DTO class for MessageRequest (massage) request.
  */

@Data
public class MessageRequestDto {
	private String username;
    private String message;
}


