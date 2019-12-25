package wxx.boker.chapter011.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
@Slf4j
public class UploadController {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @ApiOperation(value = "单文件上传" , notes = "单文件NOTES")
    @PostMapping("/upload")
    public String uploafFile(MultipartFile multipartFile, HttpServletRequest httpServletRequest) {
        String readPath = httpServletRequest.getSession().getServletContext().getRealPath("/uploadFile");
        String format = sdf.format(new Date());

        File folder = new File(readPath + format);
        log.info("folder -->"+readPath+format);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }

        String oldName = multipartFile.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."), oldName.length());
        try {
            multipartFile.transferTo(new File(folder, newName));
            String filePath = httpServletRequest.getScheme() + "://" +
                    httpServletRequest.getServerName() + ":"
                    + httpServletRequest.getServerPort() + "/uploadFile" + format + newName;
            return filePath;
        } catch (IOException ioe) {
            log.info(ioe.toString());
        }
        return "上传失败";
    }

    @ApiOperation(value = "自定义500错误" , notes = "错误展示")
    @GetMapping("/getErrorMesg500")
    public String getEoor500(){
        int c =1/0;
        return "ccc";

    }

}
