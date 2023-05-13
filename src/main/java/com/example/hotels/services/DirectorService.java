package com.example.hotels.services;

import com.example.hotels.models.Director;
import com.example.hotels.repositories.DirectorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DirectorService {

    private final DirectorRepository directorRepository;

    public List<Director> getDirectors() {
        return directorRepository.findAll();
    }

    public Director getDirector(Long id) {
        return directorRepository.findById(id).orElse(null);
    }

    public void saveDirector(Director director) {
        directorRepository.save(director);
    }

    public void deleteDirector(Long id) {
        directorRepository.deleteById(id);
    }

    public void editDirector(Long id, Director director) {
        director.setId(id);
        directorRepository.save(director);
    }
}
