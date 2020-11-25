package banksystem.web.mapper;

import banksystem.dao.model.Count;
import banksystem.web.dto.CountDTO;
import org.springframework.stereotype.Component;

@Component
public class CountMapper extends Mapper<CountDTO, Count> {

    @Override
    public CountDTO convertToDTO(Count count) {
        CountDTO countDTO = new CountDTO();
        countDTO.setId(count.getId());
        countDTO.setNumber(count.getNumber());
        countDTO.setBalance(count.getBalance());
        countDTO.setCurrency(count.getCurrency());
        return countDTO;
    }

    @Override
    public Count convertToEntity(CountDTO countDTO) {
        Count count = new Count();
        count.setId(countDTO.getId());
        count.setNumber(countDTO.getNumber());
        count.setBalance(countDTO.getBalance());
        count.setCurrency(countDTO.getCurrency());
        return count;
    }
}