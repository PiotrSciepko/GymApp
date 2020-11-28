package pl.coderslab.gym.level;

import org.springframework.data.jpa.repository.JpaRepository;


public interface LevelRepository extends JpaRepository<Level, Long> {

    Level findByName(String name);
}
