
;;; You can see example which covers widely our desires at:
;;; https://github.com/technomancy/leiningen/blob/stable/sample.project.clj

;; You can externalize variables.
(def java-source-paths ["src/main/java"])

;; Function is also supported
(defn src-path [lang]
  (str "src/main/" lang))

(defproject clojure-web-pj "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]         ; Language core
                 [org.clojure/clojure-contrib "1.2.0"] ; Utilities
                 [compojure "1.1.5"]    ; URL<=>Function mappings
                 [ring "1.1.8"]         ; HTTP interface
                 [hiccup "1.0.3"]       ; HTML generator
                 [lib-noir "0.5.2"]     ; Web libs
                 [org.clojure/clojurescript "0.0-1806"] ; Clojure on JavaScript
                 ]

  ;; You can access variable defined out of defproject with ~(unquote).
  :java-source-paths ~java-source-paths
  ;; You can also access function defined out of defproject.
  :source-paths [~(src-path "clj")] 
  :plugins [[lein-ring "0.8.5"]
            [lein-cljsbuild "0.3.2"]]
  :ring {:handler clojure-web-pj.handler/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.3"]]}}
  :cljsbuild {
              :builds [{:source-paths ["src/main/cljs" "src/main/clj"]
                        :compiler {:output-to "target/js/main.js"
                                   :optimizations :whitespace
                                   :pretty-print true}}]
              }
  )
