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

(defn- winning-player
  [scores]
  (if (> (first scores) (second scores))
    "1"
    "2"))

(defn- shout-advantage
  [scores]
  (str "advantage player " (winning-player scores)))

(defn- shout-score
  [scores]
  (str/join " " (map to-tennis-score scores)))

(defn- is-winning-by-2?
  [score1 score2]
  (< 1 (Math/abs (- score1 score2))))

(defn- is-won?
  [scores]
  (let [score1 (first scores)
        score2 (second scores)]
    (or (< 3 (Math/abs (- score1 score2)))
        (and (is-deuceable? scores) (is-winning-by-2? score1 score2)))))

(defn- shout-winner
  [scores]
  (str "player " (winning-player scores) " wins"))

(defn score
  [scores]
  (if-not (valid-input? scores)
    "invalid input"
    (cond
      (is-won? scores) (shout-winner scores)
      (is-deuceable? scores) (if (is-tie? scores)
                               "deuce"
                               (shout-advantage scores))
      :else (shout-score scores))))