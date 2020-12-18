package no.cognizant.springandreact.controller;

import no.cognizant.springandreact.domain.Submission;
import no.cognizant.springandreact.domain.SubmittedTask;
import no.cognizant.springandreact.exception.ErrorResponse;
import no.cognizant.springandreact.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/api/submittask")
    public ResponseEntity submitTask(@RequestBody SubmittedTask submittedTask) throws Exception {
        return ok(taskService.process(submittedTask));
    }

    @GetMapping("/api/gettop3")
    public ResponseEntity<List<Submission>> getTop3() {
        return ok(taskService.getTop3Coder());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleAutoCompleteApiException() {
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).
                body(new ErrorResponse(500, "Something went wrong, try again after some time"));
    }
}
