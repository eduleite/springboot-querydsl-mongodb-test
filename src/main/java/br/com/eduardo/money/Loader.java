package br.com.eduardo.money;

import br.com.eduardo.money.model.User;
import br.com.eduardo.money.repositories.UserRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import static br.com.eduardo.money.model.QUser.user;

@Component
public class Loader implements ApplicationRunner {


    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {


        userRepository.save(new User("Eduardo Bastos Leite", "edu.leite@gmail.com", "teste"));
        userRepository.save(new User("Luciana Nunes Leal", "luciananunesleal@gmail.com", "teste1234"));
        userRepository.save(new User("Pedro Leal Leite", "pedrolealleite@gmail.com", "teste12345"));
        Iterable<User> usuarios = userRepository.findAll();
        usuarios.forEach(user -> user.setHashedPassword("nova senha"));
        userRepository.saveAll(usuarios);

        Iterable<User> users =  userRepository.findByEmail("edu.leite@gmail.com");
        users.forEach(user -> System.out.println(user.getId()));

    }
}
