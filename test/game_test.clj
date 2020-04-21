(ns game-test
  (:require [clojure.test :refer :all]
            [score-calculation :refer :all]))

(deftest game-tests
  (testing "tennis scores"
           (is (= "love love" (score [0 0])))
           (is (= "love fifteen" (score [0 1])))
           (is (= "fifteen fifteen" (score [1 1])))
           (is (= "thirty fifteen" (score [2 1])))
           (is (= "fifteen thirty" (score [1 2])))
           (is (= "fourty thirty" (score [3 2])))
           (is (= "thirty fourty" (score [2 3])))
           (is (= "invalid input" (score [-1 0])))
           (is (= "invalid input" (score [0 -1])))
           (is (= "invalid input" (score [-2 -6])))
           (is (= "deuce" (score [3 3])))
           (is (= "advantage player 1" (score [4 3])))
           (is (= "advantage player 2" (score [3 4])))))