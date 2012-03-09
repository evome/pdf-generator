# Evome PDF Generator

## Setup locally

### "Installing play"
```
mkdir ~/Development/Scala && cd $_
wget http://download.playframework.org/releases/play-2.0-RC3.zip
unzip play-2.0-RC3.zip
export PATH=$PATH:~/Development/Scala/play-2.0-RC3
```

### Running the app

Just type `play` in the project directory and then `run`

### Running the tests

Type `play` and then `test`

## Test it with curl

```
export TARGET=http://evome-pdf-generator.herokuapp.com
curl -v --form "data=@test-data/data.xml" --form "xslfo=@test-data/fo.xsl" $TARGET/pdf -o output.pdf
```

## TODO

* Make it secure
* Make it pretty
* Save the world
