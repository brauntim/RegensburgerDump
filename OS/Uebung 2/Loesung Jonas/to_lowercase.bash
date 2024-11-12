#!bin/bash

if [ -d "$1" ]; then 
  echo "First argument as source directory: $1"
  source_directory="$1"
  if [ -d "$2" ]; then 
    echo "Second argument as target directory: $2"
    target_directory="$2"
    echo "Files:"

    for file in `find "$source_directory" -maxdepth 1 -type f -printf "%f\n"`; do
      echo "- $file"

      if [ "$file" = "${file,,}" ]; then
        echo "  File is already lowercase"
        cp "$source_directory""$file" "$target_directory$file"
      else
        echo "  Converting file to lowercase"
        cp "$source_directory$file" "$target_directory${file,,}"
      fi
    done
  else
    echo "Second argument is not a directory"
  fi
else
  echo "First argument is not a directory"
fi

