package awesome;

import awesome.response.ResponseCommonData;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Objects;

//@ControllerAdvice
//public class GlobalExceptionHandler {
//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    @ResponseBody
//    public String MyExceptionHandle(MethodArgumentNotValidException exception){
//        exception.printStackTrace();
//        BindingResult result = exception.getBindingResult();
//        StringBuilder errorMsg = new StringBuilder() ;
//
//        if (result.hasErrors()) {
//            List<FieldError> fieldErrors = result.getFieldErrors();
//            fieldErrors.forEach(error -> {
//                System.out.println("field" + error.getField() + ", msg:" + error.getDefaultMessage());
//                errorMsg.append(error.getDefaultMessage()).append("!");
//            });
//        }
//
//        exception.printStackTrace();
////        return new JsonResult(-1,errorMsg.toString() );
//        return  errorMsg.toString();
//    }
//}
@ControllerAdvice
public class GlobalExceptionHandler {//不是控制器，仅仅是处理异常的类

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResponseCommonData handlerArithmeticException(BindException e) {
        System.out.println("我可以捕获任何类的异常");

		System.out.println(Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
        ResponseCommonData responseCommonData=new ResponseCommonData();
        responseCommonData.setStatus(-1);
        responseCommonData.setMsg(Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
        return  responseCommonData;
    }
}