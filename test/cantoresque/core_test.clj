(ns cantoresque.core-test
  (:require [clojure.test :refer :all]
            [clojure.set :as set]
            [cantoresque.core :refer :all]))

(def left-set
  #{{:name "Jose Valim" :awesome true}
    {:name "Joe Armstrong" :awesome true}
    {:name "John McCarthy" :awesome true}
    {:name "Chris Allen"}})

(def right-set
  #{{:name "Jose Valim" :lang "Elixir"}
    {:name "Joe Armstrong" :lang "Erlang"}
    {:name "John McCarthy" :lang "LISP"}
    {:name "Chris Allen"}})

(deftest set-joins
  (testing "Cartesian joins"
    (is (= (cross-join left-set right-set)
           (set/join left-set right-set))))
  (testing "Inner joins"
    (is (= (inner-join left-set right-set {:name :name})
           (set/join left-set right-set {:name :name})))))
