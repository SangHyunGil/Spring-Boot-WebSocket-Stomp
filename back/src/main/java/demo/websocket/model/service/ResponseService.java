package demo.websocket.model.service;

import demo.websocket.response.MultipleResult;
import demo.websocket.response.Result;
import demo.websocket.response.SingleResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {

    public <T> SingleResult<T> getSingleResult(T data) {
        SingleResult<T> result = new SingleResult<>();
        result.setSuccess(true);
        result.setCode(0);
        result.setMsg("성공");
        result.setData(data);

        return result;
    }

    public <T> MultipleResult<T> getMultipleResult(List<T> data) {
        MultipleResult<T> result = new MultipleResult<>();
        result.setSuccess(true);
        result.setCode(0);
        result.setMsg("성공");
        result.setData(data);

        return result;
    }

    public Result getFailureResult(int code, String msg) {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(code);
        result.setMsg(msg);

        return result;
    }
}
