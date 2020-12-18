package no.cognizant.springandreact.service;

import no.cognizant.springandreact.dao.SubmissionRepository;
import no.cognizant.springandreact.dao.TaskRepository;
import no.cognizant.springandreact.domain.Submission;
import no.cognizant.springandreact.domain.SubmitRestRequest;
import no.cognizant.springandreact.domain.SubmittedTask;
import no.cognizant.springandreact.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Component
public class TaskService {

    final String baseUrl = "https://rextester.com/rundotnet/api";
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private SubmissionRepository submissionRepository;

    private RestTemplate restTemplate = new RestTemplate();

    public boolean process(SubmittedTask submittedTask) throws Exception {

        //get input from database
        Task task = taskRepository.retrieveByName(submittedTask.getSelectedTask()).get(0);
        String input = task.getInput_parameters();
        String output = task.getOutput_parameters();

        //create data for rest service
        SubmitRestRequest submitRestRequest = new SubmitRestRequest();
        submitRestRequest.setProgram(submittedTask.getSolution());
        submitRestRequest.setInput(input);
        submitRestRequest.setLanguageChoice("4");
        submitRestRequest.setCompilerArgs("");

        CallRestSevice callRestSevice = new CallRestSevice(output, submitRestRequest).invoke();
        ResponseEntity<String> result = callRestSevice.getResult();
        boolean res = callRestSevice.isRes();

        //if (res) {
        //create the submission object
        //save the submission into submissions table
        Submission submission = new Submission();
        submission.setSolution(submittedTask.getSolution());
        submission.setTask_name(submittedTask.getSelectedTask());
        submission.setUserName(submittedTask.getUserName());
        submissionRepository.save(submission);
        //}

        return true;
    }


    public List<Submission> getTop3Coder() {
        return submissionRepository.getTop3Coder();
    }

    private class CallRestSevice {
        private String output;
        private SubmitRestRequest submitRestRequest;
        private ResponseEntity<String> result;
        private boolean res;

        public CallRestSevice(String output, SubmitRestRequest submitRestRequest) {
            this.output = output;
            this.submitRestRequest = submitRestRequest;
        }

        public ResponseEntity<String> getResult() {
            return result;
        }

        public boolean isRes() {
            return res;
        }

        public CallRestSevice invoke() throws URISyntaxException {
            URI uri = new URI(baseUrl);
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<SubmitRestRequest> request = new HttpEntity<>(submitRestRequest, headers);
            result = restTemplate.postForEntity(uri, request, String.class);
            res = result.getStatusCode() == HttpStatus.OK && result.getBody().equals(output);
            return this;
        }
    }
}
