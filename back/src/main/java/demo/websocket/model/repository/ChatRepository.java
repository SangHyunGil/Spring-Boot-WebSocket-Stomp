package demo.websocket.model.repository;

import demo.websocket.model.entity.Chat;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    @EntityGraph(attributePaths = {"chatRoom"})
    Optional<List<Chat>> findAllByChatRoomId(Long id);
}
