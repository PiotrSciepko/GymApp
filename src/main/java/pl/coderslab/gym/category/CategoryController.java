package pl.coderslab.gym.category;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public String categoryList(Model model) {
        model.addAttribute("categories", categoryService.getCategories());
        return "/category/list";
    }

    @GetMapping("/show/{id}")
    public String showCategory(@PathVariable long id, Model model) {
        Category category = categoryService.getCategory(id);
        model.addAttribute("category", category);
        return "/category/show";
    }

    @GetMapping("/add")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "/category/add";
    }

    @PostMapping("/add")
    public String addCategory(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "/category/add";
        }
        categoryService.addCategory(category);
        return "redirect:/category/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable long id) {
        categoryService.deleteCategory(id);
        return "redirect:/category/list";
    }

    @GetMapping("/update/{id}")
    public String updateCategory(@PathVariable long id, Model model) {
        model.addAttribute("category", categoryService.getCategory(id));
        return "/category/edit";
    }

    @PostMapping("/update")
    public String updateCategory(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "/category/edit";
        }
        categoryService.updateCategory(category);
        return "redirect:/category/list";
    }
}
