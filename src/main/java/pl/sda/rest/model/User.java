package pl.sda.rest.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity

public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String login;
    private String password;
    private LocalDateTime registration_date = LocalDateTime.now();
    private boolean active = false;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
public User (){}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(LocalDateTime registration_date) {
        this.registration_date = registration_date;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)

    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )

    private Set<Role> roles = new HashSet<>();

public void addRole (Role role){
    this.roles.add(role);
}

@OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
private List<Post> posts = new ArrayList<>();



    public void addPost(Post post){
        this.posts.add(post);
    }
}