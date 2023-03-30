package law.tugas2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
