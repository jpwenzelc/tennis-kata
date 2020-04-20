(ns game-test
  (:require [clojure.test :refer :all]
            [score-calculation :refer :all]))

(deftest game-tests
  (testing "will return 'love love' when given a 0 0 score"
           (is (= "love love" (score 0 0)))))