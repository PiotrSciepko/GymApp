package pl.coderslab.gym.level;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface LevelRepository extends JpaRepository<Level, Long> {

    Level findByName(String name);
    List<Level> findAllByOrderById();
}
