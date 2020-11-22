package banksystem.controller;

import banksystem.model.Count;
import banksystem.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/api/count")
public class CountController {

    @Autowired
    private CountService countService;

    @ResponseBody
    @GetMapping(value = "list")
    public List getCountList() {
        return countService.getAll();
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public Count getCountById(@PathVariable("id") Long id) {
        return countService.getById(id);
    }

    @ResponseBody
    @GetMapping(value = "/{id}/delete")
    public String deleteCountById(@PathVariable("id") Long id) {
        Count remoteCount = countService.getById(id);
        countService.delete(remoteCount);
        return "Count deleted";
    }

    @ResponseBody
    @PostMapping(value = "/create", produces = "application/json", consumes="application/json")
    public String addCount(@RequestBody Count count) {
        countService.create(count);
        return "Count added";
    }

    @ResponseBody
    @PostMapping(value = "/{id}/edit", produces = "application/json", consumes = "application/json")
    public String updateCount(@RequestBody Count count, @PathVariable("id") Long id) {
        Count countUpdated = countService.getById(id);
        countUpdated.setNumber(count.getNumber());
        countUpdated.setCurrency(count.getCurrency());
        countUpdated.setBalance(count.getBalance());
        countService.update(countUpdated);
        return "Count updated";
    }
}
