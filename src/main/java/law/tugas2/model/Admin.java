package law.tugas2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="admin")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Admin {

    @Id
    @Column(name = "id")
    private String id;

    @NotNull
    @Column(name = "password", nullable = false)
    private String password;
}
