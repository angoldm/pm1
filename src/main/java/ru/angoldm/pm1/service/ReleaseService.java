package ru.angoldm.pm1.service;

import ru.angoldm.pm1.dto.ReleaseDto;
import java.util.List;

public interface ReleaseService {

    ReleaseDto createRelease(ReleaseDto releaseDto);

    List<ReleaseDto> findAll();

    ReleaseDto updateRelease(ReleaseDto releaseDto, Long id);

    void delete(Long id);
}
