package law.tugas2.controller.api;

import law.tugas2.model.MessageDTO;
import law.tugas2.model.PrivateMessage;
import law.tugas2.service.ChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@CrossOrigin(origins = "*")
public class ChatRestController {
    @Autowired
    private ChatService chatService;

    private static final Logger logger = LoggerFactory.getLogger(ChatRestController.class);

    @PostMapping(value = "/chat")
    public ResponseEntity<Object> sendMessage(@RequestBody MessageDTO message) {
        logger.info("Pesan dari " + message.getSenderName() + " kepada " +
                message.getReceiverName() + " terkirim");
        chatService.processMessage(message);
        return ResponseEntity.ok("Pesan dari " + message.getSenderName() + " kepada " +
                message.getReceiverName() + " terkirim");
    }

    @GetMapping("/private-chat-user/{nama}")
    @Async
    public CompletableFuture<ResponseEntity<Object>> getPrivateChatByUser(@PathVariable String nama) {
        long start = System.currentTimeMillis();

        CompletableFuture<List<PrivateMessage>> sender = chatService.getPrivateChatBySender(nama);
        CompletableFuture<List<PrivateMessage>> receiver = chatService.getPrivateChatByReceiver(nama);

        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));

        List<PrivateMessage> response = Stream.concat(sender.join().stream(), receiver.join().stream()).toList();

        return CompletableFuture.completedFuture(ResponseEntity.ok(response));
    }
}
