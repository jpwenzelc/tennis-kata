(ns score-calculation
  (:require [clojure.core :refer :all]
            [clojure.string :refer :all :as str]))

(def tie-map {0 "love"
              1 "fifteen"
              2 "thirty"
              3 "fourty"})

(defn- no-negative-input [input]
  (not (or (neg? (first input)) (neg? (second input)))))

(defn- is-valid?
  [input]
  (no-negative-input input))

(defn- to-tennis-score
  [score]
  (get tie-map score))

(defn- is-tie?
  [scores]
  (= (first scores) (second scores)))

(defn- is-deuce?
  [scores]
  (and (is-tie? scores) (< 2 (first scores))))

(defn- shout-score
  [scores]
  (str/join " " (map to-tennis-score scores)))

(defn score
  [scores]
  (if (is-valid? scores)
    (cond
      (is-deuce? scores) "deuce"
      :else (shout-score scores))
    "invalid input"))