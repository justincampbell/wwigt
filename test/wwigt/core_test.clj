(ns wwigt.core-test
  (:require [clojure.test :refer :all]
            [wwigt.core :refer :all]
            :reload))

(def url "http://en.wikipedia.org/wiki/Sharks")

(deftest fetch-test
  (testing "returns a map with the required attributes"
    (is (string? (:path (fetch))))
    (is (string? (:url (fetch))))
    (is (string? (:title (fetch))))))

(deftest get-random-article-test
  (testing "returns a url from provider"
    (is (string? (get-random-article)))))

(deftest path-from-url-test
  (testing "returns the path from a url"
   (is (= "/wiki/Sharks" (path-from-url url)))))

(deftest title-from-url-test
  (testing "fetches and parses HTML from a url and extracts the title"
    (is (= "Sharks"  (title-from-url url)))))
