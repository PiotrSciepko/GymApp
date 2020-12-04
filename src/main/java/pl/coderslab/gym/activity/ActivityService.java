package pl.coderslab.gym.activity;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public Collection<GroupActivity> getActivities() {
        return activityRepository.findAllByOrderById();
    }

    public GroupActivity getActivity(long id) {
        Optional<GroupActivity> byId = activityRepository.findById(id);
        return byId.orElse(null);
    }

    public void addActivity(GroupActivity groupActivity) {
        activityRepository.save(groupActivity);
    }

    public void deleteActivity(long id) {
        activityRepository.deleteById(id);
    }

    public void updateActivity(GroupActivity groupActivity) {
        activityRepository.save(groupActivity);
    }
}
