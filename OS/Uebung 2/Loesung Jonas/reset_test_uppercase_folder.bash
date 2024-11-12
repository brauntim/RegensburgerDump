#!/bin/bash

target_directory="/home/studies/RegensburgerDump/OS/Uebung 2/Loesung Jonas/test_uppercase_folder/"
filenames=( "Moin" "Meister" "AAAAAHHHHHHH" "nvm" )

rm -R "$target_directory"

mkdir "$target_directory"
mkdir "$target_directory"/as_lowercase

for filename in "${filenames[@]}"; do
  touch "$target_directory$filename.txt"
done
