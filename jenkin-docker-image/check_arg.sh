#!/bin/bash -x

# This script is for checking the argument has been passed and correct processor type

if [ -z $1 ]
then 
    echo -e "\n****** Warning!!!! ******\n"
    echo -e "\n****** PROCESSOR arg is not provided! ******\n"
    exit 1
fi

if [[ $1 =~ "Intel" ]] || [[ $1 =~ "M1" ]]
then
    echo -e "\n****** PROCESSOR: $1! Going for next step ******\n"
else
    echo -e "\n****** Oops, Sorry mate! Did not match with the expected value ******\n"
    exit 1
fi