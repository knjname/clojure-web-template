(ns clojure-web-pj.handler
  (:use [compojure.core]
        [ring.adapter.jetty]
        [ring.middleware stacktrace reload]
        [hiccup.core]
        [hiccup.page]
        [clojure.tools.nrepl.server :only (start-server stop-server)])
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

;;; Defs about web server's start/stop.
(def svr (atom nil))
(defn start-server
  "Start a web server."
  []
  (reset! svr
          (run-jetty #'app {:port 8080 :join? false})))
(defn stop-server []
  (.stop @svr))


;;; Defs about REPL's start/stop.
(def repl-svr (atom nil))
(defn start-repl-server
  "Start REPL server.
To connect it, on Emacs, M-x nrepl => localaddress:8999."
  []
  (reset! repl-svr
          (start-server :port 8999)))

(defn stop-repl-server []
  (stop-server @repl-svr))
