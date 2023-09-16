package bonzai.bonzai.controller;

import bonzai.bonzai.Service.CategoryService;
import bonzai.bonzai.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @PostMapping("/create")
    public String createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return "Success";
    }

    @GetMapping("/list")
    public List<Category> listCategory(){
       List<Category> categories = categoryService.listCategory();
       return categories;
    }

    @PutMapping("/update/{categoryId}")
    public String updateCategory(@PathVariable("categoryId") Long Id, @RequestBody Category category){
        System.out.println("category id" + Id);
        categoryService.editCategory(Id, category);
        return "Category updated";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {

        try {
            categoryService.deleteCategory(id);
            return ResponseEntity.ok("Category successfully deleted");
        }catch (ResponseStatusException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }


}
