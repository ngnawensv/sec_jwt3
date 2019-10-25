package cm.belrose.spring.sec_jwt;

import cm.belrose.spring.sec_jwt.dao.TachesRepository;
import cm.belrose.spring.sec_jwt.entities.Roles;
import cm.belrose.spring.sec_jwt.entities.Taches;
import cm.belrose.spring.sec_jwt.entities.Users;
import cm.belrose.spring.sec_jwt.service.AccountService;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class}) //exclusion de la securité basic de Spring
public class SecJwtApplication implements CommandLineRunner {

    @Autowired
    private TachesRepository tachesRepository;
    @Autowired
    private AccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(SecJwtApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {
//        accountService.saveUser(new Users(null, "admin", "1234", null));
//        accountService.saveUser(new Users(null, "user", "1234", null));
//        accountService.savaRoles(new Roles(null, "ADMIN"));
//        accountService.savaRoles(new Roles(null, "USER"));
//        accountService.addRoleToUser("admin", "ADMIN");
//        accountService.addRoleToUser("admin", "USER");
//        accountService.addRoleToUser("user", "USER");
//
//        Stream.of("T1", "T2", "T3").forEach(t -> {
//            tachesRepository.save(new Taches(null, t));
//        });
//        tachesRepository.findAll().forEach(t -> {
//            System.out.println(t.getNomTache());
//        });
//        tachesRepository.findAll()
//                .stream()
//                .map(t->t.getNomTache())
//                .forEach(System.out::println);
        tachesRepository.findAll()
                .stream()
                .map(Taches::getNomTache)
                .forEach(System.out::println);
    }

}
