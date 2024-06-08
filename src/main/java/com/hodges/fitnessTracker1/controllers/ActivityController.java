package com.hodges.fitnessTracker1.controllers;

import com.hodges.fitnessTracker1.models.Activity;
import com.hodges.fitnessTracker1.repositories.ActivityRepository;
import com.hodges.fitnessTracker1.repositories.ProfileRepository;
import com.hodges.fitnessTracker1.repositories.TagRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("activities")
public class ActivityController {

    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private TagRepository tagRepository;

    @GetMapping
    public String getAllActivities(Model model) {
        model.addAttribute("activities", activityRepository.findAll());
        return "activity/list";
    }

    @GetMapping("/new")
    public String showNewActivityForm(Model model) {
        model.addAttribute("activity", new Activity());
        model.addAttribute("profiles", profileRepository.findAll());
        model.addAttribute("tags",tagRepository.findAll());
        return "activity/form";
    }

    @PostMapping
    public String saveActivity(@ModelAttribute("activity") Activity activity) {
        activityRepository.save(activity);
        return "redirect:/activities";
    }
    @GetMapping("edit/{id}")
    public String editActivity(@PathVariable("id") Long id, Model model){
        model.addAttribute("activity", activityRepository.getReferenceById(id));
        model.addAttribute("profiles", profileRepository.findAll());
        model.addAttribute("tags",tagRepository.findAll());
        return "activity/form";
    }
    @PostMapping("delete/{id}")
    public String deleteActivity(@PathVariable("id") Long id){
        activityRepository.deleteById(id);
        return "redirect:/activities";
    }
}
