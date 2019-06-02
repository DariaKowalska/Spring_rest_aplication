package pl.sda.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.rest.model.Post;
import pl.sda.rest.model.User;
import pl.sda.rest.model.enums.CategoryEnum;
import pl.sda.rest.repository.PostRepository;
import pl.sda.rest.repository.UserRepository;

import java.util.List;
@Service
public class PostService {

    PostRepository postRepository;
    UserRepository userRepository;
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
}
