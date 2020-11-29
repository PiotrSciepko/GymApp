package pl.coderslab.gym.category;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "/category/list.jsp";
    }

    @GetMapping("/show/{id}")
    public String showCategory(@PathVariable long id, Model model) {
        Category category = categoryService.getCategory(id);
        model.addAttribute("category", category);
        return "/category/show.jsp";
    }

    @GetMapping("/add")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "/category/add.jsp";
    }

    @PostMapping("/add")
    public String addCategory(Category category) {
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
        return "/category/edit.jsp";
    }

    @PostMapping("/update")
    public String updateCategory(Category category) {
        categoryService.updateCategory(category);
        return "redirect:/category/list";
    }
}
