/**
 * Created by ovidiucb
 */
package com.ovidiucb.webapp;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController implements ErrorController {

    private static final String UPLOAD_DIRECTORY = "uploads/";
    private static final String DEFAULT_FILE_NAME = "shapes.json";
    @Autowired
    private WebAppShapeSerializer serializer;

    @RequestMapping(value="/upload", method=RequestMethod.GET)
    public @ResponseBody String provideUploadInfo() {
        return "You can upload a file by posting to this same URL.";
    }

    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public @ResponseBody String upload(@RequestParam("name") String name,
                                                 @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            String fullFileName = new StringBuilder().append(UPLOAD_DIRECTORY).append(name).toString();
            File f = new File(fullFileName);
            f.getParentFile().mkdirs();

            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(fullFileName)));
                stream.write(bytes);
                stream.close();
                return new StringBuilder().append("You successfully uploaded ")
                        .append(name).append("!").append("<br><br>").append(serializer.readFromFile(fullFileName)).toString();
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }

    @RequestMapping(value="/save")
    public @ResponseBody String save() {
        String fullFileName = new StringBuilder().append(UPLOAD_DIRECTORY).append(DEFAULT_FILE_NAME).toString();

        File file = new File(fullFileName);
        file.getParentFile().mkdirs();

        serializer.writeToFile(fullFileName);

        return new StringBuilder().append("Successfully saved file: ").append(fullFileName).toString();
    }

    @RequestMapping(value="/error")
    public @ResponseBody String getError() {
        return "Some error";
    }

    @Override
    public String getErrorPath() {
        return "Error";
    }
}
