#!/bin/bash -x

# This script is for downloading the CLI

GOOGLE_CLI_BASE_URL="https://dl.google.com/dl/cloudsdk/channels/rapid/downloads/google-cloud-cli-387.0.0-linux" 
AWS_CLI_BASE_URL="https://awscli.amazonaws.com/awscli-exe-linux"

if [[ $1 =~ "Intel" ]]
then 
    echo -e "\n****** Downloadig CLI for INTEL processor ******\n"
    curl $GOOGLE_CLI_BASE_URL-x86_64.tar.gz -o /tmp/google-cloud-sdk.tar.gz
    curl $AWS_CLI_BASE_URL-x86_64.zip -o awscliv2.zip
else 
    echo -e "\n****** Downloadig CLI for M1 processor ******\n"
    curl $GOOGLE_CLI_BASE_URL-arm.tar.gz -o /tmp/google-cloud-sdk.tar.gz
    curl $AWS_CLI_BASE_URL-aarch64.zip -o awscliv2.zip
fi