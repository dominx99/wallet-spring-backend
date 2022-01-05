package pl.borecki.wallet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import pl.borecki.wallet.appUserService.AppUserService;
import pl.borecki.wallet.category.Category;
import pl.borecki.wallet.category.CategoryRepository;
import pl.borecki.wallet.model.AppUser;
import pl.borecki.wallet.model.Role;
import pl.borecki.wallet.transaction.Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
