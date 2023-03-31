package com.example.wsbaoop.mobilezoo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/animal")
public class AnimalController {

    @GetMapping("/list")
    public String list(Model model) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("dog", "pieseł", true));
        animals.add(new Animal("lion", "simba", true));
        animals.add(new Animal("bear", "badbear", true));

        model.addAttribute("animals", animals);
        return "animal/zootest";
    }

    @GetMapping("/new")
    public String newAnimal(Model model) {
        model.addAttribute("animal", new Animal());
        return "animal/newanimal";
    }

    @PostMapping("/add")
    public String addAnimal(@ModelAttribute("animal") Animal newAnimal, Model model) {
        System.out.println(newAnimal);
        Animal.savedAnimals.add(newAnimal);
        model.addAttribute("animals", Animal.savedAnimals);
        return "animal/zootest";
    }

}
