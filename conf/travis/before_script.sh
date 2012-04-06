#!/bin/bash

PLAY_HOME=./tmp/play-framework
PLAY_PACKAGE=play-${PLAY_VERSION}
PLAY_ZIP=${PLAY_PACKAGE}.zip
PLAY_DOWNLOAD=http://download.playframework.org/releases/${PLAY_ZIP}

wget ${PLAY_DOWNLOAD}
unzip -q ${PLAY_ZIP}
mv ${PLAY_PACKAGE} ${PLAY_HOME}
