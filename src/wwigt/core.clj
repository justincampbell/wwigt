(ns wwigt.core
  (:require [clojure.string :as string]))

(defn get-random-article
  "Gets a random article from Wikipedia"
  []
  "http://en.wikipedia.org/wiki/Sharks")

(defn path-from-url
  [url]
  (->> (string/split url #"/")
       (drop 3)
       (string/join "/")
       (str "/")))

(defn fetch []
  (let [url (get-random-article)]
    {:url url
     :path (path-from-url url)}))
