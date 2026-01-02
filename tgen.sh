#!/usr/bin/env bash
echo "Setting things up..."
mvn clean install -q
GROUP_ID=$(mvn help:evaluate -Dexpression=project.groupId -q -DforceStdout)
ARTIFACT_ID=$(mvn help:evaluate -Dexpression=project.artifactId -q -DforceStdout)
VERSION=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)
curl -Ls https://sh.jbang.dev | bash -s - app install --force --name tgen "$GROUP_ID:$ARTIFACT_ID:$VERSION"
echo "DONE"
