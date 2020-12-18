package no.cognizant.springandreact.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubmittedTask {
    @JsonProperty(value = "username")
    public String userName;
    @JsonProperty(value = "selectedtask")
    public String selectedTask;
    @JsonProperty(value = "description")
    public String description;
    @JsonProperty(value = "solution")
    public String solution;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSelectedTask() {
        return selectedTask;
    }

    public void setSelectedTask(String selectedTask) {
        this.selectedTask = selectedTask;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
}
