(ns wwigt.view-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :refer :all]
            [wwigt.view :refer :all]
            :reload-all))

(deftest test-view
  (testing "show"
    (is (= "<html><head><title>Sharks</title></head><body><h1>Sharks</h1></body></html>"
           (show {:title "Sharks"})))))
