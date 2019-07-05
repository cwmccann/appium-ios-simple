#!/usr/bin/env bash

DEVICE=9b5425679b8d5d175af4d0a3477ae64a811287c9
PROFILE_PATH=${HOME}/projects/mcellblock/mcb-node/build/dist/lib/ios/miwdev.developerprofile
PROFILE_PASSWORD='set this'
DEV_DISK_PATH=${HOME}/projects/mcellblock/mcb-node/build/dist/lib/ios/dev-images
LICENSE_PATH=${HOME}/projects/mcellblock/mcb-node/./build/dist/lib/ios/374685CE.license
PORT=40001

${HOME}/xcuitrunner/xcuitrunner run \
--udid ${DEVICE} \
--developerProfile ${PROFILE_PATH} \
--developerProfilePassword  ${PROFILE_PASSWORD} \
--developerDiskDir  ${DEV_DISK_PATH} \
--license ${LICENSE_PATH} \
--forward ${PORT} \
--verbose | tee xcuitrunner.log
