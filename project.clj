(defproject wwigt "0.1.0-SNAPSHOT"
  :description "What was I going to ..."
  :url "http://example.com/FIXME"
  :min-lein-version  "2.0.0"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [clj-http "0.9.2"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.5"]
                 [javax.servlet/servlet-api "2.5"]]
  :plugins [[lein-ring "0.8.9"]]
  :ring {:handler wwigt.handler/app}
  :profiles {:dev {:dependencies [[ring-mock "0.1.5"]]}})
