package law.tugas2.service;

import law.tugas2.model.Admin;
import law.tugas2.repository.AdminRepository;
import law.tugas2.repository.PrivateMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PrivateMessageRepository privateMessageRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<String> getAllUserPrivateChatroom() {
        return privateMessageRepository.findDistinctByName();
    }

    @Override
    public Admin getAdminByPassword(String password) {
        return adminRepository.findFirstByPassword(password);
    }


}
