(ns wwigt.view
  (:require [clojure.string :as string]
            [hiccup.element :refer :all]
            [hiccup.page :refer :all]))

(defn show [{:keys [title url]}]
  (html5
    [:head
     [:title title]]
    [:body
     [:h1 "Maybe you were going to learn about "
      (link-to url title)]]))
