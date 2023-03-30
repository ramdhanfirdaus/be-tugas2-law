package law.tugas2.model.dto;

import law.tugas2.model.Status;
import lombok.Data;

@Data
public class RequestMessage {
	private String senderName;
	private String receiverName;
	private String message;
	private String date;
	private Status status;
}
