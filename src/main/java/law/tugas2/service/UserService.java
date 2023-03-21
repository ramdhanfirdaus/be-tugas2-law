package law.tugas2.service;

import law.tugas2.model.Admin;

import java.util.List;

public interface UserService {
    List<String> getAllUserPrivateChatroom();

    Admin getAdminByPassword(String password);
}
