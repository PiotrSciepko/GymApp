package pl.coderslab.gym.activity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface ActivityRepository extends JpaRepository<GroupActivity, Long> {
    Collection<GroupActivity> findAllByOrderById();
}
