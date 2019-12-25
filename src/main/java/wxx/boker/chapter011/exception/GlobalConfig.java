package wxx.boker.chapter011.exception;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@ControllerAdvice//全局处理
@Slf4j
public class GlobalConfig {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CommonException.class)
    public CommonException getMultipFileException(CommonException e) {
        log.info(e.getErrorMsg());
        return new CommonException(e.getErrorCode(), e.getErrorMsg());
    }


    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public CommonException getFileMixException(MaxUploadSizeExceededException e, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        @Cleanup PrintWriter pw = null;
        try {
            pw = response.getWriter();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        pw.write("上传文件超出大小");
        pw.flush();
        pw.close();
        return new CommonException("1111", pw.toString());
    }

}
