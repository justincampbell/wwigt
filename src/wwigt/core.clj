(ns wwigt.core
  (:use [clojure.string :only [join split]]))

(defn get-random-article
  "Gets a random article from Wikipedia"
  []
  "http://en.wikipedia.org/wiki/Sharks")

(defn path-from-url
  [url]
  (str "/" (join "/" (drop 3 (split url #"/")))))

(defn fetch []
  (let [url (get-random-article)]
    {:url url
     :path (path-from-url url)}))
