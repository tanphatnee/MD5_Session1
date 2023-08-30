package bt.picture_nasa.controller;

import bt.picture_nasa.model.dto.FeedbackDto;
import bt.picture_nasa.model.service.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class FeedbackController {
    @Autowired
    private IFeedbackService feedbackService;
    @GetMapping
    public String home(Model model){
        model.addAttribute("list",feedbackService.findAll());
        model.addAttribute("form",new FeedbackDto());
        return "home";
    }

    @PostMapping()
    public String publish (@ModelAttribute FeedbackDto feedbackDto){
        feedbackService.save(feedbackDto);
        return "redirect:/";
    }
    @GetMapping("{id}")
    public String like (@PathVariable Long id){
        feedbackService.like(id);
        return "redirect:/";
    }


}
