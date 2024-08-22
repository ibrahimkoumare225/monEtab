package ci.digitalacademy.monetab.monetab;

import ci.digitalacademy.monetab.monetab.models.User;
import ci.digitalacademy.monetab.monetab.services.UserService;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@ToString
@SpringBootApplication
public class MonEtabApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(MonEtabApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User(null,"bakus","12345678", Instant.now());
		User user2 = new User(null,"angeberthe","12345678",Instant.now());
		userService.save(user);
		userService.save(user2);
		List<User> users= userService.findAll();
		System.out.println(users);
		Optional<User> optionalUser = userService.findOne(2L);
		System.out.println(optionalUser);

		user2.setSpeudo("Bakus007");
		userService.save(user2);
		userService.delete(user.getId());
	}
}
