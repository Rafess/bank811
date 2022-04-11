package com.santander.banco811.repository;

import com.santander.banco811.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;



@DataJpaTest
@Profile("test")
class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    UserRepository userRepository;

    @Test
     void getUsersByNameWithSuccess() {
        User user = new User();
        user.setName("Maria");
        user.setPassword("12345677");
        user.setCpf("12312312312");

        User user2 = new User();
        user2.setName("Anderson");
        user2.setPassword("12345677");
        user2.setCpf("12312312313");

        user = entityManager.persist(user);
        entityManager.persist(user2);

        PageRequest pageRequest = PageRequest.of(0,3);

        var users = userRepository.findByName("Maria", pageRequest);

        Assertions.assertEquals(1, users.getTotalElements());
        Assertions.assertEquals(user, users.stream().findFirst().orElseThrow());
    }

    @Test
     void saveNewUserWithSuccess() {
        User user = new User();
        user.setCpf("12345678911");
        user.setName("Teste");
        user.setPassword("12345678");

        user = userRepository.save(user);

        Assertions.assertNotNull(user.getId());
        Assertions.assertNotNull(user.getUpdateDate());
        Assertions.assertNotNull(user.getCreationDate());
    }




    @Test
     void getUsersByName() {
        User user = new User();
        user.setCpf("12345678911");
        user.setName("Teste");
        user.setPassword("12345678");

        User user2 = new User();
        user2.setCpf("12345678912");
        user2.setName("Maria");
        user2.setPassword("12345678");

        entityManager.persist(user);
        entityManager.persist(user2);

        PageRequest pageRequest = PageRequest.of(
                0,
                10,
                Sort.Direction.DESC,
                "nome");

        var users = userRepository.findByName("Maria", pageRequest);

        Assertions.assertEquals(1, users.getTotalElements());
        Assertions.assertEquals(user2, users.stream().findFirst().orElseThrow());
    }

    @Test
     void findUserById() {
        User user = new User();
        user.setCpf("12345678911");
        user.setName("Teste");
        user.setPassword("12345678");

        user = entityManager.persist(user);


        var userEncontrado = userRepository.findById(user.getId()).orElseThrow();

        Assertions.assertEquals(userEncontrado.getId(), user.getId());
        Assertions.assertEquals(userEncontrado.getCpf(), user.getCpf());
    }



}
