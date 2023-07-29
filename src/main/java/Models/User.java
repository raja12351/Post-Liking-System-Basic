package Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String userName;

    private Integer age;

    @OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL)
    private List<Post> postList;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Notifications> notificationsList;
}
