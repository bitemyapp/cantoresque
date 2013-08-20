(ns cantoresque.core
  (:require [clojure.set :as set]))

(defn cross-join [left right]
  (set/join left right))

(defn inner-join [left right fns]
  (set/join left right fns))
