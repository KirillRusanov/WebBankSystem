package banksystem.web.mapper;

import banksystem.dao.model.Count;
import banksystem.web.dto.CountDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CountMapper {

    // DTO

    public CountDTO convertToDTO(Count count) {
        return initializationDTO(count);
    }

    public List<CountDTO> convertToDTO(List<Count> counts) {
        List<CountDTO> countsDTO = new ArrayList<>();
        for(Count count : counts) {
            countsDTO.add(initializationDTO(count));
        }
        return countsDTO;
    }

    private CountDTO initializationDTO(Count count) {
        CountDTO countDTO = new CountDTO();
        countDTO.setId(count.getId());
        countDTO.setNumber(count.getNumber());
        countDTO.setBalance(count.getBalance());
        countDTO.setCurrency(count.getCurrency());
        return countDTO;
    }

    // ENTITY

    public Count convertToEntity(CountDTO countDTO) {
        return initializationEntity(countDTO);
    }

    public List<Count> convertToEntity(List<CountDTO> countsDTO) {
        List<Count> counts = new ArrayList<>();
        for(CountDTO count : countsDTO) {
            counts.add(initializationEntity(count));
        }
        return counts;
    }

    private Count initializationEntity(CountDTO countDTO) {
        Count count = new Count();
        count.setId(countDTO.getId());
        count.setNumber(countDTO.getNumber());
        count.setBalance(countDTO.getBalance());
        count.setCurrency(countDTO.getCurrency());
        return count;
    }
}