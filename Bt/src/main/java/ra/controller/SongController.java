package ra.controller;

import ra.model.dto.SongDto;
import ra.model.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;
    @GetMapping
    public String home(Model model){
        model.addAttribute("list",songService.findAll());
        return "home";
    }
    @GetMapping("/add")
    public ModelAndView add(){
        return new ModelAndView("add","song",new SongDto());
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id){
        return new ModelAndView("edit","song",songService.findById(id));
    }
    @GetMapping ("/delete/{id}")
    public String delete(@PathVariable Long id){
        songService.delete(id);
        return "redirect:/";
    }
    @PostMapping("add")
    public String doAdd (@ModelAttribute SongDto songDto){
        songService.save(songDto);
        return "redirect:/";
    }
    @PostMapping("/update")
    public String doUpdate(@ModelAttribute SongDto songDto){
        songService.save(songDto);
        return "redirect:/";
    }
}