(ns wwigt.core-test
  (:require [clojure.test :refer :all]
            [wwigt.core :refer :all]
            :reload))

(def url "http://en.wikipedia.org/wiki/Sharks")
(def path "/wiki/Sharks")

(deftest fetch-test
  (testing "returns a map with the required attributes"
    (is (string? (:path (fetch))))
    (is (string? (:url (fetch))))
    (is (string? (:title (fetch))))))

(deftest result-from-path-test
  (testing "returns a map with the required attributes"
    (let [result (result-from-path path)]
      (is (string? (:path result)))
      (is (string? (:url result)))
      (is (string? (:title result))))))

(deftest get-random-article-test
  (testing "returns a url from provider"
    (is (string? (get-random-article)))))

(deftest path-from-url-test
  (testing "returns the path from a url"
   (is (= "/wiki/Sharks" (path-from-url url)))))

(deftest title-from-url-test
  (testing "fetches and parses HTML from a url and extracts the title"
    (is (= "Sharks"  (title-from-url url)))))

(deftest url-from-path-test
  (testing "creates a url from a path"
    (is (= "http://en.wikipedia.org/wiki/Sharks" (url-from-path path)))))
