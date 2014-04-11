(ns acker.core-test
  (:require [clojure.test :refer :all]
            [acker.core :refer :all]))

(deftest ackermann-test
  (testing "ack-1, ack-2, ack-3"
    (are [m n e]
         (= (ack-1 m n) (ack-2 m n) (ack-3 m n) e)
         0 0  1
         0 1  2
         0 2  3
         0 3  4
         0 4  5
         1 0  2
         1 1  3
         1 2  4
         1 3  5
         1 4  6
         2 0  3
         2 1  5
         2 2  7
         2 3  9
         2 4 11
         3 0  5
         3 1 13
         3 2 29)))

(deftest ^:slow ackermann-slow-test
  (testing "ackermann (slow)"
    (are [m n e] (= (ack-3 m n) e)
         3 3     61
         3 4    125
         4 0     13
         4 1  65533)))
