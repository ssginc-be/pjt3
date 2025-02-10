#!/bin/bash

# 25-02-10
# Deployer by Queue-ri

GREEN='\033[0;32m'
PURPLE='\033[1;35m'
NOCOLOR='\033[0m'

echo -e "\n${GREEN}** Deployer by Queue-ri${NOCOLOR}"

echo -e "\n${PURPLE}** Check Current Path${NOCOLOR}"
pwd

echo -e "\n${PURPLE}** Go to Working Directory${NOCOLOR}"
cd /home/ubuntu

echo -e "\n${PURPLE}** (PRE) Check Container List${NOCOLOR}"
docker ps

echo -e "\n${PURPLE}** Cleanup Old Containers${NOCOLOR}"
docker compose down
docker rm -v $(docker ps -qa)

echo -e "\n${PURPLE}** Compose Latest Image${NOCOLOR}"
docker compose up -d

echo -e "\n${PURPLE}** (POST) Check Container List${NOCOLOR}"
docker ps