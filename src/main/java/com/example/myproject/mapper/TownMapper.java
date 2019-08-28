package com.example.myproject.mapper;

import com.example.myproject.dto.TownDto;
import com.example.myproject.model.Town;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class TownMapper {

    private ModelMapper mapper;

    public TownMapper(final ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Town toEntity(final TownDto townDto) {
        return Objects.isNull(townDto) ? null : mapper.map(townDto, Town.class);
    }

    public TownDto toDto(final Town town) {
        return Objects.isNull(town) ? null : mapper.map(town, TownDto.class);
    }

}
