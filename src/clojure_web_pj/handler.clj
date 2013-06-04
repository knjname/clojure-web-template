(ns clojure-web-pj.handler
  (:use [compojure.core]
        [ring.adapter.jetty]
        [ring.middleware stacktrace reload]
        [hiccup.core]
        [hiccup.page])
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  "Application body wrapped with many middlewares."
  (-> app-routes
      ;; handler/site covers normally required features.
      (handler/site)
      ;; enables dynamic source reloading.
      (wrap-reload {:dirs ["src"]})
      ;; for debugging.
      (wrap-stacktrace)))

(def svr (atom nil))

(defn start-server
  "Start a web server."
  []
  (reset! svr
          (run-jetty #'app {:port 8080 :join? false})))

(defn stop-server []
  (.stop @svr))

