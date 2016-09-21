#!/bin/bash

for i in $(cat URLs.txt); do
    content="$(curl -s "$i")"
    echo "$content" 
done