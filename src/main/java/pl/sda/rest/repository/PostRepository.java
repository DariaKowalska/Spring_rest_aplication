package pl.sda.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.rest.model.Post;
import pl.sda.rest.model.enums.CategoryEnum;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findAllByCategory(CategoryEnum category);
}
