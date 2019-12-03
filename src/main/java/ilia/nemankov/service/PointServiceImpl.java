package ilia.nemankov.service;

import ilia.nemankov.dto.PointDTO;
import ilia.nemankov.mapper.PointMapper;
import ilia.nemankov.model.Point;
import ilia.nemankov.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointServiceImpl implements PointService {

    @Autowired
    private PointMapper pointMapper;

    @Autowired
    private PointRepository pointRepository;

    @Override
    public PointDTO addPoint(PointDTO point) {
        Point entity = pointMapper.dtoToEntity(point);
        Point savedEntity = pointRepository.save(entity);
        return pointMapper.entityToDTO(savedEntity);
    }

}
