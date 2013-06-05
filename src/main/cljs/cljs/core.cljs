(ns cljs.core
  ;; Only limited use form is supported.
  (:use-macros [clojure-web-pj.commonmacros :only [duplicate-form] ]))

(defn ^:export main []
  (duplicate-form
   (.log js/console "Hello ClojureScript!")))
