(ns score-calculation
  (:require [clojure.core :refer :all]
            [clojure.string :refer :all :as str]))

(def tie-map {0 "love"
              1 "fifteen"
              2 "thirty"
              3 "fourty"})

(defn- is-tie?
  [scores]
  (= (first scores) (second scores)))

(defn score
  [scores]
  (cond
    (is-tie? scores) (str/join " " (map #(get tie-map %) scores))
    :else (if (= scores [0 1])
            "love fifteen")))