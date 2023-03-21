package law.tugas2.repository;

import law.tugas2.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {
    Admin findFirstByPassword(String id);
}
