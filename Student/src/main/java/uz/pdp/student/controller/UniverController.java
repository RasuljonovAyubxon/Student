package uz.pdp.student.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import uz.pdp.student.dao.UniverDao;
import uz.pdp.student.model.Univer;

import java.util.List;

@Controller
@RequestMapping("/Univer")
@RequiredArgsConstructor
public class UniverController {

    private final UniverDao UniverDao;

    @GetMapping
    public String create(Univer Univer){
          UniverDao.cerate(Univer);
        return "Univer";

    }
  @GetMapping
  public String read(Model model) {
      List<Univer> univers = UniverDao.read();
      model.addAttribute("Univers", univers);
      return "Univer";

  }
    @PutMapping("/edit")
    public String update(Univer  Univer) {
        UniverDao.update(Univer);
        return "redirect:/Univer";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        UniverDao.delete(id);
        return "redirect:/Univer";
    }
}