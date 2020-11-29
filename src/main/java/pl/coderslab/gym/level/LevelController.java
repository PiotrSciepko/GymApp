package pl.coderslab.gym.level;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.gym.category.Category;

@Controller
@RequestMapping("/level")
public class LevelController {

    private final LevelService levelService;

    public LevelController(LevelService levelService) {
        this.levelService = levelService;
    }

    @GetMapping("/list")
    public String levelList(Model model) {
        model.addAttribute("levels", levelService.getLevels());
        return "/level/list.jsp";
    }

    @GetMapping("/show/{id}")
    public String showLevel(@PathVariable long id, Model model) {
        Level level = levelService.getLevel(id);
        model.addAttribute("level", level);
        return "/level/show.jsp";
    }

    @GetMapping("/add")
    public String addLevel(Model model) {
        model.addAttribute("level", new Level());
        return "/level/add.jsp";
    }

    @PostMapping("/add")
    public String addLevel(Level level) {
        levelService.addLevel(level);
        return "redirect:/level/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteLevel(@PathVariable long id) {
        levelService.deleteLevel(id);
        return "redirect:/level/list";
    }

    @GetMapping("/update/{id}")
    public String updateLevel(@PathVariable long id, Model model) {
        model.addAttribute("level", levelService.getLevel(id));
        return "/level/edit.jsp";
    }

    @PostMapping("/update")
    public String updateCategory(Level level) {
        levelService.updateLevel(level);
        return "redirect:/level/list";
    }


}
