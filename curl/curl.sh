#!/bin/bash

for i in $(cat URLs.txt); do
    content="$(curl -s "$i")"
    echo "$content" >> output.txt 
done

for i in $(cat URLs.txt); do
    content="$(curl -s "$i")"
    echo "$content" >> output.txt 
done

for i in $(cat URLs.txt); do
    content="$(curl -s "$i")"
    echo "$content" >> output.txt 
done

for i in $(cat URLs.txt); do
    content="$(curl -s "$i")"
    echo "$content" >> output.txt 
done

for i in $(cat URLs.txt); do
    content="$(curl -s "$i")"
    echo "$content" >> output.txt 
done
