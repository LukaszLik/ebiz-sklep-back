#!/usr/bin/bash

sbt dist

docker build --build-arg APP_FILE=/target/universal/\*.zip . -t frsh22/ebiz-back --no-cache

docker push frsh22/ebiz-back
