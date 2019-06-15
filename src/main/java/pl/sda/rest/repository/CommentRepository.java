package pl.sda.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.rest.model.Comment;
import pl.sda.rest.model.Post;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);
}
