package no.cognizant.springandreact.domain;

public class SubmitRestRequest {
    private String Program;
    private String Input;
    private String LanguageChoice = "4";
    private String CompilerArgs;

    public String getProgram() {
        return Program;
    }

    public void setProgram(String program) {
        Program = program;
    }

    public String getInput() {
        return Input;
    }

    public void setInput(String input) {
        Input = input;
    }

    public String getLanguageChoice() {
        return LanguageChoice;
    }

    public void setLanguageChoice(String languageChoice) {
        LanguageChoice = languageChoice;
    }

    public String getCompilerArgs() {
        return CompilerArgs;
    }

    public void setCompilerArgs(String compilerArgs) {
        CompilerArgs = compilerArgs;
    }
}
