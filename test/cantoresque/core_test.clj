(ns cantoresque.core-test
  (:require [clojure.test :refer :all]
            [clojure.set :as set]
            [cantoresque.core :refer :all]))

(def left-set
  #{{:name "Jose Valim" :awesome true}
    {:name "Chris Allen"}
    {:awesome nil}})

(def right-set
  #{{:name "Jose Valim" :lang "Elixir"}
    {:name "Chris Allen" :blah true}
    {:lang "C"}})

(deftest set-joins
  (testing "Cartesian joins"
    (is (= (cross-join left-set right-set)
           (set/join left-set right-set))))
  (testing "Inner joins"
    (is (= (inner-join left-set right-set {:name :name})
           (set/join left-set right-set {:name :name}))))
  (testing "Outer joins"
    (is (= (outer-join left-set right-set {:name :name})
           #{{:name "Jose Valim" :lang "Elixir" :awesome true}
             {:name "Chris Allen" :blah true}
             {:awesome nil}
             {:lang "C"}}))))
