package com.hodges.fitnessTracker1.controllers;

import com.hodges.fitnessTracker1.models.Profile;
import com.hodges.fitnessTracker1.models.User;
import com.hodges.fitnessTracker1.repositories.ProfileRepository;
import com.hodges.fitnessTracker1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("profiles")
public class ProfileController {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String getAllProfiles(Model model){
        model.addAttribute("profiles",profileRepository.findAll());
        return "profile/list";
    }

    @GetMapping("new")
    public String showNewProfileForm(Model model){
        model.addAttribute("profile", new Profile());
        model.addAttribute("users", userRepository.findAll());

        return "profile/form";
    }

    @PostMapping
    public String saveProfile(@ModelAttribute("profile") Profile profile){
        profileRepository.save(profile);
        return "redirect:/profiles";
    }

    @GetMapping("edit/{id}")
    public String editProfile(@PathVariable("id") Long id, Model model){
        model.addAttribute("profile", profileRepository.getReferenceById(id));
        model.addAttribute("users", userRepository.findAll());
        return "profile/form";
    }
    @PostMapping("delete/{id}")
    public String deleteProfile(@PathVariable("id") Long id){
        profileRepository.deleteById(id);
        return "redirect:/profiles";
    }
}
