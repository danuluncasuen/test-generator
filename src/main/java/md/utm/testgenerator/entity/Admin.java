package md.utm.testgenerator.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import md.utm.testgenerator.entity.dto.AdminDto;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String roles;

    private String privileges;

    public Admin(AdminDto adminDto) {
        this.username = adminDto.getUsername();
        this.password = adminDto.getPassword();
    }
}
