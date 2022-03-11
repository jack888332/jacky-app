package demo.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/handlerForUploadFile")
public class HandlerForUploadFile {
    /**
     * 以传统方式上传文件
     */
    @RequestMapping("/uploadFile1")
    public String uploadFile1(HttpServletRequest request) throws Exception {
        System.out.println("uploadFile1() run");
        String path = request.getSession().getServletContext().getRealPath("/upload/");

        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> fileItems = upload.parseRequest(request);

        // 保存文件
        for (FileItem fileItem : fileItems) {
            if (fileItem.isFormField()) {
                System.out.println(fileItem.toString());
            } else {
                String uuid = UUID.randomUUID().toString().replace("-", "");
                fileItem.write(new File(path, fileItem.getFieldName() + "_" + uuid + ".ppt"));
                fileItem.delete();
            }
        }
        return "common/success";
    }

    /**
     * 以SpringMVC方式上传文件
     */
    @RequestMapping("/uploadFile2")
    public String uploadFile2(HttpServletRequest request, MultipartFile upload) throws IOException {
        System.out.println("uploadFile2() run");
        String path = request.getSession().getServletContext().getRealPath("/upload/");

        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }

        String uuid = UUID.randomUUID().toString().replace("-", "");
        upload.transferTo(new File(path, upload.getOriginalFilename() + "_" + uuid + ".ppt"));
        return "common/success";
    }

    /**
     * Jersey-Client 在 Servlet 中建立客户端向其他服务端发送请求，及传输文件数据
     * 此程序会发生异常，可以熟手debug
     */
    @RequestMapping("/uploadFile3")
    public String uploadFile3(MultipartFile upload) throws Exception {
        System.out.println("uploadFile3() run");
        //定义上传文件服务器路径
        String path = "http://localhost:8081/static_resources/";
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String fileName = uuid + "_" + upload.getOriginalFilename();

        //创建客户端
        Client client = Client.create();

        WebResource webResource = client.resource(new URI(path + fileName));
        webResource.post(upload.getBytes());
        return "common/success";
    }
}
