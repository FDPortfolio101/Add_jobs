package com.availablejobs.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    JobRepository jobRepository;

    @RequestMapping ("/job")
    public String listJobs(Model model){
        model.addAttribute("jobs", jobRepository.findAll());
        return "Intro";
    }

    @GetMapping("/add")
    public String jobForm (Model model){
        model.addAttribute("jobs", new Jobs());
        return "jobform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Jobs jobs, BindingResult result)
    {
        if (result.hasErrors()) {
            return "jobform";
        }
        jobRepository.save(jobs);
        return "listjob";
    }
    @RequestMapping("/detail/{id}")
    public String showJobs(@PathVariable("id") long id, Model model) {
        model.addAttribute("jobs", jobRepository.findById(id).get());
        return "show";
    }
    @RequestMapping("/update/{id}")
    public String updateJobs(@PathVariable("id") long id, Model model) {
        model.addAttribute("jobs", jobRepository.findById(id).get());
        return "jobform";
    }

    @RequestMapping("/delete/{id}")
    public String delJobs(@PathVariable("id") long id){
        jobRepository.deleteById(id);
        return "redirect:/";
    }
}
