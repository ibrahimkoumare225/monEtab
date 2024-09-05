package ci.digitalacademy.monetab.monetab;

import ci.digitalacademy.monetab.monetab.models.*;
import ci.digitalacademy.monetab.monetab.repositories.AppSettingRepositories;
import ci.digitalacademy.monetab.monetab.services.*;
import ci.digitalacademy.monetab.monetab.services.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.Instant;
import java.util.*;

@RequiredArgsConstructor
@SpringBootApplication
public class MonEtabApplication implements CommandLineRunner {

	private final BCryptPasswordEncoder passwordEncoder;
	private  final UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(MonEtabApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {

		UserDTO user1 = new UserDTO();
		user1.setPseudo("ikouma");
		String password = passwordEncoder.encode("ikouma");
		user1.setCreatedDate(Instant.now());
		user1.setPassword(password);

		UserDTO user2 = new UserDTO();
		user2.setPseudo("ibarhim");
		user2.setCreatedDate(Instant.now());
		String password2 = passwordEncoder.encode("Koumare@");
		user2.setPassword(password2);

		userService.save(user1);
		userService.save(user2);


		/*
		RoleUserDTO role1 = new RoleUserDTO();
		role1.setRole("admin");
		RoleUserDTO role2 = new RoleUserDTO();
		role2.setRole("staff");
		RoleUserDTO role3 = new RoleUserDTO();
		role3.setRole("other");

		List<RoleUserDTO> roleUsersDTO = Arrays.asList(role1, role2, role3);
		roleUsersDTO = roleUserService.initRoles(roleUsersDTO);

		AppSettingDTO appSettingDTO = new AppSettingDTO();

		appSettingDTO.setSmtpServer("mail");
		appSettingDTO.setSmtpUsername("monEcole");
		appSettingDTO.setSmtpPassword("monEcole123");
		appSettingDTO.setSmtpPort("587");

		AppSettingDTO settingDTO = appSettingService.initApp(appSettingDTO);

		SchoolDTO schoolDTO = new SchoolDTO();
		schoolDTO.setName("upb");
		schoolDTO.setUrl_logo("https://cdn-icons-png.freepik.com/256/8074/8074788.png?semt=ais_hybrid");
		schoolDTO.setAppSetting(settingDTO);
		schoolDTO = schoolService.initSchool(schoolDTO);

		Set<RoleUserDTO> roleUserAnge = new HashSet<>();
		roleUserAnge.add(roleUsersDTO.get(0));

		Set<RoleUserDTO> roleUserStaff = new HashSet<>();
		roleUserStaff.add(roleUsersDTO.get(1));

		Set<RoleUserDTO> roleUserOther = new HashSet<>();
		roleUserOther.add(roleUsersDTO.get(2));

		UserDTO ange = new UserDTO();
		ange.setPseudo("angeB");
		ange.setPassword("angeB123");
		ange.setCreationdate(Instant.now());
		ange.setSchool(schoolDTO);
		ange.setRoles(roleUserAnge);

		UserDTO staff = new UserDTO();
		staff.setPseudo("delmas");
		staff.setPassword("delmas007");
		staff.setCreationdate(Instant.now());
		staff.setSchool(schoolDTO);
		staff.setRoles(roleUserStaff);

		UserDTO other = new UserDTO();
		other.setPseudo("bakus");
		other.setPassword("bakus005");
		other.setCreationdate(Instant.now());
		other.setSchool(schoolDTO);
		other.setRoles(roleUserOther);

		List<UserDTO> users = List.of(ange, staff, other);
		userService.initUser(users);*/
		/*
		StudentCardsDTO studentCards = new StudentCardsDTO();
		studentCards.setReference("12345L");
		studentCards.setIssue_date("12/08/2024");
		studentCards.setExpiration_date(Date.from(Instant.now()));
		studentCardsService.save(studentCards);



		RoleUserDTO roleUserDTO = new RoleUserDTO();
		roleUserDTO.setRole("Directeur");
		roleUserService.save(roleUserDTO);*/





	}
}
