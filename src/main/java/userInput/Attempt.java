package userInput;

import java.util.ArrayList;
import java.util.List;

public class Attempt {
    private List<List<Integer>> input = new ArrayList<>();

    private Boolean status;

    private List<String> messages;

    public Attempt() {}

    public Attempt(List<List<Integer>> input, Boolean status, List<String> msgs) {
        this.input = input;
        this.status = status;
        this.messages = msgs;
    }


    public List<List<Integer>> getInput() {
        return input;
    }

    public void setInput(List<List<Integer>> input) {
        this.input = input;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
