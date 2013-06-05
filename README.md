# clojure-web-pj

## Prerequisites

You will need [Leiningen][1] 1.7.0 or above installed.

[1]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:

    lein ring server

## How to ...

### build ClojureScript

    # You can choose one of auto/once/clean.
    lein cljsbuild auto

### build Java

    # This compiles all *.java sources located on /src/main/java.
    lein javac
	

