package pl.coderslab.gym.level;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LevelService {

    private final LevelRepository levelRepository;

    public LevelService(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    public List<Level> getLevels() {
        return levelRepository.findAll();
    }

    public Level getLevel(long id) {
        Optional<Level> byId = levelRepository.findById(id);
        return byId.orElse(null);
    }

    public Level getLevel(String name) {
        Optional<Level> byId = Optional.ofNullable(levelRepository.findByName(name));
        return byId.orElse(null);
    }

    public void addLevel(Level Level) {
        levelRepository.save(Level);
    }

    public void deleteLevel(long id) {
        levelRepository.deleteById(id);
    }

    public void updateLevel(Level Level) {
        levelRepository.save(Level);
    }
}
