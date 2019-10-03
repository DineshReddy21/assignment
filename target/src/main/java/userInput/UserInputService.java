package userInput;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserInputService {
    public UserInputService(){}

    public Attempt processInput(List<List<Integer>> input) {
        Attempt n = new Attempt();
        n.setInput(input);
        if(input.size() < 2) {
            return new Attempt(input, false, Arrays.asList("please send atleast two arrays"));
        }

        if(findNonEmptyArray(input) < 2) {
            return new Attempt(input, false, Arrays.asList("please send atleast two non empty arrays"));
        }

        List<String> msgs = new ArrayList<>();
        int len = input.size();
        for(Integer i=0;i < len - 1;i++){
            List<Integer> arr = input.get(i);
            for(Integer j=i+1;j<len;j++) {
                List<Integer> temp = input.get(j);
                Boolean status = compare(new ArrayList<>(arr), new ArrayList<>(temp));
                if(status) {
                    msgs.add("Array " + i.toString() +  " and Array " + j.toString() + " are equal");
                }
            }
        }

        if(msgs.size() == 0) {
            msgs.add("none of the arrays matched");
        }

        n.setMessages(msgs);
        n.setStatus(true);
        return n;
    }

    public boolean compare(List<Integer> arr, List<Integer> temp) {
        if(arr.size() != temp.size()) {
            return false;
        }

        int count = 0;
        for(int k=0;k<arr.size();k++){
            for(int l=0;l<(temp.size());l++){
                if(arr.get(k)==temp.get(l)){
                    count++;
                    temp.remove(l);
                }
            }
        }
        return count==arr.size();
    }

    public Integer findNonEmptyArray(List<List<Integer>> arrs) {
        int len = arrs.size();
        int count =0;
        //validate
        for(int i=0;i<len;i++) {
            if(arrs.get(i).size() > 0) {
                count ++;
            }
        }
        return count;
    }
}
