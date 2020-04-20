(ns game-test
  (:require [clojure.test :refer :all]
            [score-calculation :refer :all]))

(deftest game-tests
  (testing "tennis scores"
           (is (= "love love" (score [0 0])))
           (is (= "love fifteen" (score [0 1])))
           (is (= "fifteen fifteen" (score [1 1])))
           (is (= "invalid input" (score [-1 0])))))