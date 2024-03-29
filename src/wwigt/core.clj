(ns wwigt.core
  (:require [clojure.string :as string]
            [clj-http.client :as client]))

(defn path-from-url
  [url]
  (->> (string/split url #"/")
       (drop 3)
       (string/join "/")
       (str "/")))

(defn title-from-url
  "Gets the title from a url"
  [url]
  (let [path (path-from-url url)]
    (last (string/split path #"/"))))

(defn get-random-article
  "Gets a random article from Wikipedia"
  []
  (let [response (client/get "http://en.wikipedia.org/wiki/Special:Random"
                             {:follow-redirects false})
        headers (:headers response)
        location (get headers "Location")]
    location))

(defn url-from-path
  [path]
  (str "http://en.wikipedia.org" path))

(defn result-from-path
  [path]
  (let [url (url-from-path path)]
    {:url url
     :path path
     :title (title-from-url url)}))

(defn fetch []
  (let [url (get-random-article)]
    (result-from-path (path-from-url url))))
