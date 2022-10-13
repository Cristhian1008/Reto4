package com.Prestamos.Reto4.Service;

import com.Prestamos.Reto4.Entities.Category;
import com.Prestamos.Reto4.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private  CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }
    public Category save(Category category){
        if(category.getIdCategory()==null){
            return categoryRepository.save(category);
        }else{
            Optional<Category> e = categoryRepository.getCategory(category.getIdCategory());
            if(e.isPresent()){
                return category;
            }else{
                return categoryRepository.save(category);
            }
        }
    }
    public Category update(Category p){
        if(p.getIdCategory()!=null){
            Optional<Category> q = categoryRepository.getCategory(p.getIdCategory());
            if(q.isPresent()){
                if(p.getName()!=null){
                    q.get().setName(p.getName());
                }
                categoryRepository.save(q.get());
                return q.get();
            }else{
                return p;
            }
        }else{
            return p;
        }
    }
    public boolean deleteCategory(int id) {
        boolean d = getCategory(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return d;
    }

    }

