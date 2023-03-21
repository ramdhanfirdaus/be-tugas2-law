package law.tugas2.controller.api;

import law.tugas2.model.Admin;
import law.tugas2.model.dto.RequestAdmin;
import law.tugas2.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class UserRestController {
    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);

    @GetMapping("/user")
    public ResponseEntity<Object> getAllUserByPrivateChatroom() {
        logger.info("Data seluruh user terkirim");
        return ResponseEntity.ok(userService.getAllUserPrivateChatroom());
    }

    @PostMapping("/admin")
    public Object requestAdmin(@RequestBody RequestAdmin request) {

        Admin admin = userService.getAdminByPassword(request.getPassword());

        if (admin == null) {
            logger.info("Pengguna salah input password");
            return ResponseEntity.notFound();
        }

        logger.info("Admin login");
        return ResponseEntity.ok(admin);
    }

}
