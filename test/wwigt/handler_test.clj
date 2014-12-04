(ns wwigt.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :refer :all]
            [wwigt.handler :refer :all]
            :reload-all))

(deftest test-app
  (testing "main route"
    (let [response (app (request :get "/"))]
      (is (= (:status response) 302))
      (is (re-find #"^/wiki/" (get (:headers response) "Location")))))

  (testing "wikipedia route"
    (let [response (app (request :get "/wiki/Sharks"))
          body (:body response)]
      (print body)
      (is (= (:status response) 200))
      (is (re-find #"Maybe you wanted to" body))
      (is (re-find #"Sharks" body))))

  (testing "not-found route"
    (let [response (app (request :get "/invalid"))]
      (is (= (:status response) 404)))))
