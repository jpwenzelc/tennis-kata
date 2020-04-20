(ns score-calculation
  (:require [clojure.core :refer :all]
            [clojure.string :refer :all :as str]))

(def tie-map {0 "love"
              1 "fifteen"
              2 "thirty"
              3 "fourty"})

(defn- no-negative-input [input]
  (not (or (neg? (first input)) (neg? (second input)))))

(defn- valid-input?
  [input]
  (no-negative-input input))

(defn- to-tennis-score
  [score]
  (get tie-map score))

(defn- is-tie?
  [scores]
  (= (first scores) (second scores)))

(defn- is-deuceable?
  [scores]
  (and (< 2 (first scores)) (< 2 (second scores))))

(defn- shout-advantage
  [scores]
  "advantage player 1")

(defn- shout-score
  [scores]
  (str/join " " (map to-tennis-score scores)))

(defn score
  [scores]
  (if-not (valid-input? scores)
    "invalid input"
    (cond
      (is-deuceable? scores) (if (is-tie? scores)
                               "deuce"
                               (shout-advantage scores))
      :else (shout-score scores))))