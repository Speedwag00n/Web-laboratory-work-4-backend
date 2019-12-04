package ilia.nemankov.service;

import ilia.nemankov.dto.PointDTO;
import ilia.nemankov.mapper.PointMapper;
import ilia.nemankov.model.Point;
import ilia.nemankov.repository.PointRepository;
import ilia.nemankov.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PointServiceImpl implements PointService {

    @Autowired
    private PointMapper pointMapper;

    @Autowired
    private PointRepository pointRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public List<PointDTO> getPoints(String tokenHeader) {
        String token = jwtUtil.getTokenFromHeader(tokenHeader);
        List<Point> entities = pointRepository.findByUserId(Integer.parseInt(jwtUtil.getUserIdFromToken(token)));
        List<PointDTO> dtos = new ArrayList<>();
        for (Point entity : entities) {
            dtos.add(pointMapper.entityToDTO(entity));
        }
        return dtos;
    }

    @Override
    public PointDTO addPoint(PointDTO point, String tokenHeader) {
        Point entity = pointMapper.dtoToEntity(point);
        String token = jwtUtil.getTokenFromHeader(tokenHeader);
        entity.setUserId(Integer.parseInt(jwtUtil.getUserIdFromToken(token)));
        Point savedEntity = pointRepository.save(entity);
        return pointMapper.entityToDTO(savedEntity);
    }

}
