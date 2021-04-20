package com.axa.softwareacademy.apigateway.client;

import com.axa.softwareacademy.apigateway.configuration.ClientConfiguration;
import com.axa.softwareacademy.apigateway.model.Note;
import com.axa.softwareacademy.apigateway.request.NoteSaveRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
        value = "noteClient",
        url = "${note.api.url}",
        configuration = ClientConfiguration.class
)
public interface NoteClient {

    @GetMapping(value = "/notes/id")
    Note getNoteById(@RequestParam String id);

    @GetMapping(value = "/notes")
    List<Note> getNoteList();

    @GetMapping(value = "/notes/patientId")
    List<Note> getNoteByPatientIdList(@RequestParam String id);

    @PostMapping("/notes")
    void saveNote(@RequestBody NoteSaveRequest noteSaveRequest);

    @PutMapping("/notes")
    void updateNote(@RequestBody NoteSaveRequest noteSaveRequest, @RequestParam String id);

    @DeleteMapping(value = "/notes")
    void deleteNote(@RequestParam String id);
}
