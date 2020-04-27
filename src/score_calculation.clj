(ns score-calculation
  (:require [clojure.core :refer :all]
            [clojure.string :refer :all :as str]))

(def tie-map {0 "love"
              1 "fifteen"
              2 "thirty"
              3 "fourty"})

(defn- valid-input?
  [input]
  (not-any? neg? input))

(defn- to-tennis-score
  [score]
  (get tie-map score))

(defn- is-tie?
  [scores]
  (reduce = scores))

(defn- is-deuceable?
  [scores]
  (every? true? (map #(< 2 %) scores)))

(defn- winning-player
  [scores]
  (if (> (first scores) (second scores))
    "1"
    "2"))

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
  (if (= "1" (winning-player scores))
    :player1-victory
    :player2-victory))

(defn- shout-deuce
  []
  (str "deuce"))

(defn- shout-advantage
  [scores]
  (str "advantage player " (winning-player scores)))

(defn- shout-score
  [scores]
  (str/join " " (map to-tennis-score scores)))

(defn score
  [scores]
  (if-not (valid-input? scores)
    "invalid input"
    (cond
      (is-won? scores) (shout-winner scores)
      (and (is-deuceable? scores) (is-tie? scores)) (shout-deuce)
      (is-deuceable? scores) (shout-advantage scores)
      :else (shout-score scores))))