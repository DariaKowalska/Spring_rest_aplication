package pl.sda.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String message;
    private String author;
    private LocalDateTime date_added=LocalDateTime.now();

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    public Comment(String message, String author) {
        this.message = message;
        this.author = author;
    }

    // LAZY zaciąga tylko wtedy kiedy jest potrzebne
    // EAger zaciąga wszystko
}
