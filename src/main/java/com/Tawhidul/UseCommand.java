package com.Tawhidul;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "use", aliases = { "u" }, description = "Use an exisiting template")
public class UseCommand implements Runnable {

  @Parameters(description = "Template files to use")
  List<File> templates;

  @Option(names = { "-o", "--output" }, description = "Output file names")
  List<File> outputs;

  @Override
  public void run() {
    Path templatePath = TGen.getTemplatesPath();
    Path currentPath = Paths.get(System.getProperty("user.dir"));
    for (int i = 0; i < templates.size(); i++) {
      File template = templates.get(i);
      File file = null;
      if (outputs != null) {
        file = outputs.get(i);
      }
      use(templatePath, currentPath, template, file);
    }
  }

  private void use(Path templatePath, Path currentPath, File template, File file) {
    try {
      if (file == null) {
        Files.copy(templatePath.resolve(template.getName()), currentPath.resolve(template.getName()),
            StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Using template: " + template.getName());
        return;
      }
      Files.copy(templatePath.resolve(template.getName()), currentPath.resolve(file.getName()),
          StandardCopyOption.REPLACE_EXISTING);

      File newFile = currentPath.resolve(file.getName()).toFile();
      newFile = Utils.replaceKeyWordWithFileName(newFile, Constants.keywordReplaceByFileName);

      System.out.println("Using template: " + template.getName() + " to '" + file.getName() + "'");
    } catch (IOException e) {
      System.err.println("Failed to use template: " + template.getName());
    }
  }

}
