(ns wwigt.core-test
  (:require [clojure.test :refer :all]
            [wwigt.core :refer :all]
            :reload-all))

(def path "/wiki/Sharks")
(def url "http://en.wikipedia.org/wiki/Sharks")

(deftest fetch-test
  (testing "returns a map with the required attributes"
    (is (string? (:path (fetch))))
    (is (string? (:url (fetch))))))

(deftest get-random-article-test
  (testing "returns a url from provider"
    (is (= url (get-random-article)))))

(deftest path-from-url-test
  (testing "returns the path from a url"
   (is (= path (path-from-url url)))))

(deftest get-item-title-test
  (testing "fetches and parses HTML from a url and extracts the title"
    (is (= "Sharks"  (get-item-title url)))))
