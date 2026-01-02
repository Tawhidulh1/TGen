package com.Tawhidul;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "add", description = "Add a new template")
public class AddCommand implements Runnable {
  @Option(names = { "-f", "--file" }, description = "file to add as template", required = true)
  private File file;

  @Override
  public void run() {
    Path templatePath = TGen.getTemplatesPath();
    try {
      Files.copy(file.toPath(), templatePath.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
    } catch (Exception e) {
      System.err.println("failed adding template: " + file.getName());
      e.printStackTrace();
    }
  }

}
