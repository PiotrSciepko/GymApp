package pl.coderslab.gym.activity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/activity")
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/list")
    public String activityList(Model model) {
        model.addAttribute("activities", activityService.getActivities());
        return "/activity/list.jsp";
    }


}
