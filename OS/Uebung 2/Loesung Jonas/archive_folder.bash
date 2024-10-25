#!/bin/bash

if [ -n "$1" ]; then
  if [ -n "$2" ]; then
    if [ -f "$1" ]; then
      echo "File $1 already exists"
    else
      if [ -d "$2" ]; then
        echo "Archiving directory"

        tar --create --file "$1.tar" "$2"
      else
        echo "Directory $2 is not existing"
      fi
    fi
  else
    echo "No directory given"
  fi
else
  echo "No file given"
fi
