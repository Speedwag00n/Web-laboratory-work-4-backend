package ilia.nemankov.service;

import ilia.nemankov.dto.PointDTO;
import ilia.nemankov.mapper.PointMapper;
import ilia.nemankov.model.Point;
import ilia.nemankov.repository.PointRepository;
import ilia.nemankov.repository.UserRepository;
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
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public List<PointDTO> getPoints(double currentRadius, String tokenHeader) {
        String token = jwtUtil.getTokenFromHeader(tokenHeader);
        List<Point> entities = pointRepository.findByUserId(Long.parseLong(jwtUtil.getUserIdFromToken(token)));

        List<PointDTO> dtos = new ArrayList<>();
        for (Point entity : entities) {
            PointDTO dto = pointMapper.entityToDTO(entity);
            dto.setHitNow(isHit(dto.getX(), dto.getY(), currentRadius));
            dtos.add(dto);
        }

        return dtos;
    }

    @Override
    public PointDTO addPoint(PointDTO point, String tokenHeader) {
        Point entity = pointMapper.dtoToEntity(point);
        String token = jwtUtil.getTokenFromHeader(tokenHeader);
        entity.setUser(userRepository.findById(Long.parseLong(jwtUtil.getUserIdFromToken(token))));

        entity.setHit(isHit(entity.getX(), entity.getY(), entity.getR()));
        Point savedEntity = pointRepository.save(entity);

        PointDTO dto = pointMapper.entityToDTO(savedEntity);
        dto.setHitNow(dto.isHit());
        return dto;
    }

    private boolean isHit(double x, double y, double r) {
        return ((x >= 0) && (y >= 0) && (Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(r / 2, 2)))
                || ((x <= 0) && (y >= 0) && (y <= 2 * x + r))
                || ((x <= 0) && (y <= 0) && (-(r / 2) <= x) && (-r <= y));
    }

}
