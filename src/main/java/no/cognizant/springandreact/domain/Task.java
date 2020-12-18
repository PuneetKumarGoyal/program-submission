package no.cognizant.springandreact.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tasks")
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    @Column(name = "task_name")
    public String taskName;
    @Column(name = "description")
    public String description;
    @Column(name = "input_parameters")
    public String input_parameters;
    @Column(name = "output_parameters")
    public String output_parameters;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInput_parameters() {
        return input_parameters;
    }

    public void setInput_parameters(String input_parameters) {
        this.input_parameters = input_parameters;
    }

    public String getOutput_parameters() {
        return output_parameters;
    }

    public void setOutput_parameters(String output_parameters) {
        this.output_parameters = output_parameters;
    }
}
