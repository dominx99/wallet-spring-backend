package pl.borecki.wallet.appUserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.borecki.wallet.model.AppUser;
import pl.borecki.wallet.model.Role;
import pl.borecki.wallet.repository.AppUserRepository;
import pl.borecki.wallet.repository.RoleRepository;

import javax.transaction.Transactional;
import java.util.List;
@Service
@RequiredArgsConstructor //to zwraca konstruktory do obu private final
@Transactional
@Slf4j
//PAMIETAĆ O PODATNOSCI
public class AppUserServiceImplementation implements AppUserService {
    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;

    @Override
    public AppUser saveUser(AppUser appuser) {
        log.info("Zapisanie nowego użytkownika {} do bazy danych", appuser.getName());
        return appUserRepository.save(appuser);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Zapisanie nowej roli {} użytkownika do bazy danych", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Przypisanie roli {} użytkownikowi {}", roleName, username);
        AppUser appUser =appUserRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        appUser.getRoles().add(role);
    }

    @Override
    public AppUser getUser(String username) {
        log.info("Wywołanie użytkownika {}", username);
        return appUserRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> getUser() {
        log.info("Wywołanie wszystkich użytkowników");
        return appUserRepository.findAll();
    }
}
