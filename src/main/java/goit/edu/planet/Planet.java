package goit.edu.planet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Entity
@Table(name = "planet")
public class Planet {

    @Id
    @Column(length = 10)
    @Setter(AccessLevel.NONE)
    private String id;

    @Column(nullable = false, length = 500)
    private String name;
}