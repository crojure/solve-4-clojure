(ns solve-4-clojure.coalesce
  (:require [clojure.set :as set]))

(defn intersect? [first second]
  (not (empty? (set/intersection first second))))

(defn get-matches [pair pairs]
  (filter #(intersect? pair %) pairs))

(defn get-matches-union [pair pairs]
  (set/union
    (reduce set/union
            (get-matches pair pairs)) pair))

(defn get-non-matches [pair pairs]
  (filter #(not (intersect? pair %)) pairs))

(defn merge-pair [pair pairs]
  (let [match-union (get-matches-union pair pairs)
        non-matches (get-non-matches pair pairs)]
    (conj non-matches match-union)))

(defn merge-next [source dest]
  (if (empty? source)
    dest
    (let [next (first source)
          result (merge-pair next dest)]
      (println next " + " dest " = " result)
      (recur (rest source) result))))

(defn coalesce [pairs]
  (merge-next (map set pairs) #{}))

(println (coalesce [[1 2] [3 4] [5 6] [7 8] [1 5] [4 6]]))