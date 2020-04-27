(ns game
  (:require [clojure.core :refer :all]
            [score-calculation :refer :all]))

(def game-score [0 0])

(defn -main [& args]
  (println "Welcome to a console tennis game")
  (println "to play you have to input 1 or 2")
  (println "to define who won the last point,")
  (println "after that the console will output")
  (println "the current score, and prompt a new")
  (println "input.")
  (println (str "The current score is " (score game-score))))