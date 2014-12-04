(ns wwigt.view
  (:require [clojure.string :as string]
            [hiccup.core :refer :all]))

(defn show [data]
  (let [title (:title data)]
  (html
    [:head
     [:title title]
     :body
     [:h1 title]])))
