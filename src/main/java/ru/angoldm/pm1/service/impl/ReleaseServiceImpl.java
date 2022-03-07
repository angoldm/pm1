package ru.angoldm.pm1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.angoldm.pm1.dto.ReleaseDto;
import ru.angoldm.pm1.entity.Release;
import ru.angoldm.pm1.exception.ReleaseIdNotFoundException;
import ru.angoldm.pm1.repository.ReleaseRepository;
import ru.angoldm.pm1.service.ReleaseService;
import ru.angoldm.pm1.service.mapper.ReleaseMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReleaseServiceImpl implements ReleaseService {

    private final ReleaseRepository releaseRepository;
    private final ReleaseMapper releaseMapper;

    @Autowired
    public ReleaseServiceImpl(ReleaseRepository releaseRepository,
                              ReleaseMapper releaseMapper) {
        this.releaseRepository = releaseRepository;
        this.releaseMapper = releaseMapper;
    }

    @Override
    public ReleaseDto createRelease(ReleaseDto releaseDto) {
        return releaseMapper.toDto(releaseRepository.save(releaseMapper.toEntity(releaseDto)));
    }

    @Override
    public List<ReleaseDto> findAll() {
        return releaseRepository.findAll()
                .stream()
                .map((releaseMapper::toDto))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        Release release = releaseRepository.findById(id)
                .orElseThrow(() -> new ReleaseIdNotFoundException(id));
        releaseRepository.delete(release);
    }
}
