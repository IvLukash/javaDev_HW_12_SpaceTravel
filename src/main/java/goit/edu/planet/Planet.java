package goit.edu.planet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "planet")
public class Planet {

    @Id
    @Column(length = 10)
    @EqualsAndHashCode.Include
    @ToString.Include
    private String id;

    @Column(nullable = false, length = 500)
    @ToString.Include
    private String name;
}