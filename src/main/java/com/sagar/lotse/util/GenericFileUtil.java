package com.sagar.lotse.util;

import com.sagar.lotse.common.constant.CommonMessages;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class GenericFileUtil implements CommonMessages {

    private final HttpServletResponse httpServletResponse;

    public String saveFileToTemp(MultipartFile image) throws IOException {
        if (image.isEmpty()) {
            throw new RuntimeException("Image file not found.");
        }
        String originalFilename = image.getOriginalFilename();
        String location = System.getProperty("user.dir") + File.separator + "images" + File.separator;
        String backupLocation = System.getProperty("user.dir") + File.separator + "tmp" + File.separator;
        File file = new File(backupLocation);
        createDirectory(file, null);
        assert originalFilename != null;
        String fileName = UUID.randomUUID() + "_" + originalFilename.replace(" ", "");
        image.transferTo(new File(backupLocation + fileName.trim()));
        return location + fileName;
    }

    public String saveFileToTempForUpdate(MultipartFile image) throws IOException {
        if (image.isEmpty()) {
            throw new RuntimeException("Image file not found.");
        }
        String originalFilename = image.getOriginalFilename();
        String backup_location = System.getProperty("user.dir") + File.separator + "images_bak" + File.separator;
        String tmp_location = System.getProperty("user.dir") + File.separator + "tmp" + File.separator;
        File file = new File(tmp_location);
        createDirectory(file, null);
        assert originalFilename != null;
        String fileName = UUID.randomUUID() + "_" + originalFilename.replace(" ", "");
        image.transferTo(new File(tmp_location + fileName.trim()));
        return tmp_location + fileName;
    }

    public String saveFile(String existingImage) throws IOException {
        String location = System.getProperty("user.dir") + File.separator + "images" + File.separator;
        String bak_location = System.getProperty("user.dir") + File.separator + "tmp" + File.separator;
        File file = new File(location);
        File backupFile = new File(bak_location);
        createDirectory(file, backupFile);
        if (existingImage.contains(location)) {
            existingImage = existingImage.replace(location, "");
        } else {
            existingImage = existingImage.replace(bak_location, "");
        }
        Files.copy(Paths.get(backupFile + File.separator + existingImage),
                Paths.get(file + File.separator + existingImage), StandardCopyOption.REPLACE_EXISTING);
        deleteFile(bak_location + existingImage);
        return location + existingImage;
    }

    private void createDirectory(File file, File backupFile) {
        if (Objects.nonNull(backupFile) && !backupFile.exists() && !backupFile.mkdirs()) {
            log.info(FAILED_TO_CREATE_IMAGE_DIRECTORY);
            throw new RuntimeException(FAILED_TO_CREATE_IMAGE_DIRECTORY);
        }

        if (!file.exists() && !file.mkdirs()) {
            log.info(FAILED_TO_CREATE_TMP_DIRECTORY);
            throw new RuntimeException(FAILED_TO_CREATE_TMP_DIRECTORY);
        }

    }

    public String updateFile(MultipartFile image, String existingImage) throws IOException {
        String location = System.getProperty("user.dir") + File.separator + "images" + File.separator;
        String bak_location = System.getProperty("user.dir") + File.separator + "images_bak" + File.separator;
        File file = new File(location);
        File backupFile = new File(bak_location);
        createDirectory(file, backupFile);
        existingImage = existingImage.replace(location, "");
        Files.copy(Paths.get(location + File.separator + existingImage),
                Paths.get(bak_location + File.separator + existingImage), StandardCopyOption.REPLACE_EXISTING);
        deleteFile(location + existingImage);
        return saveFileToTempForUpdate(image);
    }

    public void deleteFile(String existingImage) throws IOException {
        if (!Files.deleteIfExists(Paths.get(existingImage))) {
            log.info(FAILED_TO_DELETE_IMAGE);
            throw new IOException(FAILED_TO_DELETE_IMAGE);
        }
    }

    public void reSaveFile(String existingImage) throws IOException {
        String bak_location = System.getProperty("user.dir") + File.separator + "image_bak" + File.separator;
        String location = System.getProperty("user.dir") + File.separator + "image" + File.separator;
        Files.copy(Paths.get(bak_location + existingImage), Paths.get(location + existingImage), StandardCopyOption.COPY_ATTRIBUTES);
    }

    public void getFile(String existingImage) {
        try {
            File file = new File(existingImage);
            httpServletResponse.setContentType("image/jpeg");
            httpServletResponse.setHeader("Content-Disposition", "attachment; filename=" + existingImage);
            FileCopyUtils.copy(new FileInputStream(file), httpServletResponse.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(FAILED_TO_FETCH_IMAGE);
        }
    }
}
