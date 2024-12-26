package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.wp.lab.model.enumerations.Role;

@Entity
@NoArgsConstructor
@Data
@Table(name = "users_table" )
public class User {
    @Id
    private String username;
    private String password;
    private String name;
    private String surname;
    @Enumerated(value = EnumType.STRING)
    private Role role;

    public User(String username, String password, String name, String surname, Role role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }
}
