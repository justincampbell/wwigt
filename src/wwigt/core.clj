(ns wwigt.core
  (:require [clojure.string :as string]))

(defn path-from-url
  [url]
  (->> (string/split url #"/")
       (drop 3)
       (string/join "/")
       (str "/")))

(defn get-item-title
  "Gets the title from a url"
  [url]
  (let [path (path-from-url url)]
    (last (string/split path #"/"))))

(defn get-random-article
  "Gets a random article from Wikipedia"
  []
  "http://en.wikipedia.org/wiki/Sharks")

(defn fetch []
  (let [url (get-random-article)]
    {:url url
     :path (path-from-url url)}))
