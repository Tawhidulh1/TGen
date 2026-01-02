#!/usr/bin/env bash
echo "setting things up..."
GROUP_ID=$(mvn help:evaluate -Dexpression=project.groupId -q -DforceStdout)
ARTIFACT_ID=$(mvn help:evaluate -Dexpression=project.artifactId -q -DforceStdout)
VERSION=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)
curl -Ls https://sh.jbang.dev | bash -s - app install --name tgen "$GROUP_ID:$ARTIFACT_ID:$VERSION"
echo "DONE"
