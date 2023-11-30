package com.example.service;

import com.example.entities.Note;
import com.example.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
@RequiredArgsConstructor
@Log4j
public class NoteService {
    private final NoteRepository noteRepository;

    public List<Note> findAll() {
        log.info("Finding all notes");
        return noteRepository.findAll();
    }

    public void save(Note note) {
        if (note == null) {
            throw new IllegalArgumentException("Note cannot be null");
        }
        noteRepository.save(note);
        log.info("Saved note with id: " + note.getId());
    }

    public void deleteById(long id) {
        noteRepository.deleteById(id);
        log.info("Deleted note with id: " + id);
    }


    public Note findById(Long id) {
        log.info("Finding note by id: " + id);
        return noteRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Note not found with id: " + id);
                    return new EntityNotFoundException("Note not found with id: " + id);
                });
    }
}
