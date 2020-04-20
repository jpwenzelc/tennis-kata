(ns game-test
  (:require [clojure.test :refer :all]
            [score-calculation :refer :all]))

(deftest game-tests
  (testing "will return 'love love' when given a 0 0 score"
           (is (= "love love" (score [0 0]))))
  (testing "will return 'love fifteen' when given a 0 1 score"
           (is (= "love fifteen" (score [0 1]))))
  (testing "will return 'fifteen fifteen' when given a 1 1 score"
           (is (= "fifteen fifteen" (score [1 1]))))
  )