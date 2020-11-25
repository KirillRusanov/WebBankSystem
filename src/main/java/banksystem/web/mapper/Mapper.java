package banksystem.web.mapper;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
abstract public class Mapper<K, V> {

    public abstract K convertToDTO(V Entity);

    public abstract V convertToEntity(K DTO);

    public List<K> convertToDTO(List<V> list) {
        List<K> listDTO = new ArrayList<>();
        for (V entity : list) {
            listDTO.add(convertToDTO(entity));
        }
        return listDTO;
    }

}