package com.example.aop;

import com.example.aop.aspect.GetUser;
import com.example.aop.board.Board;
import com.example.aop.board.BoardRepository;
import com.example.aop.board.BoardService;
import com.example.aop.user.User;
import com.example.aop.user.UserRepository;
import com.example.aop.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@RequiredArgsConstructor
public class AopApplication implements CommandLineRunner {

    private final BoardService boardService;
    private final BoardRepository boardRepository;
    private final UserService userService;
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        for(int i=1;i<=100;i++){
            boardRepository.save(
                    Board.builder()
                            .title(i+"번째 게시글의 제목")
                            .content(i+"번째 게시글의 내용")
                            .build()
            );
            userRepository.save(
                    User.builder()
                            .email(i+"@email.com")
                            .name(i+"번째 사용자")
                            .build()
            );
        }
    }

    @GetMapping("/boards")
    public List<Board> getBoards() {
        return boardService.getBoards();
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable Long userId, @GetUser User user) {
        System.out.println("===================user.getId() = " + user.getId());
        System.out.println("===================user.getEmail() = " + user.getEmail());
        System.out.println("===================user.getName() = " + user.getName());
        return user;
    }

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }
}
