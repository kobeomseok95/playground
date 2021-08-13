package com.example.aop;

import com.example.aop.aspect.GetUser;
import com.example.aop.board.Board;
import com.example.aop.board.BoardRepository;
import com.example.aop.board.BoardService;
import com.example.aop.user.Info;
import com.example.aop.user.User;
import com.example.aop.user.UserRepository;
import com.example.aop.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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

    /**
     * 만약 유저가 있을 경우는 유저에 대한 정보 가져오기
     * 그렇지 않다면 그냥 로그인 하지 않은 회원 처리해주기
     * @param userId
     */
    @GetMapping("/users/{userId}")
    public ResponseEntity<Info> getUser(@PathVariable Long userId, @GetUser Optional<User> user) {

        return ResponseEntity.ok(userService.getUser(userId, user));
    }

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }
}
