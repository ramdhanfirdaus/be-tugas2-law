package law.tugas2.service;

import law.tugas2.model.dto.RequestMessage;
import law.tugas2.model.PrivateMessage;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ChatService {
    void processMessage(RequestMessage message);
    CompletableFuture<List<PrivateMessage>> getPrivateChatBySender(String name);
    CompletableFuture<List<PrivateMessage>> getPrivateChatByReceiver(String name);
}
