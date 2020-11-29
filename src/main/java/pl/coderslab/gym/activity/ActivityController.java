package pl.coderslab.gym.activity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.gym.category.Category;
import pl.coderslab.gym.category.CategoryService;
import pl.coderslab.gym.level.Level;
import pl.coderslab.gym.level.LevelService;

import java.util.Collection;

@Controller
@RequestMapping("/activity")
public class ActivityController {

    private final ActivityService activityService;
    private final CategoryService categoryService;
    private final LevelService levelService;

    public ActivityController(ActivityService activityService, CategoryService categoryService, LevelService levelService) {
        this.activityService = activityService;
        this.categoryService = categoryService;
        this.levelService = levelService;
    }

    @GetMapping("/list")
    public String activityList(Model model) {
        model.addAttribute("activities", activityService.getActivities());
        return "/activity/list.jsp";
    }

    @GetMapping("/show/{id}")
    public String showActivity(@PathVariable long id, Model model) {
        GroupActivity activity = activityService.getActivity(id);
        model.addAttribute("activity", activity);
        return "/activity/show.jsp";
    }

    @GetMapping("/add")
    public String addActivity(Model model) {
        model.addAttribute("activity", new GroupActivity());
        return "/activity/add.jsp";
    }

    @PostMapping("/add")
    public String addPerson(GroupActivity activity) {
        activityService.addActivity(activity);
        return "redirect:/activity/list";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable long id) {
        activityService.deleteActivity(id);
        return "redirect:/activity/list";
    }

    @GetMapping("/update/{id}")
    public String updateActivity(@PathVariable long id, Model model) {
        model.addAttribute("activity", activityService.getActivity(id));
        return "/activity/edit.jsp";
    }

    @PostMapping("/update")
    public String updateActivity(GroupActivity activity) {
        activityService.updateActivity(activity);
        return "redirect:/activity/list";
    }

    @ModelAttribute("levels")
    public Collection<Level> levels() {
        return this.levelService.getLevels();
    }

    @ModelAttribute("categories")
    public Collection<Category> categories() {
        return this.categoryService.getCategories();
    }


}
