(ns cantoresque.core
  (:require [clojure.set :as set]))

(defn cross-join [left right]
  (set/join left right))

(defn inner-join [left right km]
  (set/join left right km))

(defn left-join [left right km])

(defn outer-join [left right km]
  nil)
