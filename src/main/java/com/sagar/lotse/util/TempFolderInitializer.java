package com.sagar.lotse.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Objects;

@Slf4j
@Component
public class TempFolderInitializer implements CommandLineRunner {

    private static final String TMP_FOLDER_NAME = "tmp";

    @Override
    public void run(String... args) throws Exception {
        // Create tmp folder if it doesn't exist
        File tmpDir = getTempDirectory();
        if (!tmpDir.exists()) {
            tmpDir.mkdir();
            log.info("Created temp folder: {}", tmpDir.getAbsolutePath());
        }
        this.cleanTmpFolder();
        log.info("Temp folder initialized and cleaned: {}", tmpDir.getAbsolutePath());
    }

    private void deleteRecursively(File file) {
        if (file.isDirectory()) {
            for (File sub : Objects.requireNonNull(file.listFiles())) {
                deleteRecursively(sub);
            }
        }
        file.delete();
    }

    private void cleanTmpFolder() {
        // Clean contents if it already exists
        File tmpDir = getTempDirectory();
        File[] files = tmpDir.listFiles();
        if (files != null) {
            for (File file : files) {
                deleteRecursively(file);
            }
        }
        log.info("Temp folder cleaned: {}", tmpDir.getAbsolutePath());
    }

    private File getTempDirectory() {
        String projectRoot = System.getProperty("user.dir");
        return new File(projectRoot, TMP_FOLDER_NAME);
    }

    @Scheduled(cron = "0 0 0 * * SAT")
    public void scheduledCleanup() {
        log.info("Running scheduled weekly temp folder cleanup...");
        this.cleanTmpFolder();
    }
}
