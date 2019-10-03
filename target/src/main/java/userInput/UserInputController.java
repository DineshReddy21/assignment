package userInput;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import userInput.Attempt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserInputController {
    public List<Attempt> attempts = new ArrayList<>();
    public ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/history")
    public List<Attempt> history() {
        return attempts;
    }

    @PostMapping("/findSimilar")
    public ResponseEntity findSimilar(@RequestBody List<List<Integer>> input) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Attempt a = new UserInputService().processInput(input);
        attempts.add(a);
        if(a.getStatus()) {
            return new ResponseEntity<>(objectMapper.writeValueAsString(a), headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(objectMapper.writeValueAsString(a), headers, HttpStatus.BAD_REQUEST);
        }
    }
}
