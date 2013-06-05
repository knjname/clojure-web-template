;;; This is an example to call a Java source located in this project from clj.
(ns calling-java)

(import example.Example)

(defn call-example [name]
  (Example/exampleGuess name))

(call-example "apple")                  ; For example:apple

