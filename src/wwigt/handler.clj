(ns wwigt.handler
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [compojure.core :refer :all]
            [wwigt.core :refer :all]
            [wwigt.view :as view]))

(defn- redirect [url]
  {:status 302
   :headers {"Location" url}})

(defroutes app-routes
  (GET "/"
       []
       (redirect (:path (fetch))))

  (GET "/wiki/:title" request
       (let [path (:uri request)
             result (result-from-path path)]
        (view/show result)))

  (route/resources "/")
  (route/not-found "Not Found"))

(def app (handler/site app-routes))
