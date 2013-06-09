# clojure-web-pj

## Running

To start a web server for the application, run:

    lein ring server

REPL will be also activated, connect to:

    localhost:7979


## How to ...

### build ClojureScript

    # You can choose one of auto/once/clean.
    lein cljsbuild auto

### build Java

    # This compiles all *.java sources located on /src/main/java.
    lein javac
	
### build Groovy

    # This compiles all *.groovy sources located on /src/main/groovy.
	lein groovyc 

	
### build Scala

    # This compiles all *.scala sources located on /src/main/scala.
	lein scalac 
