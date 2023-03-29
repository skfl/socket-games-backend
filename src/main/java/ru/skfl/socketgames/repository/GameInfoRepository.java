package ru.skfl.socketgames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skfl.socketgames.entities.GameInfo;

@Repository
public interface GameInfoRepository extends JpaRepository<GameInfo, Long> {
    boolean existsByTitle(String title);
}
