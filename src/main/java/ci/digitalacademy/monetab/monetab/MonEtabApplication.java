package ci.digitalacademy.monetab.monetab;

import ci.digitalacademy.monetab.monetab.models.Professeur;
import ci.digitalacademy.monetab.monetab.models.Student;
import ci.digitalacademy.monetab.monetab.models.User;
import ci.digitalacademy.monetab.monetab.services.ProfesseurService;
import ci.digitalacademy.monetab.monetab.services.StudentService;
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
	@Autowired
	private ProfesseurService professeurService;
	@Autowired
	 private StudentService studentService;
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

		user2.setPseudo("Bakus007");
		userService.save(user2);
		userService.delete(user.getId());

		Professeur prof = new Professeur(null,"Informatique",true);
		Professeur prof2 = new Professeur(null,"Mathematique",true);
		professeurService.save(prof);
		professeurService.save(prof2);

		List<Professeur> profs = professeurService.findAll();
		System.out.println(profs);
		Optional<Professeur> optionalProfesseur = professeurService.findOne(1L);
		System.out.println(optionalProfesseur);

		//prof2.setMatiere("Chimie");
		//professeurService.save(prof2);
		//professeurService.delete((user.getId()));
		Student student = new Student(null,"Tle","Ikouma01");
		Student student2 = new Student(null,"Master","Akouma98");
		studentService.save(student);
		studentService.save(student2);

		List<Student> students = studentService.findAll();
		System.out.println(students);
		Optional<Professeur> optionalStudent = professeurService.findOne(1L);
		System.out.println(optionalProfesseur);
	}
}
