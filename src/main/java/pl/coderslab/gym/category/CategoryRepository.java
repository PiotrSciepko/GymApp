package pl.coderslab.gym.category;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(String name);
}
