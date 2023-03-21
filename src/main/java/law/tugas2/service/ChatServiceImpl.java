package law.tugas2.service;

import law.tugas2.model.MessageDTO;
import law.tugas2.model.PrivateMessage;
import law.tugas2.repository.PrivateMessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private PrivateMessageRepository privateMessageRepository;

    private static final Logger logger = LoggerFactory.getLogger(ChatServiceImpl.class);

    @Override
    public void processMessage(MessageDTO message) {
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(),"/private",message);
        savePrivateMessage(message);
    }

    @Override
    @Async
    public CompletableFuture<List<PrivateMessage>> getPrivateChatBySender(String name) {
        logger.info("Mengambil private message dari user sebagai sender");
        return CompletableFuture.completedFuture(privateMessageRepository.findAllBySenderName(name));
    }

    @Override
    @Async
    public CompletableFuture<List<PrivateMessage>> getPrivateChatByReceiver(String name) {
        logger.info("Mengambil private message dari user sebagai receivere");
        return CompletableFuture.completedFuture(privateMessageRepository.findAllByReceiverName(name));
    }

    private void savePrivateMessage(MessageDTO message) {
        PrivateMessage privateMessage = new PrivateMessage();
        privateMessage.setSenderName(message.getSenderName());
        privateMessage.setReceiverName(message.getReceiverName());
        privateMessage.setMessage(message.getMessage());
        privateMessage.setDate(new Date());
        privateMessageRepository.save(privateMessage);
    }
}
