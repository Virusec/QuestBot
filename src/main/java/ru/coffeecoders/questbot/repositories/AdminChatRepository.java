package ru.coffeecoders.questbot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.coffeecoders.questbot.entities.AdminChat;

@Repository
public interface AdminChatRepository extends JpaRepository<AdminChat, Long> {
}
