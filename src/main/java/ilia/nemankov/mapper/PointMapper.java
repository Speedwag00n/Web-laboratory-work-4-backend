package ilia.nemankov.mapper;

import ilia.nemankov.dto.PointDTO;
import ilia.nemankov.model.Point;
import org.springframework.stereotype.Component;

@Component
public class PointMapper {

    public Point dtoToEntity(PointDTO dto) {
        Point entity = new Point();

        entity.setX(dto.getX());
        entity.setY(dto.getY());
        entity.setR(dto.getR());
        ///TODO calculate hit and userId
        entity.setUserId(1);
        entity.setHit(false);

        return entity;
    }

    public PointDTO entityToDTO(Point entity) {
        PointDTO dto =  new PointDTO();

        dto.setId(entity.getId());
        dto.setX(entity.getX());
        dto.setY(entity.getY());
        dto.setR(entity.getR());
        dto.setHit(entity.isHit());

        return dto;
    }

}
