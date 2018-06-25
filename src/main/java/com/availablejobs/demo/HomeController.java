package com.availablejobs.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {


    //      Default route - this will be the first page a user visits
    @Autowired
    JobRepository jobRepository;
//      add Jobs
    @RequestMapping ("/job")
    public String Intro (Model model){
        model.addAttribute("jobs", new Jobs());
        return "Intro";
    }

    @GetMapping("/add")
    public String jobForm (Model model){
        model.addAttribute("job", new Jobs());
        return "jobform";
    }
    @GetMapping("/list")
    public String listJobs (Model model){
        model.addAttribute("job", jobRepository.findAll());
        return "listjob";
    }

    @PostMapping("/process")
    public String processForm(@Valid @ModelAttribute("job") Jobs jobs, BindingResult result)
    {
        if (result.hasErrors()) {
            return "jobform";
        }
        jobRepository.save(jobs);
        return "redirect:/list";
    }
    @RequestMapping("/detail/{id}")
    public String showJobs(@PathVariable("id") long id, Model model) {
        model.addAttribute("job", jobRepository.findById(id).get());
        return "show";
    }
    @RequestMapping("/update/{id}")
    public String updateJobs(@PathVariable("id") long id, Model model) {
        model.addAttribute("job", jobRepository.findById(id).get());
        return "jobform";
    }

    @RequestMapping("/delete/{id}")
    public String delJobs(@PathVariable("id") long id){
        jobRepository.deleteById(id);
        return "redirect:/";
    }
}
