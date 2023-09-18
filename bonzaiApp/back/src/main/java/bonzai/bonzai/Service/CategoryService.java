package bonzai.bonzai.Service;


import bonzai.bonzai.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bonzai.bonzai.repository.CategoryRepo;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;
public void createCategory(Category category){
    categoryRepo.save(category);
}

    public List<Category> listCategory(){
       return categoryRepo.findAll();
    }

    public void editCategory(Long Id, Category updateCategory) {
    Category category = categoryRepo.getById(Id);
    category.setCategoryName(updateCategory.getCategoryName());
    category.setDescription(updateCategory.getDescription());
    categoryRepo.save(category);
    }
    @DeleteMapping
    public boolean deleteCategory(Long Id) {
        Optional<Category> categoryOptional = categoryRepo.findById(Id);
        if (categoryOptional.isPresent()) {
            categoryRepo.deleteById(Id);
            return true;
        } else {
            System.out.println("Category not exist with this ID: " + Id);
            return false;
        }
    }
}
