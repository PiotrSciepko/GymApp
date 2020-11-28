package pl.coderslab.gym.activity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.gym.category.Category;
import pl.coderslab.gym.category.CategoryService;
import pl.coderslab.gym.level.Level;
import pl.coderslab.gym.level.LevelService;

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
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("levels", levelService.getLevels());
        return "/activity/add.jsp";
    }

    @PostMapping("/add")
    public String addPerson(GroupActivity activity, @RequestParam String categoryName, @RequestParam String levelName) {
        Category category = categoryService.getCategory(categoryName);
        Level level = levelService.getLevel(levelName);
        activity.setCategory(category);
        activity.setLevel(level);
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
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("levels", levelService.getLevels());
        return "/activity/edit.jsp";
    }

    @PostMapping("/update")
    public String updateActivity(GroupActivity activity, @RequestParam String categoryName, @RequestParam String levelName) {
        Category category = categoryService.getCategory(categoryName);
        Level level = levelService.getLevel(levelName);
        activity.setCategory(category);
        activity.setLevel(level);
        activityService.updateActivity(activity);
        return "redirect:/activity/list";
    }


}
