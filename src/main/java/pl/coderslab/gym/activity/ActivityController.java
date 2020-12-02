package pl.coderslab.gym.activity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.gym.category.Category;
import pl.coderslab.gym.category.CategoryService;
import pl.coderslab.gym.level.Level;
import pl.coderslab.gym.level.LevelService;

import javax.validation.Valid;
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
        return "/activity/list";
    }

    @GetMapping("/show/{id}")
    public String showActivity(@PathVariable long id, Model model) {
        GroupActivity activity = activityService.getActivity(id);
        model.addAttribute("activity", activity);
        return "/activity/show";
    }

    @GetMapping("/add")
    public String addActivity(Model model) {
        model.addAttribute("activity", new GroupActivity());
        return "/activity/add";
    }

    @PostMapping("/add")
    public String addActivity(@ModelAttribute("activity") @Valid GroupActivity activity, BindingResult result) {
        if (result.hasErrors()) {
            return "/activity/add.jsp";
        }
        activityService.addActivity(activity);
        return "redirect:/activity/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteActivity(@PathVariable long id) {
        activityService.deleteActivity(id);
        return "redirect:/activity/list";
    }

    @GetMapping("/update/{id}")
    public String updateActivity(@PathVariable long id, Model model) {
        model.addAttribute("activity", activityService.getActivity(id));
        return "/activity/edit";
    }

    @PostMapping("/update")
    public String updateActivity(@ModelAttribute("activity") @Valid GroupActivity activity, BindingResult result) {
        if (result.hasErrors()) {
            return "/activity/add";
        }
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
