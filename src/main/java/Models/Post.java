package Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "post")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postNo;

    private List<String> contentList;
    private LocalTime contentTime;

    private int Likes;

    @JoinColumn
    @ManyToOne
    private User user;

    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Notifications> notifications;
}
