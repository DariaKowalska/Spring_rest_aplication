package pl.sda.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.rest.model.Post;
import pl.sda.rest.model.enums.CategoryEnum;
import pl.sda.rest.service.PostService;

import java.util.List;

@RestController
public class PostController {

    PostService postService;
@Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/addPost/{user_id")
    public void addPost(String title, String content, CategoryEnum category, @PathVariable Long user_id){
    postService.addPost(title, content, category, user_id);

    }

    @GetMapping("/allPosts")
        public List<Post> getAllPosts(){
            return postService.getAllPosts();
        }

    @PostMapping("/addComment/{post_id}")
public void addComment(String message, String author, @PathVariable Long post_id){
    postService.addComment(message, author, post_id);
    }  

    }


