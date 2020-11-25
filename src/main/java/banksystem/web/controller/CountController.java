package banksystem.web.controller;

import banksystem.dao.model.Count;
import banksystem.service.CountService;
import banksystem.web.dto.CountDTO;
import banksystem.web.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/api/count")
public class CountController {

    @Autowired
    private CountService countService;
    @Autowired
    private Mapper<CountDTO, Count> mapper;

    @ResponseBody
    @GetMapping(value = "list")
    public List getCountList() {
        List counts = countService.getAll();
        return mapper.convertToDTO(counts);
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public CountDTO getCountById(@PathVariable("id") Long id) {
        return mapper.convertToDTO(countService.getById(id));
    }

    @ResponseBody
    @GetMapping(value = "/{id}/delete")
    public Count deleteCountById(@PathVariable("id") Long id) {
        Count remoteCount = countService.getById(id);
        countService.delete(remoteCount);
        return remoteCount;
    }

    @ResponseBody
    @PostMapping(value = "/create", produces = "application/json", consumes="application/json")
    public CountDTO addCount(@RequestBody CountDTO countDTO) {
        countService.create(mapper.convertToEntity(countDTO));
        return countDTO;
    }

    @ResponseBody
    @PostMapping(value = "/edit", produces = "application/json", consumes = "application/json")
    public CountDTO updateCount(@RequestBody CountDTO countDTO) {
        countService.update(mapper.convertToEntity(countDTO));
        return countDTO;
    }
}
