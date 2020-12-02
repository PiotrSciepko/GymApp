package pl.coderslab.gym.level;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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
        return "/level/list";
    }

    @GetMapping("/show/{id}")
    public String showLevel(@PathVariable long id, Model model) {
        Level level = levelService.getLevel(id);
        model.addAttribute("level", level);
        return "/level/show";
    }

    @GetMapping("/add")
    public String addLevel(Model model) {
        model.addAttribute("level", new Level());
        return "/level/add";
    }

    @PostMapping("/add")
    public String addLevel(@Valid Level level, BindingResult result) {
        if (result.hasErrors()) {
            return "/level/edit";
        }
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
        return "/level/edit";
    }

    @PostMapping("/update")
    public String updateCategory(@Valid Level level, BindingResult result) {
        if (result.hasErrors()) {
            return "/level/edit";
        }
        levelService.updateLevel(level);
        return "redirect:/level/list";
    }
}
