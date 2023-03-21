package law.tugas2.repository;

import law.tugas2.model.PrivateMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrivateMessageRepository extends JpaRepository<PrivateMessage, String> {
    @Query(value = "(SELECT DISTINCT sender_name AS user FROM private_message)" +
            "UNION" +
            "(SELECT DISTINCT receiver_name AS user FROM private_message)",
            nativeQuery = true)
    List<String> findDistinctByName();

    List<PrivateMessage> findAllBySenderName(String name);

    List<PrivateMessage> findAllByReceiverName(String name);
}
