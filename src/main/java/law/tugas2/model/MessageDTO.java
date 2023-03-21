package law.tugas2.model;

import lombok.Data;

@Data
public class MessageDTO {
	private String senderName;
	private String receiverName;
	private String message;
	private String date;
	private Status status;
}
