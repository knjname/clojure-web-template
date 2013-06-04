(ns clojure-web-pj.commonmacros)

(defmacro duplicate-form [form]
  `(do ~form ~form))

