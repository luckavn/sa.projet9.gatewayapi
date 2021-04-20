package com.axa.softwareacademy.apigateway.controller;

import com.axa.softwareacademy.apigateway.client.NoteClient;
import com.axa.softwareacademy.apigateway.model.Note;
import com.axa.softwareacademy.apigateway.request.NoteSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
@CrossOrigin
public class NoteController {

    private final NoteClient noteClient;

    /**
     * This endpoint is aimed to find note information
     * @param id is the unique id number of the note
     * @return the note
     */
    @GetMapping("id")
    public Note getNoteById(@RequestParam String id) {
        return noteClient.getNoteById(id);
    }

    /**
     * This endpoint is aimed to find all note of a patient
     * @param id is the unique id number of the patient
     * @return a list of notes
     */
    @GetMapping("patientId")
    public List<Note> getNoteByPatientId(@RequestParam String id) {
        return noteClient.getNoteByPatientIdList(id);
    }

    /**
     * This endpoint is aimed to find all notes present in database
     * @return a list of all notes
     */
    @GetMapping
    public List<Note> noteList() {
        return noteClient.getNoteList();
    }

    /**
     * This endpoint is aimed to add a note to database
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addNote(@RequestBody @Valid NoteSaveRequest noteSaveRequest) {
        noteClient.saveNote(noteSaveRequest);
    }

    /**
     * This endpoint is aimed to modify a note present in database
     * @param noteSaveRequest is a valid note request
     * @param id is the unique id number of the note to modify
     */
    @PutMapping
    public void modifyNote(@RequestBody @Valid NoteSaveRequest noteSaveRequest, @RequestParam String id) {
        noteClient.updateNote(noteSaveRequest, id);
    }

    /**
     * This endpoint is aimed to delete a note present in database
     * @param id is the unique id number of the note to delete
     */
    @DeleteMapping
    public void deleteNote(@RequestParam String id) {
        noteClient.deleteNote(id);
    }
}
