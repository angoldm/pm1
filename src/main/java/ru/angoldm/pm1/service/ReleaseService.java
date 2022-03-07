package ru.angoldm.pm1.service;

import ru.angoldm.pm1.dto.ReleaseDto;
import java.util.List;

public interface ReleaseService {

    ReleaseDto createRelease(ReleaseDto releaseDto);

    List<ReleaseDto> findAll();

    void delete(Long id);
}
