package pl.sda.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.rest.model.enums.CategoryEnum;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String Title;
    private String content;
    private CategoryEnum category;
    private LocalDateTime added_date= LocalDateTime.now();

@ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
@JoinColumn(name = "user_id")
    private User user;


// todo relacja między postem a komentarzem
}


