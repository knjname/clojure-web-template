(ns clojure-web-pj.handler
  (:use [compojure.core]
        [ring.adapter.jetty]
        [ring.middleware stacktrace]
        [hiccup.core]
        [hiccup.page]
        )
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/" [] (html5
               [:section
                [:h1 "Server started!"]]))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  "Application body wrapped with many middlewares."
  (-> app-routes
      ;; handler/site covers normally required features.
      (handler/site)
      ;; for debugging.
      (wrap-stacktrace)))

