package sky.pro.cw2_30082022.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (code = HttpStatus.BAD_REQUEST)
public class QuestionAlreadyExistException extends RuntimeException {
}
