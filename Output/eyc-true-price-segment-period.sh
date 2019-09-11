#!/bin/bash
###############################################################################
#                               Documentation                                 #
###############################################################################
#                                                                             #
# Description                                                                 #
#     :
#                                                                             #
#                                                                             #
#                                                                             #
###############################################################################
#                           Identify Script Home                              #
################################################################################
#Find the script file home

pushd . > /dev/null

SCRIPT_DIRECTORY="${BASH_SOURCE[0]}";
while([ -h "${SCRIPT_DIRECTORY}" ]);
do
  cd "`dirname "${SCRIPT_DIRECTORY}"`"
  SCRIPT_DIRECTORY="$(readlink "`basename "${SCRIPT_DIRECTORY}"`")";
done
cd "`dirname "${SCRIPT_DIRECTORY}"`" > /dev/null
SCRIPT_DIRECTORY="`pwd`";
popd  > /dev/null
MODULE_HOME="`dirname "${SCRIPT_DIRECTORY}"`"
###############################################################################
#                           Import Dependencies                               #
###############################################################################

#Load common dependencies

. ${SCRIPT_DIRECTORY}/constants.sh
. ${SCRIPT_DIRECTORY}/common-functions.sh

###############################################################################
#                                Implementation                               #
###############################################################################


 fn_run_modular_bash_script \
    "eyc-true-price-segment-period" \
    ${INCREMENT_TYPE} \
    ${SCRIPT_PATH} \
    "sarthak.jain@safeway.com"