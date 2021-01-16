package banksystem.web.controller;

import banksystem.dao.model.Count;
import banksystem.service.CountService;
import banksystem.web.dto.CountDTO;
import banksystem.web.mapper.CountMapper;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
@Controller
@RequestMapping("/api/count")
public class CountController {

    @Autowired
    private CountService countService;

    private CountMapper countMapper = Mappers.getMapper(CountMapper.class);

    private static final Logger LOG = LoggerFactory.getLogger(CountController.class);

    @ResponseBody
    @GetMapping(value = "list")
    public List getCountList() {
        List counts = countService.getAll();
        return countMapper.convertToDTO(counts);
    }

    @GetMapping(value = "/{id}")
    public ModelAndView getCountById(@PathVariable("id") Long id, ModelAndView model) {
        CountDTO count = countMapper.convertToDTO(countService.getById(id));
        model.addObject("cardList", count.getCards());
        model.setViewName("showPersonalCards");
        return model;
    }

    @ResponseBody
    @GetMapping(value = "/{id}/delete")
    public Count deleteCountById(@PathVariable("id") Long id) {
        Count remoteCount = countService.getById(id);
        countService.delete(remoteCount);
        LOG.info("Client deleted an account - " + remoteCount.getNumber());
        return remoteCount;
    }

    @ResponseBody
    @PostMapping(value = "/create", produces = "application/json", consumes="application/json")
    public CountDTO addCount(@RequestBody @Valid CountDTO countDTO) {
        countService.saveOrUpdate(countMapper.convertToEntity(countDTO));
        LOG.info("Client created an account - " + countDTO.getNumber());
        return countDTO;
    }

    @ResponseBody
    @PostMapping(value = "/edit", produces = "application/json", consumes = "application/json")
    public CountDTO updateCount(@RequestBody @Valid CountDTO countDTO) {
        countService.saveOrUpdate(countMapper.convertToEntity(countDTO));
        return countDTO;
    }
}
