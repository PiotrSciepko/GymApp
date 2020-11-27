package pl.coderslab.gym.activity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<GroupActivity, Long> {
}
