package law.tugas2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Table(name="private_message")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PrivateMessage {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @NotNull
    @Column (name = "sender_name", nullable = false)
    private String senderName;

    @NotNull
    @Column (name = "receiver_name", nullable = false)
    private String receiverName;

    @NotNull
    @Column (name = "message", nullable = false)
    private String message;

    @NotNull
    @Column (name = "date", nullable = false)
    private Date date;
}
