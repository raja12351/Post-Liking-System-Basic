package Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Table(name = "notifications")
@Data
public class Notifications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer notificationNo;

    private LocalTime notificationTime;

    private String msg;

    @OneToOne
    @JoinColumn
    private Post post;
}
