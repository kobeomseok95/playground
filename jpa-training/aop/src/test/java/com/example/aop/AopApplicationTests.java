package com.example.aop;

import com.example.aop.history.History;
import com.example.aop.history.HistoryRepository;
import com.example.aop.user.User;
import com.example.aop.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AopApplicationTests {

    @Autowired
    private UserService userService;
    @Autowired
    private HistoryRepository historyRepository;

    @Test
    void updateUsers() throws Exception {
        List<User> users = userService.getUsers();
        for(int i=0;i<5;i++){
            User user = users.get(i);
            user.setEmail("jojoldu@gmail.com");
            userService.update(user);
        }

        List<History> histories = historyRepository.findAll();
        assertThat(histories.size()).isEqualTo(5);
        assertThat(histories.get(0).getUserIdx()).isEqualTo(1L);
        assertThat(histories.get(1).getUserIdx()).isEqualTo(2L);
    }

}
