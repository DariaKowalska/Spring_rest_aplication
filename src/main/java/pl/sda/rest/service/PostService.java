package pl.sda.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.rest.model.Comment;
import pl.sda.rest.model.Post;
import pl.sda.rest.model.User;
import pl.sda.rest.model.enums.CategoryEnum;
import pl.sda.rest.repository.CommentRepository;
import pl.sda.rest.repository.PostRepository;
import pl.sda.rest.repository.UserRepository;

import java.util.List;
@Service
public class PostService {

    PostRepository postRepository;
    UserRepository userRepository;
    CommentRepository commentRepository;

    @Autowired
    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public void addPost(
            String title, String content, CategoryEnum category, Long user_id){
        Post post = new Post(title,content,category);
        User user = userRepository.getOne(user_id);
        post.setUser(user);
        user.addPost(post);
        postRepository.save(post);
    }
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }
    public List<Post> getAllPostsByCategory(CategoryEnum category){
        return postRepository.findAllByCategory(category);
    }

    public Comment addComment(String author, String message, Long post_id){
        Post post = postRepository.getOne(post_id);
        Comment comment = new Comment(author, message);
        post.addComment(comment);

        return
                commentRepository.save(comment);

    }


}
