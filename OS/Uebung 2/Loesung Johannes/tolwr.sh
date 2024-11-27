#!/bin/bash

DEBUG=0
SOURCE_DIR="."
TARGET_DIR=""
EXCLUDED_EXT=""

while getops ":ds:t:e:" opt; do
    case $opt in 
        d) DEBUG= 1;;
        s) SOURCE_DIR="$OPTARG"
        t) TARGET_DIR="$OPTARG"
        