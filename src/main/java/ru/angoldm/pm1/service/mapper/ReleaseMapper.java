package ru.angoldm.pm1.service.mapper;

import org.springframework.stereotype.Component;
import ru.angoldm.pm1.dto.ReleaseDto;
import ru.angoldm.pm1.entity.Release;

@Component
public class ReleaseMapper {

    public ReleaseDto toDto(Release release) {
        ReleaseDto releaseDto = new ReleaseDto();
        releaseDto.setId(release.getId());
        releaseDto.setTaskId(release.getTaskId());
        releaseDto.setStartDt(release.getStartDt());
        releaseDto.setEndDt(release.getEndDt());
        releaseDto.setVersion(release.getVersion());
        return releaseDto;
    }

    public Release toEntity(ReleaseDto releaseDto) {
        Release release = new Release();
        release.setId(releaseDto.getId());
        release.setTaskId(releaseDto.getTaskId());
        release.setStartDt(releaseDto.getStartDt());
        release.setEndDt(releaseDto.getEndDt());
        release.setVersion(releaseDto.getVersion());
        return release;
    }
}
