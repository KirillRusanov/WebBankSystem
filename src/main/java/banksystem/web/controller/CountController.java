package banksystem.web.controller;

import banksystem.dao.model.Count;
import banksystem.service.CountService;
import banksystem.web.dto.CountDTO;
import banksystem.web.mapper.ClientMapper;
import banksystem.web.mapper.CountMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/api/count")
public class CountController {

    @Autowired
    private CountService countService;

    private CountMapper countMapper = Mappers.getMapper(CountMapper.class);

    @ResponseBody
    @GetMapping(value = "list")
    public List getCountList() {
        List counts = countService.getAll();
        return countMapper.convertToDTO(counts);
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public CountDTO getCountById(@PathVariable("id") Long id) {
        return countMapper.convertToDTO(countService.getById(id));
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
        countService.saveOrUpdate(countMapper.convertToEntity(countDTO));
        return countDTO;
    }

    @ResponseBody
    @PostMapping(value = "/edit", produces = "application/json", consumes = "application/json")
    public CountDTO updateCount(@RequestBody CountDTO countDTO) {
        countService.saveOrUpdate(countMapper.convertToEntity(countDTO));
        return countDTO;
    }
}
