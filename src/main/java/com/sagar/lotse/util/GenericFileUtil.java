package com.sagar.lotse.util;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Component
public class GenericFileUtil {

    public String saveFile(MultipartFile image) throws IOException {
        if (image.isEmpty()) {
            throw new RuntimeException("Image file not found.");
        }
        String originalFilename = image.getOriginalFilename();
        //  String fileExtension = FilenameUtils.getExtension(originalFilename);
        String location = System.getProperty("user.dir") + File.separator + "images" + File.separator;
        File file = new File(location);
        if (!file.exists()) {
            file.mkdir();
        }
        String fileName = UUID.randomUUID() + originalFilename;
        image.transferTo(new File(location + fileName));
        return location + fileName;
    }

    public String updateFile(MultipartFile image, String existingImage) throws IOException {
        String location = System.getProperty("user.dir") + File.separator + "images" + File.separator;
        String bak_location = System.getProperty("user.dir") + File.separator + "images_bak" + File.separator;
        File file = new File(location);
        File backupFile = new File(bak_location);
        if (!backupFile.exists()) {
            backupFile.mkdir();
        }
        if (!file.exists()) {
            file.mkdir();
        }
        Files.copy(file.toPath(), backupFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        deleteFile(file);
        return saveFile(image);
    }

    public void deleteFile(File image) {
        image.delete();
    }

    public void reSaveFile(String existingImage) throws IOException {
        String bak_location = System.getProperty("user.dir") + File.separator + "image_bak" + File.separator;
        String location = System.getProperty("user.dir") + File.separator + "image" + File.separator;
        Files.copy(Paths.get(bak_location + existingImage), Paths.get(location + existingImage), StandardCopyOption.COPY_ATTRIBUTES);
    }

    public Resource getFile(String existingImage) throws MalformedURLException {
        String location = System.getProperty("user.dir") + File.separator + "image" + File.separator;
        Path filePath = Paths.get(location).resolve(existingImage).normalize();
        return new UrlResource(filePath.toUri());
    }
}
