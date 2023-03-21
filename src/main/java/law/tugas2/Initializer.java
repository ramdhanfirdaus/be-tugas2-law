package law.tugas2;

import jakarta.annotation.PostConstruct;
import law.tugas2.model.Admin;
import law.tugas2.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Initializer {

    @Autowired
    private AdminRepository adminRepository;

    @PostConstruct
    public void init() {
        Admin admin = new Admin();
        admin.setId("1");
        admin.setPassword("passwordAdmin");
        adminRepository.save(admin);
    }


}
