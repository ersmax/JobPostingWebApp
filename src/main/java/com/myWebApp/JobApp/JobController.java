package com.myWebApp.JobApp;

import com.myWebApp.JobApp.model.JobPost;
import com.myWebApp.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping({"/", "/home"})
    public String homepage() {
        return "home";
    }

    @GetMapping("/addjob")
    public String addJob() {
        return "addjob";
    }

    @PostMapping("/handleForm")
    public String handleForm(JobPost jobPost) {
        // jobPost is a DTO
        jobService.addJob(jobPost);
        return "success";
    }

    @GetMapping("/viewalljobs")
    public String viewJobs(Model model) {
        List<JobPost> jobs = jobService.getAllJobs();
        model.addAttribute("jobPosts", jobs);
        return "viewalljobs";
    }
}

//    @RequestMapping(value = "/handleForm", method = RequestMethod.POST)
//    public String handleForm(JobPost jobPost) {
//        return "success";
//    }

//    @PostMapping("/handleForm")
//    public ModelAndView handleForm(int postId, String postProfile, String postDescription,
//                                   @RequestParam("reqExperience") int requiredExperience,
//                                   @RequestParam("postTechStack") List<String> postTechStack,
//                                   ModelAndView modelView) {
//        JobPost jobPost = new JobPost();
//        jobPost.setPostId(postId);
//        jobPost.setPostProfile(postProfile);
//        jobPost.setPostDescription(postDescription);
//        jobPost.setReqExperience(requiredExperience);
//        jobPost.setPostTechStack(postTechStack);
//        modelView.addObject("jobPost", jobPost);
//        modelView.setViewName("success");
//        return modelView;
//    }


//    @PostMapping("/handleForm")
//    public String handleForm(int postId, String postProfile, String postDescription,
//                             @RequestParam("reqExperience") int requiredExperience,
//                             @RequestParam("postTechStack") List<String> postTechStack,
//                             Model model) {
//        JobPost jobPost = new JobPost();
//        jobPost.setPostId(postId);
//        jobPost.setPostProfile(postProfile);
//        jobPost.setPostDescription(postDescription);
//        jobPost.setReqExperience(requiredExperience);
//        jobPost.setPostTechStack(postTechStack);
//        model.addAttribute("jobPost", jobPost);
//        return "success";
//    }
//     Note
//     unannotated non-simple-type parameter is treated as an implicit @ModelAttribute
//     and Spring tries to construct it via constructor binding.
//     explicitly annotated the parameter: @RequestParam("postTechStack") List<String> postTechStack.
