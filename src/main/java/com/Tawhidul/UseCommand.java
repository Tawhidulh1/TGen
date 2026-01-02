package com.Tawhidul;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "use", description = "Use an exisiting template")
public class UseCommand implements Runnable {
  @Option(names = { "-f", "--file" }, description = "template file to copy", required = true)
  File template;

  @Option(names = { "-n", "--name" }, description = "name of target", required = false)
  String name;

  @Override
  public void run() {
    Path templatePath = TGen.getTemplatesPath();
    Path workingPath = Paths.get(System.getProperty("user.dir"));
    template = templatePath.resolve(template.getName()).toFile();
    try {
      if (name == null) {
        Files.copy(templatePath.resolve(template.getName()), workingPath.resolve(template.getName()),
            StandardCopyOption.REPLACE_EXISTING);
        return;
      } else {
        Files.copy(templatePath.resolve(template.getName()), workingPath.resolve(name),
            StandardCopyOption.REPLACE_EXISTING);
      }
    } catch (Exception e) {
      System.out.println("Failed to use template: " + template.getName());
      e.printStackTrace();
    }
  }

}
