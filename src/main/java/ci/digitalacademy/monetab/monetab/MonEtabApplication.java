package ci.digitalacademy.monetab.monetab;

import ci.digitalacademy.monetab.monetab.models.*;
import ci.digitalacademy.monetab.monetab.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@SpringBootApplication
public class MonEtabApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;
	@Autowired
	private ProfesseurService professeurService;
	@Autowired
	 private StudentService studentService;
	@Autowired
	private FicheNoteService ficheNoteService;
	@Autowired
	private AddressService addressService;
	public static void main(String[] args) {
		SpringApplication.run(MonEtabApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {




/*
		Professeur prof = new Professeur();
		Professeur prof2 = new Professeur();
		prof.setVacant(true);
		prof.setMatiere("Informatique");
		prof2.setVacant(true);
		prof2.setMatiere("Math");
		professeurService.save(prof);
		professeurService.save(prof2);

		List<Professeur> profs = professeurService.findAll();
		System.out.println(profs);
		//Optional<Professeur> optionalProfesseur = professeurService.findOne(1L);
		//System.out.println(optionalProfesseur);

		//prof2.setMatiere("Chimie");
		//professeurService.save(prof2);
		//professeurService.delete((user.getId()));
		//Student student = new Student(null,"Tle","Ikouma01");
		//Student student2 = new Student(null,"Master","Akouma98");
		//studentService.save(student);
		//studentService.save(student2);

		FicheNote ficheNote = new FicheNote();
		FicheNote ficheNote2 = new FicheNote();
		ficheNote.setNote(20);
		ficheNote2.setNote(19);
		ficheNote.setProfesseur(prof);
		ficheNote2.setProfesseur(prof2);
		ficheNoteService.save(ficheNote);
		ficheNoteService.save(ficheNote2);
		Set<FicheNote> noteFiles = new HashSet<>();
		noteFiles.add(ficheNote);
		noteFiles.add(ficheNote2);

		Professeur teacher = new Professeur();
		teacher.setVacant(true);
		teacher.setMatiere("java");
		teacher.setMatiere("python");
		teacher.setFicheNotes(noteFiles);
		professeurService.save(teacher);

		List<Student> students = studentService.findAll();
		System.out.println(students);
		Optional<Professeur> optionalStudent = professeurService.findOne(1L);
		System.out.println(optionalProfesseur);



		Address add = new Address();
		add.setCity("Paris");
		add.setCountry("France");
		add.setStreet("12 sainte-Honorine");
		Address add2 = new Address();
		add2.setCity("Paris");
		add2.setCountry("France");
		add2.setStreet("12 sainte-Honorine");
		addressService.save(add);
		addressService.save(add2);

		List<Address> addresses = addressService.findAll();
		System.out.println(addresses);
		Optional<Address> optionalAddress = addressService.findOne(1L);
		System.out.println(optionalAddress);

		User user = new User(null,"bakus","12345678", Instant.now(),add);
		User user2 = new User(null,"angeberthe","12345678",Instant.now(),add2);
		userService.save(user);
		userService.save(user2);
		List<User> users= userService.findAll();
		System.out.println(users);
		Optional<User> optionalUser = userService.findOne(2L);
		System.out.println(optionalUser);
*/

	}
}
