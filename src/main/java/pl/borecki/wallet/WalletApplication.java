package pl.borecki.wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.borecki.wallet.category.CategoryRepository;

@SpringBootApplication
public class WalletApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(WalletApplication.class, args);
		CategoryRepository categoryRepository = configurableApplicationContext.getBean(CategoryRepository.class);

//		Category category = new Category("rachunki");
//		Transaction rata = new Transaction("ca", 34234, "income",category);
//		List<Transaction> transactions = Arrays.asList(rata);
//		category.setTransactions(transactions);
//		categoryRepository.save(category);

		}
		@Bean
		PasswordEncoder passwordEncoder(){
			return new BCryptPasswordEncoder();
	}

//	@Bean
//	CommandLineRunner run(AppUserService appUserService) {
//		return args -> {
//			appUserService.saveRole(new Role(null, "admin"));
//			appUserService.saveRole(new Role(null, "manager"));
//			appUserService.saveRole(new Role(null, "user"));
//
//			appUserService.saveUser(new AppUser(null, "adam kowalski", "adas", "1234", new ArrayList<>()));
//
//			appUserService.addRoleToUser("adas", "user");
//			appUserService.addRoleToUser("adas", "admin");
//			appUserService.addRoleToUser("adas", "manager");
//		};
//	}

}
