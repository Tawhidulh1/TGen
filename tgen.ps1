# converted from bash
Write-Host "setting things up..."
$GROUP_ID = mvn help:evaluate -Dexpression=project.groupId -q -DforceStdout
$ARTIFACT_ID = mvn help:evaluate -Dexpression=project.artifactId -q -DforceStdout
$VERSION = mvn help:evaluate -Dexpression=project.version -q -DforceStdout
Invoke-Expression ((Invoke-WebRequest -Uri "https://sh.jbang.dev").Content + " app install --name tgen $GROUP_ID`:$ARTIFACT_ID`:$VERSION")
Write-Host "DONE"

