package com.mohsinkd786.service;

import com.mohsinkd786.dto.ProjectDto;
import com.mohsinkd786.entity.Project;
import com.mohsinkd786.mapper.UserMapper;
import com.mohsinkd786.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final UserMapper mapper;

    public ProjectDto createProject(ProjectDto projectDto){
        Project entity = mapper.map(projectDto,Project.class);
        Project savedEntity = projectRepository.save(entity);
        ProjectDto savedDto = mapper.map(savedEntity,ProjectDto.class);
        return savedDto;
    }
}
